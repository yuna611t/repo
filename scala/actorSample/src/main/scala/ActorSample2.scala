package actorsample2

import akka.actor.{ActorSystem,Props}
import akka.actor.Actor
import akka.pattern.ask
import akka.util.Timeout
import scala.concurrent.duration._
import scala.util.{Success, Failure}
import scala.concurrent.ExecutionContext.Implicits.global

/**
* akka.actorの動きについて勉強
* 戻りのあるActorの勉強
* @author yuna
*/
object ActorSample {
	def main(args: Array[String]) = {
		val system = ActorSystem("system")
		val actor = system.actorOf(Props[SampleActor])

		implicit val timeout = Timeout(5 seconds)
		val reply = actor ? "How are you ?"

		reply.onSuccess {
			case msg: String => println("replay from actor: " + msg)
			case Failure(_) => println("Message Failure")
		}
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
		case "How are you ?" => println("I'm fine")
		case _ => println("Bad World!!")
	}
}