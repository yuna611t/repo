package controllers

import play.api._
import play.api.mvc._

import play.api.data._
import play.api.data.Forms._
import play.api.data.validation._

import play.api.db.slick._
import models._

import play.api.Play.current

/**
* コントローラオブジェクトの定義
*/
object ScheduleController extends Controller with Secured {

	/**
	* フォームの定義
	*/
	val scheduleForm = Form (
		mapping (
			"ID" -> longNumber,
			"name" -> nonEmptyText(maxLength = 140),
			"date" -> text.verifying(Constraints.pattern("([1-9]|1[0-2])/([1-9]|[1-2][0-9]|3[0-1])".r)), // 1/1~12/31の正規表現 (詳細チェックはフロントに任す)
			"timeFrom" -> text.verifying(Constraints.pattern("(0[0-9]|1[0-9]|2[0-3]):([0-5][0-9])".r)),  // 00:00~23:59の正規表現 (詳細チェックはフロントに任す)
			"timeTo" -> text.verifying(Constraints.pattern("(0[0-9]|1[0-9]|2[0-3]):([0-5][0-9])".r)),    // 00:00~23:59の正規表現 (詳細チェックはフロントに任す)
			"comment" -> text(maxLength = 140)
		)(Schedule.apply)(Schedule.unapply)
	)

	/**
	* ユーザ情報登録フォーム表示アクションメソッドの定義
	*/
	def showCreateForm() = IsAuthenticated { username => implicit request =>
		Ok(views.html.schedule.scheduleCreateForm(username, scheduleForm))
	}

	/**
	* ユーザ情報登録アクションメソッドの定義
	*/
	def create() = IsAuthenticated { username => implicit request =>
		DB.withSession { implicit session =>
			scheduleForm.bindFromRequest.fold(
				errors => BadRequest(views.html.schedule.scheduleCreateForm(username, errors)),
				schedule => {
					println("スケジュール新規登録: " + schedule)
					ScheduleDAO.create(schedule)
					Redirect(routes.ScheduleController.search(schedule.name,schedule.date))
				}
			)
		}
	}

	 def search(name:String, date: String) = IsAuthenticated { username => implicit request =>
	 	DB.withSession { implicit session =>
	 		Ok(views.html.schedule.scheduleSearch(username, name, date, ScheduleDAO.search(name, date)))
		}
	  }



}