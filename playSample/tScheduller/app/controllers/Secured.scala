package controllers

import play.api._
import play.api.mvc._

trait Secured {
	private def name(request: RequestHeader) = request.session.get("name")

	// 未認証時のリダイレクト先
	private def onUnauthorized(request: RequestHeader) = 
		Results.Redirect(routes.LoginController.showLoginForm)

	// Actionに認証をかませてラップ
	def isAuthenticated(f: => String => Request[AnyContent] => Result) = 
		Security.Authenticated(name, onUnauthorized) { user => 
			Action(request => f(user)(request))
		}
	// 認証
	
}