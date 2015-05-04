package scalafx

import scalafx.application.{ConditionalFeature, JFXApp, Platform}
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene
import scalafx.scene.layout.HBox
import scalafx.scene.paint.Color

object ConditionalFeatureTester extends JFXApp {
	for (cf <- ConditionalFeature.values) {
		val isSupported = try {
			Platform.isSupported(cf)
		} catch {
			case _: Throwable => false
		}
		println(cf.toString() + " : " + isSupported)
	}
}