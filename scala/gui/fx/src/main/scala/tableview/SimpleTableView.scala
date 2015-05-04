package tableview 

import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.collections.ObservableBuffer
import scalafx.scene.Scene
import scalafx.scene.control.TableColumn._
import scalafx.scene.control.{TableCell, TableColumn, TableView}
import scalafx.scene.paint.Color
import scalafx.scene.shape.Circle

object SimpleTableView extends JFXApp {

	val characters = ObservableBuffer[Person] (
		new Person("Peggy", "Sue", "555-6789", Color.VIOLET),
		new Person("Rocky", "Raccoon", "555-6798", Color.GREEN),
		new Person("Desmond", "Sue", "555-8036", Color.DARKSALMON),
		new Person("Molly", "RAccoon", "555-0789",Color.BLUE)
	)

	stage = new PrimaryStage {
		title = "Simple Table View"
		scene = new Scene {
			val firstNameColumn = new TableColumn[Person, String] {
				text = "First Name"
				cellValueFactory = {_.value.firstName}
				prefWidth = 180
			}
			val lastNameColumn = new TableColumn[Person, String] {
				text = "Last Name"
				cellValueFactory = {_.value.lastName}
				prefWidth = 180
			}
			// Nested Column
			val nameColumn = new TableColumn[Person, String] {
				text = "Name"
				columns += (firstNameColumn, lastNameColumn)
			}

			val phoneColumn = new TableColumn[Person, String] {
				text = "phone"
				cellValueFactory = {_.value.phone}
				prefWidth = 180
			}

			val colorColumn = new TableColumn[Person, Color] {
				text = "Favorit Color"
				cellValueFactory = {_.value.favoriteColor}
				cellFactory = {
					_ => new TableCell[Person, Color] {
						item.onChange {
							(_, _, newColor) => graphic = new Circle {fill = newColor; radius = 8}
						}
					}
				}
				prefWidth = 180
			}

			content = new TableView[Person](characters) {
				columns += (nameColumn, phoneColumn, colorColumn)
				sortOrder += (phoneColumn, lastNameColumn, firstNameColumn)
			}
		}
	}
}