using NUnit.Framework;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Web.Mvc;
using Myweb;
using Myweb.Controllers;
using System.IO;

namespace Myweb.Tests
{
	[TestFixture]
	public class CommonFunctionalitiesTest
	{
		[TestFixtureSetUp]
		public void initTest()
		{
			MyService.InitializeServices(new TestPathProvider());
			MySettings.initiateSettings();
		}

		[Test]
		public void getWebSiteURLTest()
		{
			var expected = "http://demo.com/test/";
			var actual = CommonFunctionalities.getWebSiteURL();
			Assert.AreEqual(expected, actual);

		}

		[Test]
		public void getCanonicalLinkTest()
		{
			var expected = "http://demo.com/test/";
			var actual = CommonFunctionalities.getCanonicalLink();
			Assert.AreEqual(expected, actual);

		}
	}
}
