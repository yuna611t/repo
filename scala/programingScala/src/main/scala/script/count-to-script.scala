/**
* 入れ子のメソッドから外の変数を使えることの確認
*
*/
object countTo {
	def main(args: Array[String]) = {
		countTo(5)
	}

	def countTo(n: Int): Unit = {
		def count(i: Int): Unit = {
			if ( i <= n) { // メソッドcountの外の変数nを参照
				println(i)
				count(i + 1)
				println("n = " + n)
			}
	}
	count(1)
}
}