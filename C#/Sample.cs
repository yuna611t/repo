using System;
using System.Linq;

class Program {

    class X {
        public string Name;
    }

    static void Main(string[] args) {
        string[] names = {"alice", "BETTY", "Cindy"};
        var upperNames = names.Select(c => new X(){Name = c.ToUpper()});
        foreach(var item in upperNames) Console.WriteLine(item.Name);
    }
}
