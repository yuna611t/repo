using System;
using System.Collections.Generic;

namespace Myweb
{
	public class ArticleModel : IContentModel
	{
		public string Title { get; set; }
		public List<string> Descriptions { get; set; }
	}
}
