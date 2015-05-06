package ui {
	abstract class Widget
	trait Clickable {
		def click()
	}

	/**
	* ボタンの見た目とクリック処理にのみ関心ごとを限定した例
	* ボタンの見た目
	* クリック処理
	*/
	class Button(val label: String) extends Widget with Clickable{
		def click() = {
			println("クリックされたボタンの見た目を変更するロジックB")
		}
	}

	import observer._
	/**
	* ボタンのクリックの観察のみに集中
	*/
	trait ObservableClicks extends Clickable with Subject {
		abstract override def click() = {
			super.click()
			notifyObservers
		}
	}

	class ButtonCountObserver {
		var count = 0
		def receiveUpdate(subject: Any) = count += 1
	}

	/**
	* ２回以上のクリックを拒否するトレイト
	*/
	trait VetoableClicks extends Clickable {
		val maxAllowd = 1
		private var count = 0

		abstract override def click() = {
			if (count < maxAllowd) {
				count += 1
				super.click()
			}
		}
	}

}

package observer {

	trait Subject {
		type Observer = { def receiveUpdate(subject: Any)}
		private var observers = List[Observer]()
		def addObserver(observer: Observer) = observers ::= observer
		def notifyObservers = observers foreach (_.receiveUpdate(this))
	}
}