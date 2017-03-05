using System;
namespace Myweb
{
	public class PageRepository : IPageRepository
	{
		public PageModel Find(int id)
		{
			// ナビゲーション取得
			NavigationModel navigation = new NavigationRepository().Find(0);

			// 記事取得
			ArticleModel article = new ArticleRepository().Find(0);

			// タブコンテンツ取得
			TabsModel tabs = new TabsRepository().Find(0);



			PageModel pageModel = new PageModel
			{
				Title = "Home Page",
				SubTitle = "Sub Title",
				Description = "This is description. <br> This is just a sample.",
				Tabs = tabs,
				Navigation = navigation,
				Article = article					
			};
			return pageModel;
		}
	}
}
