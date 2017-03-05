using System;
using System.Collections.Generic;


namespace Myweb
{
	public interface ITabsRepository
	{
		TabModel Find(int id);
		IList<TabModel> GetAll();
		void Add(TabModel tab);
		void Remove(TabModel tab);
		void Save();
	}
}
