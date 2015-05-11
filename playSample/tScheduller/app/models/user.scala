package models

import play.api.db.slick.Config.driver.simple._
import play.api.Play.current

/**
* DTOの定義
*/
case class User(ID: Long, name: String, pass: String)

/**
* テーブルスキーマの定義
*/
class UserTable(tag: Tag) extends Table[User](tag, "user") {
	def ID = column[Long]("id", O.PrimaryKey, O.AutoInc)
	def name = column[String]("name", O.NotNull)
	def pass = column[String]("pass", O.NotNull) // 後で別テーブルで管理する
	def * = (ID, name, pass) <> (User.tupled, User.unapply)
}

/**
* DAOの定義
*/
object UserDAO {
	lazy val userQuery = TableQuery[UserTable]

	/**
	* キーワード検索
	* @param word
	*/
	def search(word: String)(implicit s: Session): List[User] = {
		userQuery.filter(row => (row.name like "%" + word + "%")).list
	}

	/**
	* ID検索
	* @param ID
	*/
	def searchByID(ID: Long)(implicit s: Session): User = {
		userQuery.filter(_.ID === ID).first
	}

	/**
	* 認証
	* @param user
	*/
	def authenticate(name: String, pass: String): Option[User] = {
		play.api.db.slick.DB.withSession{implicit session =>
			userQuery
			.filter(row => (row.name === name) && (row.pass === pass))
			.firstOption
		}
	}

	/**
	* 作成
	* @param user
	*/
	def create(user: User)(implicit s: Session) {
		userQuery.insert(user)
	}

	/**
	* 更新
	* @param user
	*/
	def update(user: User)(implicit s: Session) {
		userQuery.filter(_.ID === user.ID).update(user)
	}

	/**
	* 削除
	* @param user
	*/
	def remove(user: User)(implicit s: Session) {
		userQuery.filter(_.ID === user.ID).delete
	}

}