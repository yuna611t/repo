/**
* Scalaのfor式の勉強
*/

object ForScript {
	def main(args: Array[String]) = {
		val dogBreeds = List("Doberman", "Yorkshire Terrier", "Dachshund", "Scottish Terrier", "Great Dane", "Portuguese Water Dog")

		// 検証対象
		println("元ネタ: " + dogBreeds)

		// 通常のfor式
		for (breed <- dogBreeds) println ("通常のfor式: " + breed)

		// フィルタ付きのfor式
		for (breed <- dogBreeds 
			if breed.contains("Terrier")
			if !breed.startsWith("Yorkshire") 
		) println("フィルタ付きのfor結果: " + breed)

		// フィルタ結果を受け渡す
		val filterdBreeds = for {
			breed <- dogBreeds
			if breed.contains("Terrier")
			if !breed.startsWith("Yorkshire") 
		} yield breed
		println("フィルタ結果を受け渡す: " + filterdBreeds)

		// for式の内側で定義した変数をfor式本体で使用する
		for {
			breed <- dogBreeds
			upcasedBreed = breed.toUpperCase()
		} println("for式の内側で定義した変数をfor式本体で使用する: " + upcasedBreed)

	}



}