using System;

class Program {

    private static void twoitems(ref int a) {
        a = a * 2;
    }

    static void Main(string[] args) {
        int a = 2;
        twoitems(ref a);
        Console.WriteLine(a);
    }
}
