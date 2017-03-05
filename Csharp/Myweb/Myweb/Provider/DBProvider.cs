using System;
using Newtonsoft.Json.Linq;
using System.IO;

namespace Myweb
{
	public class DBProvider
	{

		public JToken ContentsDB { get; set; }

		public DBProvider()
		{
			JToken database = MySettings.DirectAccessedSettings["Data_Base"]["Src"];
			string AppRoot = MyService.PathProvider.MapPath("/");
			string DBPath = AppRoot + (string) MySettings.DirectAccessedSettings["Data_Base"]["Src"];

			// データ取得のノード取得する
			JObject o1 = JObject.Parse(File.ReadAllText(DBPath));
			ContentsDB = o1["Contents"];
		}


	}
}
