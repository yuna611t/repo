using System;
using System.Linq;

class SimpleQuery
{
    static void Main(string[] args)
    {
        int[] nums = { 1, -2, 3, 0, -4, 5 };

        var posNums = from n in nums
                      where n > 0
                      select n;
        
        Console.WriteLine("The positive values in nums:");
        foreach (int i in posNums) Console.WriteLine(i);

        // deferred execution
        nums[2] = 99;
        Console.WriteLine("The positive values in nums - 2nd:");
        foreach (int i in posNums) Console.WriteLine(i);
        


    }
}