package actorsample3

import akka.actor._
import akka.routing._


//  πの計算のためのメッセージ群
sealed trait PiMessage
/** Master actorに送る計算の開始メッセージ */
case object Calculate extends PiMessage
/** Master actorからWorker actorに送るメッセージ(作業割当) */
case class Work(start: Int, nrOfElements: Int) extends PiMessage
/** Worker actorからMaster actorに送るメッセージ(Worker actorの計算結果) */
case class Result(value: Double) extends PiMessage
/** MAster actorからListener actorに送るメッセージ(計算の最終結果と処理時間) */
case class PiApproximation(pi: Double, duration: Long)

/**
* 実際に計算を行うアクター
* 受け取るメッセージ Work
*/
class Worker extends Actor {
	/**
	* πの計算(ライプニッツの公式)
	* @param start
	* @param nrOfElements
	* @return 計算結果
	*/
	def calculatePiFor(start: Int, nrOfElements: Int): Double = {
		var acc = 0.0
		for (i <- start until (start + nrOfElements)) 
			acc += 4.0 * (1 - (i%2) * 2) / (2 * i + 1) 
			// 概算計算結果(start=0,nrOfElements=3の場合) => 1週目
				// i = 0 => 4.0 * (1)
				// i = 1 => 4.0 * (-1/3)
				// i = 2 => 4.0 * (1/5)
				// acc1 = 4.0(1 -1/3 + 1/5) => 4.0 * π/4 => π
			// 概算計算結果(start=3,nrOfElements=3の場合) => 2週目
				// i = 3 => 4.0 * (-1/7)
				// i = 4 => 4.0 * (1/9)
				// i = 5 => 4.0 * (-1/11)
				// acc2 = 4.0(-1/7 + 1/9 - 1/11)
			// accを加算していくと(Masterで集約している内容)
				// acc = acc1 + acc2 = 4.0 * (1 -1/3 + 1/5 -1/7 + 1/9 -1/11) => 4.0 * 1/π
		acc
	}
	/**
	* このアクターでの計算結果をMasterに返却する
	* @param start 
	* @param nrOfElements 
	*/
	def receive = {
		case Work(start, nrOfElements) => 
			sender ! Result(calculatePiFor(start, nrOfElements))
	}
}

/**
* 各Actorにメッセージを送信する
* 
* @param nrOfWorkers Workerをいくつ起動するか
* @param nrOfMessages Workerにいくつのチャンクを送るか
* @param nrOfElements Workerにどれくらいの大きさのチャンクを送るか
* @param Listener 最終結果をMasterの外で使うためのハンドル
*/
class Master(nrOfWorkers: Int, nrOfMessages: Int, nrOfElements: Int, Listener: ActorRef) extends Actor {
	var pi: Double = _
	var nrOfResults: Int = _
	val start: Long = System.currentTimeMillis

	val workersRouter = context.actorOf(Props[Worker].withRouter(RoundRobinRouter(nrOfWorkers)), name = "workersRouter")

	def receive = {
		case Calculate =>
			// メッセージ数の分だけWorkerにメッセージ送信
			// i = 0の場合 => Work(0,     10000) => 0-9999までを計算依頼
			// i = 1の場合 => Work(10000, 10000) => 10000-19999までを計算依頼
			// i = 2の場合 => Work(20000, 10000) => 20000-29999までを計算依頼
			// i = 3の場合 => Work(30000, 10000) => 30000-39999までを計算依頼
			for (i <- 0 until nrOfMessages) 
				workersRouter ! Work(i * nrOfElements, nrOfElements)
		case Result(value) =>
			// Workerの計算結果を加算していく
			pi += value
			// Resultメッセージ(計算終了したWorker)の数をカウント
			nrOfResults += 1
			// 計算終了したWorkerの数と送信したメッセージの数が一致したら、Listner actorにメッセージ送信
			if (nrOfResults == nrOfMessages) {
				Listener ! PiApproximation(pi, duration = (System.currentTimeMillis - start))
				// 自分と管理下のアクターを停止する
				context.stop(self)
			}
	}

}

/**
* 結果の出力とActorSystemのシャットダウンを行う
*/
class Listener extends Actor {
	def receive = {
		case PiApproximation(pi, duration) =>
			println("Pi approximation: %s¥nCaluculation time: %s".format(pi, duration))
			context.system.shutdown()
	}
}


/**
* πの計算をActorを使用して行う
*
*/
object AkkatestApp {
	def main(args: Array[String]): Unit = {
		val input = readLine("1: sequence 2:parallel¥n ")
		if (input == "1")
			calculate(nrOfWorkers = 1, nrOfElements = 10000, nrOfMessages = 10000)
		else if (input == "2")
			calculate(nrOfWorkers = 4, nrOfElements = 10000, nrOfMessages = 10000)
		else
			println("wrong num")
	}

	/**
	* Actorにメッセージを送る
	*
	* @param nrOfWorkers ワーカー数
	* @param nrOfMessages Actorに送るメッセージ数
	* @param nrOfElements Element数
	*/
	def calculate(nrOfWorkers: Int, nrOfElements: Int, nrOfMessages: Int) {
		val system = ActorSystem("PiSystem")
		val listener = system.actorOf(Props[Listener], name = "Listener")
		val master = system.actorOf(Props(new Master(nrOfWorkers, nrOfMessages, nrOfElements, listener)))

		master ! Calculate
	}
}

