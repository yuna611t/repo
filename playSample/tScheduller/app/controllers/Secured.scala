package controllers

import play.api._
import play.api.mvc._

trait Secured {
	private def username(request: RequestHeader) = request.session.get(Security.username)

	// 未認証時のリダイレクト先
	private def onUnauthorized(request: RequestHeader) = {
		println("未認証ユーザ: " + username(request))
		Results.Redirect(routes.LoginController.showLoginForm)
	}

	// Actionに認証をかませてラップ
	// Securityセッションにユーザ名があれば認証済状態とする
	def IsAuthenticated(f: => String => Request[AnyContent] => Result) = 
		Security.Authenticated(username, onUnauthorized) { user => 
			println("認証済ユーザ: " + user)
			Action(request => f(user)(request))
		}
}