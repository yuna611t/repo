package scalafx

import scala.language.postfixOps
import scalafx.Includes._ 
import scalafx.animation.{Interpolator, Timeline}
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene
import scalafx.scene.paint.Color
import scalafx.scene.shape.Rectangle

object JavaFXAnimation extends JFXApp {
	val rect1 = new Rectangle {
		width = 100
		height = 100
		fill = Color.RED
	}
	val rect2 = new Rectangle {
		width = 50
		height = 50
		fill = Color.LIGHTGREEN
	}
	val timeline = new Timeline {
		cycleCount = Timeline.INDEFINITE
		autoReverse = true
		keyFrames = Seq (
			at(2 s) {rect1.x -> 200d tween Interpolator.EASE_IN},
			at(4 s) {rect1.x -> 300d},
			at(3 s) {rect2.y -> 100d tween Interpolator.EASE_BOTH},
			at(4 s) {rect2.y -> 300d},
			at(4 s) {rect2.width -> 300d tween Interpolator.EASE_OUT}
		)
	}

	timeline.play()
	stage = new PrimaryStage {
		scene = new Scene {
			content = List(rect1, rect2)
		}
	}
}