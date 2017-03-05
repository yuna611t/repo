using System;
using System.Web;
using Newtonsoft.Json.Linq;
using System.IO;

namespace Myweb
{
	public static class CommonFunctionalities
	{

		/// <summary>
		/// 正規化したURLを取得する
		///   - パラメータを削除する
		///   - index.htmlと / を同一とみなす
		/// </summary>
		/// <returns>The canonical link.</returns>
		public static string getCanonicalLink()
		{
			
			string localPath = MyService.PathProvider.LocalPath.ToLower();
			string canonicalLink = localPath;

			// index.htmlを取り除く
			if (canonicalLink.EndsWith(MySettings.INDEX_FILE))
			{
				int positionOfFileName = canonicalLink.LastIndexOf(MySettings.INDEX_FILE);
				canonicalLink = canonicalLink.Substring(0, positionOfFileName);
			}
			// ドメインを付与する
			canonicalLink = MySettings.DOMAIN_URL + canonicalLink;
			return canonicalLink;
		}


		public static string getWebSiteURL()
		{
			var localPath = MyService.PathProvider.LocalPath;
			return MySettings.DOMAIN_URL + localPath;
		}
	}
}
