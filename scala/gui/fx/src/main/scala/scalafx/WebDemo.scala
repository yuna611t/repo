package scalafx

import scalafx.Includes._ 
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene
import scalafx.scene.control._
import scalafx.scene.layout._
import scalafx.scene.paint.Color
import scalafx.scene.web._

object WebDemo extends JFXApp {
	
	val browser = new WebView {
		hgrow = Priority.ALWAYS
		vgrow = Priority.ALWAYS
		onAlert = (e: WebEvent[_]) => println("onAlert: " + e)
		onStatusChanged = (e: WebEvent[_]) => println("onStatusChanged: " + e)
		onResized = (e: WebEvent[_]) => println("onResized: " + e)
		onVisibilityChanged = (e: WebEvent[_]) => println("onVisibleChanged: " + e)
	}

	val engine = browser.engine
	engine.load("http://code.google.com/p/scalafx")

	val txfUrl = new TextField {
		text = engine.location.value
		hgrow = Priority.ALWAYS
		vgrow = Priority.NEVER
	}
	txfUrl.onAction = handle {engine.load(txfUrl.text.get)}

	stage = new PrimaryStage {
		title = "ScalaFX Web Demo"
		width = 800
		height = 600
		scene = new Scene {
			fill = Color.LIGHTGREY
			root = new BorderPane {
				hgrow = Priority.ALWAYS
				vgrow = Priority.ALWAYS
				top = txfUrl
				center = browser
			}
		}
	}



}