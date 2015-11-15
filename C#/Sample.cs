using System;
using System.Linq;

class Program {

    // LinQの値加工
    private static int[] calc(int[] prices) {
        return (from n in prices select n * 105/100).ToArray();
    }
    // LinQメッソド形式
    private static int[] calc2(int[] prices) {
        return prices.Select(c => c * 105/100).ToArray();
    }

    static void Main(string[] args) {
        int[] prices = {100, 1000, 150};
        var cP1 = calc(prices);
        var cP2 = calc2(prices);
        foreach(var item in cP1) {
            Console.WriteLine(item);
        }
        foreach(var item in cP2) {
            Console.WriteLine(item);
        }
    }
}
