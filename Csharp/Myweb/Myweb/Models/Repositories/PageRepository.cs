using System;
namespace Myweb
{
	public class PageRepository : IPageRepository
	{
		public PageModel Find(int id)
		{
			// タブコンテンツ取得
			TabsModel tabs = new TabsRepository().Find(0);

			PageModel pageModel = new PageModel
			{
				Title = "Home Page",
				Description = "This is description. <br> This is just a sample.",
				Tabs = tabs
			};
			return pageModel;
		}
	}
}
