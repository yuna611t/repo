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
object UserController extends Controller with Secured {

	/**
	* フォームの定義
	*/
	val userForm = Form (
		mapping (
			"ID" -> longNumber,
			"name" -> nonEmptyText(maxLength = 140),
			"pass" -> nonEmptyText(maxLength = 140)
		)(User.apply)(User.unapply)
	)

	/**
	* ユーザ情報登録フォーム表示アクションメソッドの定義
	*/
	def showCreateForm() = IsAuthenticated { username => implicit request =>
		Ok(views.html.user.userCreateForm(userForm))
	}

	/**
	* ユーザ情報登録アクションメソッドの定義
	*/
	def create() = IsAuthenticated { username => implicit request =>
		DB.withSession { implicit session =>
			userForm.bindFromRequest.fold(
				errors => BadRequest(views.html.user.userCreateForm(errors)),
				user => {
					UserDAO.create(user)
					Redirect(routes.UserController.search())
				}
			)
		}
	}

	/**
	* ユーザ情報検索アクションメソッドの定義
	*/
	 def search(word: String) = IsAuthenticated { username => implicit request =>
	 	DB.withSession { implicit session =>
		    Ok(views.html.user.userSearch(word, UserDAO.search(word)))
		}
	  }

	/**
	* ユーザ情報更新フォーム表示アクションメソッドの定義
	*/
	def showUpdateForm(ID: Long) = DBAction { implicit rs =>
		Ok(views.html.user.userUpdateForm(ID, userForm.fill(UserDAO.searchByID(ID))))
	}

	/**
	* ユーザ情報更新アクションメソッドの定義
	*/
	def update(ID: Long) = IsAuthenticated { username => implicit request =>
	 	DB.withSession { implicit session =>
			userForm.bindFromRequest.fold(
				errors => BadRequest(views.html.user.userUpdateForm(ID, errors)),
				user => {
					UserDAO.update(user)
					Redirect(routes.UserController.search())
				}
			)
		}
	}

	/**
	* ユーザ情報削除アクションメソッドの定義
	*/
	def remove(ID: Long) = IsAuthenticated { username => implicit request =>
	 	DB.withSession { implicit session =>
			UserDAO.remove(UserDAO.searchByID(ID))
			Redirect(routes.UserController.search())
		}
	}

}