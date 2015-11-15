using System;
using System.Linq;

class Program {

    static void Main(string[] args) {
        // 値の加工
        string[] names = {"alice", "BETTY", "Cindy"};
        var upperNames = names.Select(c => c.ToUpper());
        foreach(var item in upperNames) Console.WriteLine(item);
    }
}
