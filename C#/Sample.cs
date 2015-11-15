using System;

class Program {
    static void Main(string[] args) {
        // 変数をキャプチャ
        var a = new Action[10];
        for (int i = 0; i < 10; i++) {
            a[i] = () => Console.WriteLine(i);
        }
        foreach(var item in a) {
            item();
        }
        // 値をキャプチャ
        for (int i = 0; i < 10; i++) {
            int j = i;
            a[i] = () => Console.WriteLine(j);
        }
        foreach(var item in a) {
            item();
        }
    }
}
