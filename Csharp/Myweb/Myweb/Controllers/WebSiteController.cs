using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Myweb.Controllers
{
	public class WebSiteController : Controller
	{

		public ActionResult Index(int? id)
		{

			return View();
		}

	}
}
