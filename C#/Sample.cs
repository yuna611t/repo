using System;

class Program {
    static void Main(string[] args) {
        int i = 0;
        string s = "Hello";
        bool b = true;
        Console.WriteLine("i.GetType().FullName: {0}", i.GetType().FullName);
        Console.WriteLine("s.GetType().FullName: {0}", s.GetType().FullName);
        Console.WriteLine("b.GetType().FullName: {0}", b.GetType().FullName);
    }
}
