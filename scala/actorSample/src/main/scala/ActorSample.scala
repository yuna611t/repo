import akka.actor.ActorSystem
import akka.actor.Props
import akka.actor.Actor
import akka.routing.RoundRobinRouter

/**
* akka.actorの動きについて勉強
* sbtからの実行方法
* sbt 'run-main ActorSample Hello'
* sbt 'run-main ActorSample World'
* sbt 'run-main ActorSample What'
*
* @author yuna
*/
object ActorSample {
	def main(args: Array[String]) = {

		// ActorSystemをsystemという名前で作成
		val system = ActorSystem("system")
		// system(ActorSystemにSampleActorを登録
		val router = system.actorOf(Props[SampleActor].withRouter(RoundRobinRouter(4)))

		// メッセージ送信
		router ! args(0)
		// system(ActorSystem)の終了
		system.shutdown
	}
}

/**
* Actorの定義
* @author yuna
*/
class SampleActor extends Actor {
	// 受け取ったメッセージに対して処理を定義
	def receive = {
		case "Hello" => println("Hello World!!")
		case "World" => println("We are the World!!")
		case _ => println("Bad World!!")
	}
}