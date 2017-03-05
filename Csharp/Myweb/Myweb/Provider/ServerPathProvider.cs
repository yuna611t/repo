using System;
using System.Web;

namespace Myweb
{
	public class ServerPathProvider : IPathProvider
	{
		public string MapPath(string path)
		{
			return HttpContext.Current.Server.MapPath(path);
		}

		public string LocalPath { 
			get { return HttpContext.Current.Request.Url.LocalPath; }
		}


	}
}
