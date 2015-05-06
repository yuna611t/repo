package ui

import org.specs2._
import observer._

object ButtonObserverSpec extends Specification { def is = s2"""

ボタンのオブザーバは

  ボタンのクリックを観察する	$e1
                                                                 """

  def e1 = {
	  val observableButton = new Button("Okay") with ObservableClicks
	  val buttonClickCountObserver = new ButtonCountObserver
	  observableButton.addObserver(buttonClickCountObserver)

	  for (i <- 1 to 3) observableButton.click()
	  buttonClickCountObserver.count mustEqual 3
  }


}