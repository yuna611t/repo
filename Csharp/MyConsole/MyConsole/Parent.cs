using System;
namespace MyConsole
{
	public class Parent
	{
		public int Id { get; set; }
		public string Title { get; set; }
		public string Description { get; set; }
		public int? ChildId { get; set; }
	}

	public class Child
	{
		public int Id { get; set; }
		public string Title { get; set; }
	}
}
