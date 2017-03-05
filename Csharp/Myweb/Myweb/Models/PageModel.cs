using System;
namespace Myweb
{
	public class PageModel : IContentModel
	{
		public string Title { get; set; }
		public string SubTitle { get; set; }
		public string Description { get; set; }
		public string Url { get; set; }

		public TabsModel Tabs { get; set; }

	}
}
