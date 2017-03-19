using System;
using System.Collections.Generic;
using System.Linq;

namespace MyConsole
{
	class MainClass
	{
		public static void Main(string[] args)
		{

			TestOperand x = null;


			// System.NullReferenceException will happen
			try
			{
				// System.NullReferenceException will happen
				Console.WriteLine("x.y = " + (x.y).ToString());
			}
			catch (Exception e)
			{
				Console.WriteLine("x.y = " + "NullReferenceException");
				Console.WriteLine(e);				
			}

			// property y will not be accessed.
			Console.WriteLine("x?.y = " + (x?.y).ToString());


			int? a = null;
			int? b = 2;
			Console.WriteLine("a??b = " + (a??b).ToString());

			// Generic
			GenericList<int> intT = new GenericList<int>();
			intT.writeDefault();

			GenericList<string> stringT = new GenericList<string>();
			stringT.writeDefault();


			GenericList<ST> STT = new GenericList<ST>();
			STT.writeDefault();

			LinQTest();

			Console.ReadKey();
		}

		private static void LinQTest()
		{


			Child c1 = new Child
			{
				Id = 1,
				Title = "Child-001"
			};
			Child c2 = new Child
			{
				Id = 2,
				Title = "Child-002"
			};

			List<Child> childList = new List<Child>();
			childList.Add(c1);
			childList.Add(c2);



			Func<int, int?> f = i => 
			{
				if (i % 3 == 0) return null;
				return i % 2 == 0 ? 1 : 2;
			};

			List<Parent> parents = new List<Parent>();
			for (int i = 0; i < 10; i++)
			{

				var title = "Sample-" + i.ToString("00");
				Parent parent = new Parent
				{
					Id = i,
					Title = title,
					Description = title.GetHashCode().ToString(),
					ChildId = f(i)
				};
				parents.Add(parent);
			}

			var l1 = parents
					.Where(x => x.Id < 5)
					.GroupBy(x => x.ChildId = 1);
			Console.WriteLine("Count : " + l1.Count());
			Console.WriteLine("FirstorDefault : " + l1.FirstOrDefault());

			// Join
			var l2 = parents
				.Join(childList,
					  p => p.ChildId,
					  c => c.Id,
					  (p, c) => new
					  {
						  ParentId = p.Id,
						  ParentTitle = p.Title,
						  ParentDescription = p.Description,
						  ChildTitle = c.Title
					  });
			foreach (var item in l2)
			{
				Console.WriteLine("------");
				Console.WriteLine("ParentID: " + item.ParentId.ToString());
				Console.WriteLine("ParentTitle: " + item.ParentTitle);
				Console.WriteLine("ChildTitle: " + item.ChildTitle);
			}

			// Left Outer Join
			var l3 = parents.GroupJoin(
					childList,
					(p) => p.ChildId,
					(c) => c.Id,
					(p, c) => new { p, c }
				).SelectMany(
					x => x.c.DefaultIfEmpty(),
			        (x, child) => new{
						ParentTitle = x.p.Title,
						ChildTitle = child != null ? child.Title : "Non-Child"
				});

			Console.WriteLine("*************");
			Console.WriteLine(" | ParentTitle | ChildTitle |");
			foreach (var item in l3)
			{
				Console.Write(" |" + item.ParentTitle);
				Console.Write(" |" + item.ChildTitle);
				Console.WriteLine(" | ");

				/*
				foreach (var child in parent.Child)
				{
					Console.WriteLine("> ChildId: " + child.Id.ToString());
					Console.WriteLine("> ChildTitle: " + child.Title);

				}
				*/

			}

		}

	}

	struct ST
	{
		int A { get; set; }
	}

}
