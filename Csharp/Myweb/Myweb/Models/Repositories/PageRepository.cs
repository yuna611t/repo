using System;
using Newtonsoft.Json.Linq;

namespace Myweb
{
	public class PageRepository : IPageRepository
	{
		public PageModel Find(int id)
		{
			// ナビゲーション取得
			NavigationModel navigation = new NavigationRepository().Find(id);

			// 記事取得
			ArticleModel article = new ArticleRepository().Find(id);

			// タブコンテンツ取得
			TabsModel tabs = new TabsRepository().Find(id);

			// 一旦ここにハードコーディング
			JToken contentToken = MyService.DBProvider.ContentsDB[id];
			JToken pageToken = contentToken["PageContent"];

			PageModel pageModel = new PageModel
			{
				Title = (string) pageToken["Title"],
				SubTitle = (string)pageToken["SubTitle"],
				Description = (string)pageToken["Description"],
				Tabs = tabs,
				Navigation = navigation,
				Article = article					
			};
			return pageModel;
		}
	}
}
