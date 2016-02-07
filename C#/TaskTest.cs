using System;
using System.Threading;
using System.Threading.Tasks;
using System.Linq;
using System.Collections;
using System.Collections.Generic;


public class Example
{
    public static void Main()
    {
        int size = 1000;
        Item[] items = new Item[size];
        for (int i = 0; i < size; i++)
        {
            Item item = null;
            if (i % 300 == 0) {
                items[i] = new Item(i, "new");
            } else if(i % 2 == 0) {
                items[i] = new Item(i, "mod");
            } else {
                items[i] = new Item(i, "del");
            }
            
        }
        
        
        ArrayList array = new ArrayList();
        object lockobj = new object();
        
        Console.WriteLine("----Before Pallarel----");

        IEnumerable<Item> records = from n in items where n.status == "new" select n;
        Parallel.ForEach(records,
            (x) => {
                // if (x.status == "new") {
                    lock (lockobj) { array.Add(x); }
                // }
            });

          Console.WriteLine("----After Parallel----");

        foreach (Item item in array)
        {
            Console.WriteLine("new item is " + item.id);
        }

    }
}

class Item
{
    public int id { get; }
    public string status { get; set; }

    public Item(int id, string status)
    {
        this.id = id;
        this.status = status;   
    }

}