﻿using System;
using System.Collections.Generic;


namespace Myweb
{
	public interface ITabsRepository : IMyRepository<TabsModel>
	{
		TabsModel Find(int id);
	}
}
