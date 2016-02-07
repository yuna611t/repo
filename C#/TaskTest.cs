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
        Extract extract;
        extract = new Extract00(); extract.extract();
        extract = new Extract01(); extract.extract();
        extract = new Extract02(); extract.extract();
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

abstract class Extract
{
    public abstract void extract();

    protected Item[] createItemList(int _size) {
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
    
    protected void printExtractedItems(ArrayList array) {
        foreach (Item item in array)
        {
            Console.Write("new item is " + item.id + ", ");
        }
    }
    
    System.Diagnostics.Stopwatch sw;
    protected void startTimer() {
        sw = new System.Diagnostics.Stopwatch();
        sw.Start();        
    }
    protected void stopTimer() {
        sw.Stop();
        Console.WriteLine("");
        Console.WriteLine(sw.Elapsed);
    }
}

class Extract00 : Extract
{
     public override void extract() {
        Item[] items = createItemList(10000);    
        startTimer();                    
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
        printExtractedItems(array);
        stopTimer();
    }
}

class Extract01 : Extract
{
    public override void extract() {
        Item[] items = createItemList(10000);
        startTimer();
        ArrayList array = new ArrayList();
        object lockobj = new object();
        Console.WriteLine("----Before Pallarel----");
        IEnumerable<Item> records = from n in items where n.status == "new" select n;
        Parallel.ForEach(records,
            (x) => {
                lock (lockobj) { array.Add(x); }
            });
        Console.WriteLine("----After Parallel----");
        printExtractedItems(array);
        stopTimer();
    }
}

class Extract02 : Extract
{
    public override void extract() {
        Item[] items = createItemList(10000);
        startTimer();
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
        printExtractedItems(array);
        stopTimer();
    }
}