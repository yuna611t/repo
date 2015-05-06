package ui {
	abstract class Widget
	/*
	* ボタンとコールバックが分離していない例
	* ボタンの見た目を決めるコンストラクタ
	* 複数のコールバック(clickedCallbacksリスト)を管理するロジック
	*/
	class ButtonWithCallbacks(val label: String, 
	    val clickedCallbacks: List[() => Unit]) extends Widget {
		require(clickedCallbacks != null, "Callback list can(t be null!")

		def this(label: String, clickedCallback: () => Unit) = 
			this(label, List(clickedCallback))

		def this(label: String) = {
			this(label,Nil)
			println("Warning: button has no click callbacks!")
		}

		def click() = {
			clickedCallbacks.foreach(f => println("クリックされたボタンの見た目を変更するロジックA" + f() ) )
		}
	}

	/**
	* ボタンの見た目とクリック処理にのみ関心ごとを限定した例
	* ボタンの見た目
	* クリック処理
	*/
	class Button(val label: String) extends Widget {
		def click() = {
			println("クリックされたボタンの見た目を変更するロジックB")
		}
	}

	import observer._
	class ObservableButton(name: String) extends Button(name) with Subject {
		override def click() = {
			super.click()
			notifyObservers
		}
	}

	class ButtonCountObserver {
		var count = 0
		def receiveUpdate(subject: Any) = count += 1
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