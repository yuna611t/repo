package ui

import org.specs2._
import observer._

object ButtonObserverSpec extends Specification { def is = s2"""

ボタンのオブザーバは
  ボタンのクリックを観察する  $e1

拒否可能なクリックをミックスインするボタンのオブザーバは
  最初のボタンのクリックだけ観察する  $e2
                                                                 """

  def e1 = {
	  val observableButton = new Button("Okay") with ObservableClicks
	  val buttonClickCountObserver = new ButtonCountObserver
	  observableButton.addObserver(buttonClickCountObserver)

	  for (i <- 1 to 3) observableButton.click()
	  buttonClickCountObserver.count mustEqual 3
  }

  def e2 = {
  	val observableButton = 
  		new Button("Okay") with ObservableClicks with VetoableClicks
  	val buttonClickCountObserver = new ButtonCountObserver
  	observableButton.addObserver(buttonClickCountObserver)

  	for (i <- 1 to 3) observableButton.click()
  	buttonClickCountObserver.count mustEqual 1

  }

}