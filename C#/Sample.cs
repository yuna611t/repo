using System;
using System.Linq;

class B {
    public int x,y;
}

class Program {

    static void Main(string[] args) {
        var a = new {x = 1, y = 2};
        var b = new B {x = 1, y = 2};
        Console.WriteLine(a); // 匿名オブジェクト
        Console.WriteLine(b);
    }
}
