using System;
using System.Collections.Generic;

namespace Myweb
{
	public class TabsRepository : ITabsRepository
	{
		public TabsModel Find(int id)
		{
			TabsModel tabs = new TabsModel
			{
				Title = "Tabs",
				TabList = new List<TabModel>()
			};

			TabModel tab = null;
			tab = new TabModel
			{
				Title = "Home",
				Description = "Raw denim you probably haven't heard of them jean shorts Austin. Nesciunt tofu stumptown aliqua, retro synth master cleanse. Mustache cliche tempor, williamsburg carles vegan helvetica. Reprehenderit butcher retro keffiyeh dreamcatcher synth. Cosby sweater eu banh mi, qui irure terry richardson ex squid. Aliquip placeat salvia cillum iphone. Seitan aliquip quis cardigan american apparel, butcher voluptate nisi qui."
			};

			tabs.TabList.Add(tab);
			tab = new TabModel
			{
				Title = "Profile",
				Description = "Food truck fixie locavore, accusamus mcsweeney's marfa nulla single-origin coffee squid. Exercitation +1 labore velit, blog sartorial PBR leggings next level wes anderson artisan four loko farm-to-table craft beer twee. Qui photo booth letterpress, commodo enim craft beer mlkshk aliquip jean shorts ullamco ad vinyl cillum PBR. Homo nostrud organic, assumenda labore aesthetic magna delectus mollit."
			};
			tabs.TabList.Add(tab);

			tab = new TabModel
			{
				Title = "Dropdown",
				DropDownContents = new List<DropDownContentModel>()
			};
			DropDownContentModel dropdownContent = null;
			dropdownContent = new DropDownContentModel
			{
				Title = "Action",
				Description = "Etsy mixtape wayfarers, ethical wes anderson tofu before they sold out mcsweeney's organic lomo retro fanny pack lo-fi farm-to-table readymade. Messenger bag gentrify pitchfork tattooed craft beer, iphone skateboard locavore carles etsy salvia banksy hoodie helvetica. DIY synth PBR banksy irony. Leggings gentrify squid 8-bit cred pitchfork.",
				Counter = 1
			};
			tab.DropDownContents.Add(dropdownContent);
			dropdownContent = new DropDownContentModel
			{
				Title = "Another action",
				Description = "Trust fund seitan letterpress, keytar raw denim keffiyeh etsy art party before they sold out master cleanse gluten-free squid scenester freegan cosby sweater. Fanny pack portland seitan DIY, art party locavore wolf cliche high life echo park Austin. Cred vinyl keffiyeh DIY salvia PBR, banh mi before they sold out farm-to-table VHS viral locavore cosby sweater.",
				Counter = 2
			};
			tab.DropDownContents.Add(dropdownContent);

			tabs.TabList.Add(tab);

			return tabs;
		}
	}
}
