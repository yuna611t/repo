package controllers

import play.api._
import play.api.mvc._

import play.api.data._
import play.api.data.Forms._

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
			"date" -> nonEmptyText(maxLength = 140),
			"timeFrom" -> nonEmptyText(maxLength = 6),
			"timeTo" -> nonEmptyText(maxLength = 6),
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