using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Myweb.Controllers
{
	public class WebSiteController : Controller
	{

		public ActionResult Index()
		{

			// タブコンテンツ生成
			TabsModel tabs = new TabsRepository().Find(0);

			PageModel model = new PageModel
			{
				Title = "Home Page",
				Description = "This is description. <br> This is just a sample.",
				Tabs = tabs					
			};


			//return View(model);
			return View("Index", model);

		}
	}
}
