import scala.swing.Dimension
import scala.swing.BoxPanel
import scala.swing.Label
import scala.swing.MainFrame
import scala.swing.Orientation
import scala.swing.SimpleSwingApplication

import java.awt.Color

import javax.swing.border.LineBorder


object MainFrameSample extends SimpleSwingApplication {
    def top = new MainFrame {
        // Title 
        title = "Window Title"
        // Window Size
        minimumSize = new Dimension(300, 200)
        // set Contents for Panel
        contents = new BoxPanel(Orientation.Vertical) {
        	// Panel Content
        	contents += new Label("Who am I")
        	contents += new Label("Lush Hour")
        	contents += new Label("Police Story")

        	// background
        	background = Color.CYAN

        	// Border
        	border = new LineBorder(Color.WHITE, 3)

        }

    }
}
