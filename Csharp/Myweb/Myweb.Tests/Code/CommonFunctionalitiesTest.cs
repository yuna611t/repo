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
		TestPathProvider pathProvider = new TestPathProvider();


		private void preFixtureFnishSlashPath()
		{
			pathProvider.LocalPath = "/products/";
		}
		private void preFixtureFinishIndex()
		{
			pathProvider.LocalPath = "/products/index.html";
		}
		private void preFixtureFinishOtherFile()
		{
			pathProvider.LocalPath = "/products/sample.html";
		}



		[TestFixtureSetUp]
		public void initTest()
		{
			MyService.InitializeServices(pathProvider);
			MySettings.initiateSettings();
		}

		[Test]
		public void getWebSiteURLTest()
		{
			pathProvider.LocalPath = "/products/index.html";
			            
			var expected = "http://demo.com/products/index.html";
			var actual = CommonFunctionalities.getWebSiteURL();
			Assert.AreEqual(expected, actual);

		}

		[Test]
		public void getCanonicalLinkTest_preFixtureFnishSlashPath()
		{
			preFixtureFnishSlashPath();
			var expected = "http://demo.com/products/";
			var actual = CommonFunctionalities.getCanonicalLink();
			Assert.AreEqual(expected, actual);
		}

		[Test]
		public void getCanonicalLinkTest_preFixtureFinishIndex()
		{
			preFixtureFinishIndex();
			var expected = "http://demo.com/products/";
			var actual = CommonFunctionalities.getCanonicalLink();
			Assert.AreEqual(expected, actual);
		}

		[Test]
		public void getCanonicalLinkTest_preFixtureFinishOtherFile()
		{
			preFixtureFinishOtherFile();
			var expected = "http://demo.com/products/sample.html";
			var actual = CommonFunctionalities.getCanonicalLink();
			Assert.AreEqual(expected, actual);
		}


	}
}
