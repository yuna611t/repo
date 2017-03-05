using System;
using Newtonsoft.Json.Linq;

namespace Myweb
{
	public interface IDBProvider
	{
		JToken ContentsDB { get; }
		JToken NavigationDB { get; }

	}
}
