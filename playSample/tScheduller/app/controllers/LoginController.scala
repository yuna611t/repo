package controllers

import play.api._
import play.api.mvc._

import play.api.data._
import play.api.data.Forms._

import play.api.db.slick._
import models._

import play.api.Play.current

/**
* ログイン処理を行うコントローラ
*/
object LoginController extends Controller with Secured {

	/**
	* フォームの定義
	*/
	val loginForm = Form[(String, String)] (
		tuple (
			"name" -> nonEmptyText(maxLength = 140),
			"pass" -> nonEmptyText(maxLength = 140)
		) verifying("Invalid name or password", result => 
			result match {
				case (name, pass) => check(name, pass)
			}
		)
	)

	 /**
	 * ログインフォーム
	 * 未認証時に表示するViewのコントローラ
	 */
	 def showLoginForm = Action { request => 
		Ok(views.html.loginForm(loginForm))
	}

	/**
	* ログイン処理
	*/
	def login = DBAction { implicit rs =>
			loginForm.bindFromRequest.fold(
				errors => {
					println("login error: " + errors)
					// ログイン失敗の場合セッション消去
					BadRequest(views.html.loginForm(errors)).withNewSession.flashing()
				},
				user => {
					println("login success: " + user)
					// ログイン成功の場合、ユーザ名をセッションに格納し持ち回る
					Redirect(routes.Application.index).withSession(Security.username -> user._1)
				}
			)
	  }


	/**
	* 認証チェック
	*/
	def check(name: String, pass: String) = {
		println("チェック対象: "); println("  + name: " + name); println("  + pass: " + pass)
		println("チェック結果: "+ UserDAO.authenticate(name , pass))

		// ユーザテーブルに街頭ユーザがいるかチェック
		UserDAO.authenticate(name, pass) match {
			case s: Some[User]  => true
			case _ => false
		}

	}


}