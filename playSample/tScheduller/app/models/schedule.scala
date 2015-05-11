package models

import play.api.db.slick.Config.driver.simple._
import play.api.Play.current

/**
* DTOの定義
* スケジュールテーブル
*/
case class Schedule(ID: Long, name: String, date: String, timeFrom: String, timeTo: String, comment: String)

/**
* テーブルスキーマの定義
*/
class ScheduleTable(tag: Tag) extends Table[Schedule](tag, "schedule") {
	def ID = column[Long]("id", O.PrimaryKey, O.AutoInc)
	def name = column[String]("name", O.NotNull)
	def date = column[String]("date", O.NotNull)  //そのうちOption[LocalDate]に置き換えてみる
	def timeFrom = column[String]("timeFrom")
	def timeTo = column[String]("timeTo")
	def comment = column[String]("comment")
	def * = (ID, name, date, timeFrom, timeTo, comment) <> (Schedule.tupled, Schedule.unapply)
	// Userが外部整合キー
}

/**
* DAOの定義
*/
object ScheduleDAO {
	lazy val scheduleQuery = TableQuery[ScheduleTable]

	/**
	* 検索
	* @param date
	*/
	def search(name: String, date: String)(implicit s: Session): List[Schedule] = {
		// TODO 日付がテキストなのでソート順を修正する必要あり
		if (name == "" && date == "") 
			scheduleQuery
			.sortBy(row => (row.date, row.timeFrom)).list
		else if (name == "" && date != "") 
			scheduleQuery.filter(_.date === date)
			.sortBy(row => (row.date, row.timeFrom)).list
		else if (name != "" && date == "") 
			scheduleQuery.filter(_.name === name)
			.sortBy(row => (row.date, row.timeFrom)).list
		else 
			scheduleQuery
			.filter(row => (row.name === name) && (row.date === date))
			.sortBy(row => (row.date, row.timeFrom)).list
	}

	/**
	* ID検索
	* @param ID
	*/
	def searchByID(ID: Long)(implicit s: Session): Schedule = {
		scheduleQuery.filter(_.ID === ID).first
	}


	/**
	* 作成
	* @param schedule
	*/
	def create(schedule: Schedule)(implicit s: Session) {
		scheduleQuery.insert(schedule)
	}

	/**
	* 更新
	* @param schedule
	*/
	def update(schedule: Schedule)(implicit s: Session) {
		scheduleQuery.filter(_.ID === schedule.ID).update(schedule)
	}

	/**
	* 削除
	* @param schedule
	*/
	def remove(schedule: Schedule)(implicit s: Session) {
		scheduleQuery.filter(_.ID === schedule.ID).delete
	}


}