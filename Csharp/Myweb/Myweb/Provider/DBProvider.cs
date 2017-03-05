using System;
using Newtonsoft.Json.Linq;
using System.IO;

namespace Myweb
{
	public class DBProvider : IDBProvider
	{

		private string DBPath = "";

		public JToken ContentsDB { 
			get {
				fetchDataNode();
				// データ取得のノード取得する
				JObject o1 = JObject.Parse(File.ReadAllText(DBPath));
				return o1["Contents"];
			} 
		}

		private void fetchDataNode()
		{
			if (MySettings.Data_Base != null)
			{
				JToken DataSource = MySettings.Data_Base["Src"];
				string AppRoot = MyService.PathProvider.MapPath("/");
				DBPath = AppRoot + (string)DataSource;
			}
		}

	}
}
