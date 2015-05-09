package controllers

import play.api._
import play.api.mvc._

import play.api.data._
import play.api.data.Forms._

import play.api.db.slick._
import models._

object LoginController extends Controller with Secured{

	/**
	* フォームの定義
	*/
	val loginForm = Form (
		mapping (
			"ID" -> longNumber,
			"name" -> nonEmptyText(maxLength = 140),
			"pass" -> nonEmptyText(maxLength = 140)
		)(User.apply)(User.unapply)
	)


  def showLoginForm = Action { request => 
		Ok(views.html.loginForm(loginForm))
  }

  def login = DBAction { implicit rs =>
		loginForm.bindFromRequest.fold(
			errors => BadRequest(views.html.loginForm(errors)),
			user => {
				println(UserDAO.authenticate(user))
			 	UserDAO.authenticate(user) match {
					case s: Some[User]  => Redirect(routes.UserController.search())
					case _ => Ok(views.html.loginForm(loginForm))
				}
			}
		)
  }


}