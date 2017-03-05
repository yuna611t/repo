using System;
namespace Myweb
{
	public interface IPathProvider
	{
		string MapPath(string path);
		string LocalPath { get; }
	}
}
