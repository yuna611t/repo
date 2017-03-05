using System;
using System.Collections.Generic;
using Newtonsoft.Json.Linq;

namespace Myweb
{
	public class NavigationRepository : INavigationRepository
	{
		public NavigationModel Find(int id)
		{
			NavigationModel navModel = new NavigationModel
			{
				NavList = new List<NavigationContent>()
			};


			NavigationContent navContent = null;
			// 一旦ここにハードコーディング
			JToken navigationToken = MyService.DBProvider.NavigationDB[id];

			foreach (var navigation in navigationToken)
			{
				navContent = new NavigationContent
				{
					Title = (string) navigation["Title"],
					Link = (string)navigation["Link"]
				};
				navModel.NavList.Add(navContent);

			}

			return navModel;
		}
	}
}
