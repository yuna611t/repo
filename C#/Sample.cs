using System;
using System.Linq;

class Program {

    static void Main(string[] args) {
        int[] weights = {7,12,5,9,17};
        var weightsOver10kg = weights.Where(c => c >= 10);
        Console.WriteLine("10kg以上で最軽量の石は{0}kg", weightsOver10kg.Min());
        Console.WriteLine("10kg以上で最重量の石は{0}kg", weightsOver10kg.Max());
        Console.WriteLine("10kg以上で石の重さの平均は{0}kg", weightsOver10kg.Average());
        if (weights.Any(c => c == 12)) Console.WriteLine("重さ12kgの石は存在する");
    }
}
