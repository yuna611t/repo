using System;

class Program {

    static void Main(string[] args) {
        byte a = 1, b = 2;
        // 加算などの演算子の結果はint型に昇格される
        // byte c = a + b;
        var c = a + b;
        Console.WriteLine(c);
    }
}
