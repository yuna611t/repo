using System;
using System.Threading.Tasks;

public class Example
{
    public static void Main()
    {
        Console.WriteLine("----Before Task Start----");
        Task t = Task.Factory.StartNew( () => {
            int ctr = 0;
            for (ctr = 0; ctr <= 100000; ctr++) 
            {
                Console.WriteLine("Finished {0} loop iterations", ctr);
            }
        } );
        Console.WriteLine("----After Task Start----");
        t.Wait();
        Console.WriteLine("----After Task Wait----");
    }
}