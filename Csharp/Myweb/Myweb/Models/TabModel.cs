using System;
using System.Collections.Generic;

namespace Myweb
{
	public class TabModel : IContentModel
	{
		public string Title { get; set; }
		public string Description { get; set; }
		public string AnchorID {
			get { return this.Title.ToLower(); } 
		}
		public List<DropDownContentModel> DropDownContents { get; set; }
	}

	public class DropDownContentModel
	{
		public int Counter { get; set; }
		public string Title { get; set; }
		public string Description { get; set; }
		public string AnchorID
		{
			get { return "dropdown" + Counter.ToString(); }
		}

	}
}
