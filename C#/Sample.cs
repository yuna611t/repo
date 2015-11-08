using System;

class Program {
    private static Action Sample() {
        var msg = "Hello Sample";
        // 変数のキャプチャ
        // ラムダ式の中から外の変数を参照できる
        // クロージャっぽいけど違うらしいので後で調べる
        return () => Console.WriteLine(msg);
    }

    static void Main(string[] args) {
        var result = Sample();
        result(); // ラムダ式内でキャプチャした変数は使用されるここまで生存する
    }
}
