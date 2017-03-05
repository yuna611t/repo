using System;
using System.Collections.Generic;


namespace Myweb
{
	public class TabsModel : IContentModel
	{
		public string Title { get; set; }
		public List<TabModel> TabList { get; set; }

	}
}
