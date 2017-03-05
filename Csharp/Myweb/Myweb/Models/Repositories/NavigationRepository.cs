using System;
using System.Collections.Generic;

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
			navContent = new NavigationContent
			{
				Title = "Product",
				Link = "/product/"
			};
			navModel.NavList.Add(navContent);
			navContent = new NavigationContent
			{
				Title = "Service",
				Link = "/service/"
			};
			navModel.NavList.Add(navContent);
			navContent = new NavigationContent
			{
				Title = "News",
				Link = "/news/"
			};
			navModel.NavList.Add(navContent);
			navContent = new NavigationContent
			{
				Title = "About",
				Link = "/about/"
			};
			navModel.NavList.Add(navContent);
			navContent = new NavigationContent
			{
				Title = "Special",
				Link = "/special/"
			};
			navModel.NavList.Add(navContent);

			return navModel;
		}
	}
}
