// sbtでの実行方法は下記
// sbt 'run-main Upper3 Who am i'

object Upper3 {
	def main(args: Array[String]) = {
		args.map(_.toUpperCase()).foreach(printf("%s ", _))
		println("")
	}

}
