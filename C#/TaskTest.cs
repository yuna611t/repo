using System;
using System.Threading;
using System.Threading.Tasks;
using System.Collections;

public class Example
{
    public static void Main()
    {
        ArrayList array = new ArrayList();
        object lockobj = new object();
        array.Add(100);
        
        Console.WriteLine("----Before Pallarel----");
        Parallel.For(0, 10,
            ctr => {
                Console.WriteLine(ctr);
                lock (lockobj) { array.Add(ctr); }
            });
        Console.WriteLine("----After Parallel----");

        foreach (var item in array)
        {
            Console.WriteLine(item);
        }

    }
}