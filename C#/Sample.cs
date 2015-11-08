using System;
using System.Threading.Tasks;

class Program {
    static void Main(string[] args) {
        Task.Delay(1000).Wait();
        Console.WriteLine("Hello World!");
    }
}
