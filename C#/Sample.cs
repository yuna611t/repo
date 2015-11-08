using System;

class Program {

    static void Main(string[] args) {
        Action<int, int> act = (a,b) => Console.WriteLine("{0}", a + b);
        act(1, 3);
    }
}
