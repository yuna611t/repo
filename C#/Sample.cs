using System;
using System.Collections.Generic;
using System.Linq;

class Program {

    // LinQを使わない場合
    private static string[] getANames(string[] names) {
        var list = new List<string>();
        foreach(var item in names) {
            if (item.StartsWith("A")) list.Add(item);
        }
        return list.ToArray();
    }
    // LinQの場合
    private static string[] getANamesLinQ(string[] names) {
        return (from n in names where n.StartsWith("A") select n).ToArray();
    }
    // LinQのメソッド形式
    private static string[] getANamesLinQM(string[] names) {
        return names.Where(c => c.StartsWith("A")).ToArray();
    }

    static void Main(string[] args) {
        string[] names = { "Alice", "Anne", "Betty"};
        string[] r = getANames(names);
        string[] rL = getANamesLinQ(names);
        string[] rM = getANamesLinQM(names);
        foreach(var item in r) Console.WriteLine(item);
        foreach(var item in rL) Console.WriteLine(item);
        foreach(var item in rM) Console.WriteLine(item);
    }
}
