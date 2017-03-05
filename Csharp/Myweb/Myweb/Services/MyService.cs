using System;
namespace Myweb
{
	public class MyService
	{

		private static IPathProvider _pathProvider = null;
		public static IPathProvider PathProvider { get { return _pathProvider; } }
		/// <summary>
		/// サービスの登録
		/// </summary>
		/// <param name="_pathProvider">Path provider.</param>
		public static void InitializeServices(IPathProvider pathProvider)
		{
			MyService._pathProvider = pathProvider;

		}

	}
}
