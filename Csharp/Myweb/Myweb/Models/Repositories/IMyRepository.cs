namespace Myweb
{
	public interface IMyRepository<T> where T : IContentModel
	{
		T Find(int id);
	}
}