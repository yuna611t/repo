using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace MyApp.Sample
{
    public static class MyExtention
    {
        public static void MethodE(this BaseSample baseSample)
        {
            Console.WriteLine("This is MethodE from MyExtention");
        }
    }
}
