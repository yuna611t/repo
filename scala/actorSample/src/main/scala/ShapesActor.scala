package shapes

import akka.actor._


object ShapeActor {
	def main(args: Array[String]) = {
		val system = ActorSystem("ShapeSystem")
		val actor = system.actorOf(Props[ShapeDrawingActor])

		actor ! new Circle(new Point(0.0, 0.0), 1.0)
		actor ! new Rectangle(new Point(0.0, 0.0), 2, 5)
		actor ! 3.14159
		actor ! "exit"

	}
}


class ShapeDrawingActor extends Actor {
	def receive = {
		case s: Shape => s.draw()
		case "exit" => println("exiting..."); context.system.shutdown
		case x: Any => println("Error: Unknown message! " + x)
	}
}


class Point (val x: Double, val y: Double) {
	override def toString() = "Point(" + x + "," + y + ")"
}

abstract class Shape() {
	def draw(): Unit
}

class Circle(val center: Point, val radius: Double) extends Shape {	
	def draw() = println("Circle.draw: " + this)
	override def toString() = "Circle(" + center + "," + radius + ")"
}

class Rectangle (val lowerLeft: Point, val height: Double, val width: Double) extends Shape {
	def draw() = println("Rectagle.draw: " + this)
	override def toString() = "Rectangle(" + lowerLeft + "," + height + "," + width + ")"
}
