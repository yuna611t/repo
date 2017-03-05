using System;

namespace Myweb
{
	public interface IPageRepository : IMyRepository<PageModel>
	{
		PageModel Find(int id);
	}
}
