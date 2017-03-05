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

			SampleModel model = new SampleModel();
			model.Title = "Home Page";
			model.Description = "This is description. <br> This is just a sample.";

			//return View(model);
			return View("Index", model);

		}
	}
}
