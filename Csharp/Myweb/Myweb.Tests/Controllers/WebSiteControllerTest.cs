using NUnit.Framework;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Web.Mvc;
using Myweb;
using Myweb.Controllers;

namespace Myweb.Tests
{
	[TestFixture]
	public class WebSiteControllerTest
	{
		[Test]
		public void Index()
		{
			var controller = new WebSiteController();
			var expected = "Index";

			var viewResult = controller.Index() as ViewResult;
			var actual = viewResult.ViewName;

			Assert.AreEqual(expected, actual);
		}
	}
}
