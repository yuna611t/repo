using System.IO;
using Newtonsoft.Json.Linq;

namespace Myweb
{
	/// <summary>
	/// AppSettings.jsonに記述された設定へのアクセスを可能にする
	/// 原則、公開された変数を通して設定にアクセスする
	/// </summary>
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


		// 共通変数が提供されていない設定に直接アクセスできるようにするための公開JToken
		public static JToken DirectAccessedSettings { get { return Settings; } }

		// 公開共通設定
		public static string DOMAIN_URL { get { return (string)Settings["DOMAIN_URL"]; } }
		public static string INDEX_FILE { get { return (string)Settings["INDEX_FILE"]; } }

		// DB設定
		public static JToken Data_Base { get { return Settings["Data_Base"]; } }

	}
}
