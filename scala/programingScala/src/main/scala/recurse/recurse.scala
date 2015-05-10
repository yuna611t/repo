object RecurseScript {

	def main(args: Array[String]) = {
		println(fact(5))
		println(facti(5,1))
	}

	/**
	* 再帰
	*/
	def fact(n: Int): BigInt = n match {
		case _ if (n == 0) => 1
		case _ => n * fact(n - 1)
	}

	/**
	* 末尾再帰
	*/
	def facti(n: Int, a: BigInt): BigInt = n match {
		case _ if (n == 0) => a
		case _ => facti(n - 1, a * 2)
	}

}