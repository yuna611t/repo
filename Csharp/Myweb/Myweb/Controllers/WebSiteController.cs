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

			// Model取得
			var model = new PageRepository().Find(0);

			//return View(model);
			return View("Index", model);

		}
	}
}
