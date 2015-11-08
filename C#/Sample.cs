using System;

class Program {

    static void Main(string[] args) {
        Action<int, int> act = (a,b) => Console.WriteLine("{0}", a + b);
        act(1, 3);

        Func<byte, double, int> f = (x, y) => (int)(x * y);
        Console.WriteLine(f(2,3));
    }
}
