object Upper {
	def upper(strings: String*) = strings.map(_.toUpperCase())	
}

// sbt consoleで実行
// println(Upper.upper("Hello","First"))