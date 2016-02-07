using System;
using System.Threading;
using System.Threading.Tasks;

public class Example
{
    public static void Main()
    {
        Console.WriteLine("----Before Task Start----");

        Parallel.For(0, 100000,
            ctr => {
                Console.WriteLine("Finished {0} loop iterations", ctr);                
            });
        Console.WriteLine("----After Task Start----");
        Console.WriteLine("----After Task Wait----");
    }
}