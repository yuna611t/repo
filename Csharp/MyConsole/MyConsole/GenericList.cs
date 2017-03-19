using System;
namespace MyConsole
{
	public class GenericList<T>
	{
		public void writeDefault()
		{
			T defaultT = default(T);
			Console.WriteLine("typeof(T) = " + typeof(T).ToString());
			Console.WriteLine("default(T) = " + defaultT?.ToString());
		}
	}
}
