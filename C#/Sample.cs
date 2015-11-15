using System;

public class A { public int X; }
public struct B { public int X; }


class Program {

    static void Main(string[] args) {
        A a1 = new A();
        B b1 = new B();
        a1.X = 123;
        b1.X = 123;

        A a2 = a1; // 参照先のコピー(class)
        B b2 = b1; // 値のコピー(struct)

        a2.X = 456;
        b2.X = 456;

        Console.WriteLine("a1.X={0}", a1.X);
        Console.WriteLine("a2.X={0}", a2.X);

        Console.WriteLine("b1.X={0}", b1.X);
        Console.WriteLine("b2.X={0}", b2.X);
    }
}
