using System;

class Program {

    private static void twoitems(int a, out int b) {
        b = a * 2;
    }

    static void Main(string[] args) {
        int r;
        twoitems(2, out r);
        Console.WriteLine(r);
    }
}
