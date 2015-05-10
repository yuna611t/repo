import play.api.Application
import play.api.GlobalSettings
import play.api.Play.current
import play.api.db.slick.Config.driver.simple._
import models._

object Global extends GlobalSettings {

  override def onStart(app: Application) {
  	// 初期ユーザの挿入
    play.api.db.slick.DB withSession { implicit session =>
      println("初期ユーザ作成")
      UserDAO.create(User(0,"admin","pass"))
      println("初期ユーザ一覧")
      for(u <- UserDAO.search("a")) {
      	println(u)
      }
    }
  }

}