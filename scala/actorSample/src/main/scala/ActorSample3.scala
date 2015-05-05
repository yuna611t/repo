package actorsample3

import akka.actor.{ActorSystem,Props,Actor}


/**
* akka.actorの動きについて勉強
* @author yuna
*/
object ActorSample {
	def main(args: Array[String]) = {
		val system = ActorSystem("system3")
		val superActor = system.actorOf(Props[SupervisorActor], "supervisorActor")

		superActor ! "Hello"
		superActor ! ForChild("Hello")

		system.shutdown
	}
}


case class ForChild(msg: String)
case class Child()

class ChildActor extends Actor {
	def receive = {
		case msg: String => println("(Child): " +msg)
	}
}

class SupervisorActor extends Actor {
	override def preStart = {
		context.actorOf(Props[ChildActor], "childActor")
	}

	def receive = {
		case msg: String => println("(Supervisor:) " + msg)
		case ForChild(msg: String) => context.actorFor("childActor") ! msg
		case Child => sender ! context.actorFor("childActor")
	}
}

