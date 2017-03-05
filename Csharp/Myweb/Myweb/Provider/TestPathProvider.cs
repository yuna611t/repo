using System;
using System.IO;

namespace Myweb
{
	public class TestPathProvider : IPathProvider
	{

		public string MapPath(string path)
		{
			//return "/Users/yuna/Desktop/test/Myweb/Myweb.Tests/bin/Debug/";
			string ExePath = System.Reflection.Assembly.GetExecutingAssembly().Location;
			string pathDir = Path.GetDirectoryName(ExePath);
			return pathDir + "/";

		}

		public string LocalPath { get; set; }

	}
}
