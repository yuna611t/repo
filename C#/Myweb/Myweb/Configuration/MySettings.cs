using System.IO;
using Newtonsoft.Json.Linq;

namespace Myweb
{
	public static class MySettings
	{
		static JToken Settings = null;

		/// <summary>
		/// AppSettings.jsonを読み取って共通設定の初期化を行う
		/// </summary>
		public static void initiateSettings()
		{

			var AppPath = MyService.PathProvider.MapPath("/");
			var FilePath = AppPath + "AppSettings.json";
			JObject o1 = JObject.Parse(File.ReadAllText(FilePath));
			// デモ用設定を使用するか本番用設定を使用するか決定する
			string env = (string)o1["Env"];
			// 設定の適用
			Settings = o1[env];
		}

		public static string DOMAIN_URL { get { return (string)Settings["DOMAIN_URL"]; } }

	}
}
