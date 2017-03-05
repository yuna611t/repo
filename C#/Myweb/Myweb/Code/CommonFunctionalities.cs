using System;
using System.Web;
using Newtonsoft.Json.Linq;
using System.IO;

namespace Myweb
{
	public static class CommonFunctionalities
	{

		public static string getWebSiteURL()
		{
			var localPath = MyService.PathProvider.LocalPath;
			return MySettings.DOMAIN_URL + localPath;
		}
	}
}
