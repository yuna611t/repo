using System;
namespace Myweb
{
	public class MyService
	{

		private static IPathProvider _pathProvider = null;
		public static IPathProvider PathProvider { get { return _pathProvider; } }

		private static IDBProvider _dbProvider = null;
		public static IDBProvider DBProvider { get { return _dbProvider; } }


		/// <summary>
		/// サービスの登録
		/// </summary>
		/// <param name="_pathProvider">Path provider.</param>
		public static void InitializeServices(IPathProvider pathProvider)
		{
			MyService._pathProvider = pathProvider;
		}

		public static void InitializeServices(IPathProvider pathProvider, IDBProvider dbPProvider)
		{
			InitializeServices(pathProvider);
			MyService._dbProvider = dbPProvider;
		}


	}
}
