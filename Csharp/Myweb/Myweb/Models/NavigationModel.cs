using System;
using System.Collections.Generic;

namespace Myweb
{
	public class NavigationModel : IContentModel
	{
		public List<NavigationContent> NavList { get; set; }
	}

	public class NavigationContent : IContentModel
	{
		public string Title { get; set; }
		public string Link { get; set; }
	}
}
