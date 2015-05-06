package ui

import org.specs2._
import observer._

object ButtonObserverSpec extends Specification { def is = s2"""

ボタンのオブザーバは

  	クラス定義時にミックスインしたら、ボタンのクリックを観察する $e1
  	インスタンス生成時にミックスインしたら、ボタンのクリックを観察する	$e2
                                                                 """

  def e1 = {
	  val observableButton = new ObservableButton("Okay")
	  val buttonObserver = new ButtonCountObserver
	  observableButton.addObserver(buttonObserver)

	  for (i <- 1 to 3) observableButton.click()
	  buttonObserver.count mustEqual 3
  }

  def e2 = {
  	val observalbleButton = new Button("Okay") with Subject {
  		override def click() = {
  			super.click()
  			notifyObservers
  		}
  	}
  	val buttonObserver = new ButtonCountObserver
  	observalbleButton.addObserver(buttonObserver)
  	for (i <- 1 to 3) observalbleButton.click()
  	buttonObserver.count mustEqual 3
  }

}