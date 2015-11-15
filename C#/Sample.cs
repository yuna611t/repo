using System;
using System.Linq;

public class Place {
    public string Name;
    public string Type;
}

class Program {

    static void Main(string[] args) {
        // オブジェクト初期化子
        var x = new Place(){Name = "東京", Type = "都"};
        var y = new Place(){Name = "大阪", Type = "府"};
        Console.WriteLine(x.Name + x.Type);
        Console.WriteLine(y.Name + y.Type);
    }
}
