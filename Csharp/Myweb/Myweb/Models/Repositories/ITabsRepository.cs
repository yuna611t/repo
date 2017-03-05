using System;
using System.Collections.Generic;


namespace Myweb
{
	public interface ITabsRepository
	{
		TabsModel Find(int id);
	}
}
