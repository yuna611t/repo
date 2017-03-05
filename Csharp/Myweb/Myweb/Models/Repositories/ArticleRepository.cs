using System;
using System.Collections.Generic;
using Newtonsoft.Json.Linq;

namespace Myweb
{
	public class ArticleRepository : IArticleRepository
	{
		public ArticleModel Find(int id)
		{

			DBProvider dbProvider = new DBProvider();
			JToken contentToken = dbProvider.ContentsDB[id];
			JToken articleToken = contentToken["Article"];
			JToken titleToken = articleToken["Title"];
			JToken descriptionsToken = articleToken["Descriptions"];
	
			ArticleModel article = new ArticleModel
			{
				Title = (string) titleToken,
				Descriptions = new List<string>()
			};
			foreach (var description in descriptionsToken)
			{
				article.Descriptions.Add((string) description);				
			}


			return article;
		}

	}
}
