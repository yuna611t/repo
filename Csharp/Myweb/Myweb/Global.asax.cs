using System.Web;
using System.Web.Mvc;
using System.Web.Routing;

namespace Myweb
{
	public class Global : HttpApplication
	{
		protected void Application_Start()
		{

			// サービス登録
			MyService.InitializeServices(new ServerPathProvider(), new DBProvider());

			// initialize settings
			MySettings.initiateSettings();


			AreaRegistration.RegisterAllAreas();
			RouteConfig.RegisterRoutes(RouteTable.Routes);
		}
	}
}
