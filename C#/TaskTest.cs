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
        extract00();
        extract01();
        extract02();
    }
    
    static void extract00() {
        Item[] items = createItemList(10000);
                
        System.Diagnostics.Stopwatch sw = new System.Diagnostics.Stopwatch();
        sw.Start();
        
        ArrayList array = new ArrayList();
        
        Console.WriteLine("----Before Loop----");
        
        foreach (Item item in items)
        {
            if (item.status == "new")
            {
                array.Add(item);                
            }
        }

        Console.WriteLine("----After Loop----");

        foreach (Item item in array)
        {
            Console.Write("new item is " + item.id + ", ");
        }

        sw.Stop();
        Console.WriteLine("");
        Console.WriteLine(sw.Elapsed);
    }

    
    static void extract01() {
        Item[] items = createItemList(10000);
                
        System.Diagnostics.Stopwatch sw = new System.Diagnostics.Stopwatch();
        sw.Start();
        
        ArrayList array = new ArrayList();
        object lockobj = new object();
        
        Console.WriteLine("----Before Pallarel----");

        IEnumerable<Item> records = from n in items where n.status == "new" select n;
        Parallel.ForEach(records,
            (x) => {
                lock (lockobj) { array.Add(x); }
            });

          Console.WriteLine("----After Parallel----");

        foreach (Item item in array)
        {
            Console.Write("new item is " + item.id + ", ");
        }

        sw.Stop();
        Console.WriteLine("");
        Console.WriteLine(sw.Elapsed);        
    }
    
     static void extract02() {
        Item[] items = createItemList(10000);
                
        System.Diagnostics.Stopwatch sw = new System.Diagnostics.Stopwatch();
        sw.Start();
        
        ArrayList array = new ArrayList();
        object lockobj = new object();
        
        Console.WriteLine("----Before Pallarel----");

        IEnumerable<Item> records = from n in items select n;
        Parallel.ForEach(records,
            (x) => {
                if (x.status == "new") {
                    lock (lockobj) { array.Add(x); }
                }
            });

          Console.WriteLine("----After Parallel----");

        foreach (Item item in array)
        {
            Console.Write("new item is " + item.id + ", ");
        }

        sw.Stop();
        Console.WriteLine("");
        Console.WriteLine(sw.Elapsed);        
    }
    
    static Item[] createItemList(int _size) {
        int size = _size > 0 ? _size : 1000;
        
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
        return items;
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