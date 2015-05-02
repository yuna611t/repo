import scala.swing._
import scala.swing.event._

object TodoApp extends SimpleSwingApplication {
	def top = new MainFrame {
		
		// Window title
		title = "ToDoApp"
		// Window Size
		minimumSize = new Dimension(300, 200)

		// Contents
		contents = gridPanel

	}


		// Contents Layout
		val gridPanel = new GridPanel(2,2) {
			contents += new Label("Task1")
			contents += new Label("Pending") {
				listenTo(mouse.clicks) 
				reactions += {
					case e: MousePressed => {
						text match {
							case "Done" =>  text = "Pending"
							case "Pending" =>  text = "Done"
							case _ =>  text = ""
						}
					}
				}
			}


			contents += new Button("Done") {
				reactions += {
					case e: ButtonClicked => Dialog.showMessage(message = "Done")
				}
			}
			contents += new Button("Pending") {
				reactions += {
					case e: ButtonClicked => Dialog.showMessage(message = "Pending")
				}
			}
		}


}