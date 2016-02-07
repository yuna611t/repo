using System;
using System.Threading;
using System.Threading.Tasks;
using System.Linq;
using System.Collections;
using System.Collections.Generic;

/// <summary>
/// データの抽出方法の違いによる速度の計測
/// </summary>
public class Example
{
    public static void Main()
    {
        Extract extract;
        extract = new Extract00(); extract.extract();
        extract = new Extract01(); extract.extract();
        extract = new Extract02(); extract.extract();
    }
}

/// <summary>
/// データ
/// </summary>
class Item
{
    public int id { get; }
    public string status { get; set; }

    public Item(int id, string status)
    {
        this.id = id;
        this.status = status;   
    }
}


  /// <summary>
  /// データの抽出とその速度の計測を行う抽象クラス
  /// </summary>
abstract class Extract
{
    /// <summary>
    /// データの抽出とその速度の計測を行う
    /// </summary>
    public void extract() 
    {
        // データの生成
        Item[] items = createItemList(10000);
        // 抽出時間の計測開始
        startTimer();                            
        Console.WriteLine("----Before Loop----");
        // 抽出処理実行
        ArrayList array = correctItems(items);
        Console.WriteLine("----After Loop----");
        // 抽出したデータの表示
        printExtractedItems(array);
        // 抽出時間の表示
        stopTimer(); 
    }
    
    /// <summary>
    /// データの抽出を行う
    /// <param name="items">データ抽出対象</param>
    /// <returns>抽出されたデータ</returns>    
    /// </summary> 
    protected abstract ArrayList correctItems(Item[] items);

    /// <summary>
    /// データの生成を行う
    /// <param name="_size">作成するデータの数</param>
    /// <returns>作成されたデータ</returns>    
    /// </summary>     
    protected Item[] createItemList(int _size) {
        int size = _size > 0 ? _size : 1000;
        
        Item[] items = new Item[size];
        for (int i = 0; i < size; i++)
        {
            Item item = null;
            if (i % 300 == 0) {
                items[i] = new Item(i, "new");
            } else if(i % 2 == 0) {
                items[i] = new Item(i, "mod");
            } else {
                items[i] = new Item(i, "del");
            }   
        }
        return items;
    }
    
    /// <summary>
    /// 抽出されたデータの表示
    /// <param name="array">表示するデータ</param>
    /// </summary>     
    protected void printExtractedItems(ArrayList array) {
        foreach (Item item in array)
        {
            Console.Write("new item is " + item.id + ", ");
        }
    }

    System.Diagnostics.Stopwatch sw;    
    /// <summary>
    /// 時間の計測開始
    /// </summary>     
    protected void startTimer() {
        sw = new System.Diagnostics.Stopwatch();
        sw.Start();       
    }
    
    /// <summary>
    /// 時間の計測終了と計測時間の表示
    /// </summary>     
    protected void stopTimer() {
        sw.Stop();
        Console.WriteLine("");
        Console.WriteLine(sw.Elapsed);
    }
}

/// <summary>
/// データの抽出を直列に行う
/// </summary> 
class Extract00 : Extract
{

    /// <summary>
    /// データの抽出を直列に行う
    /// <param name="items">データ抽出対象</param>
    /// <returns>抽出されたデータ</returns>    
    /// </summary>
     protected override ArrayList correctItems(Item[] items) {
        ArrayList array = new ArrayList();
        foreach (Item item in items)
        {
            if (item.status == "new")
            {
                array.Add(item);                
            }
        }
        return array;
    }
}

/// <summary>
/// データの抽出を並列に行う
/// 並列処理の対象を事前にLinQで集約しておく
/// </summary> 
class Extract01 : Extract
{
    /// <summary>
    /// データの抽出を並列に行う
    /// 並列処理の対象を事前にLinQで集約しておく
    /// <param name="items">データ抽出対象</param>
    /// <returns>抽出されたデータ</returns>    
    /// </summary>
     protected override ArrayList correctItems(Item[] items) {
        ArrayList array = new ArrayList();
        object lockobj = new object();
        IEnumerable<Item> records = from n in items where n.status == "new" select n;
        Parallel.ForEach(records,
            (x) => {
                lock (lockobj) { array.Add(x); }
            });
        return array;
    }
}

/// <summary>
/// データの抽出を並列に行う
/// 並列処理の中でデータの抽出判定を行う
/// </summary> 
class Extract02 : Extract
{
    /// <summary>
    /// データの抽出を並列に行う
    /// 並列処理の中でデータの抽出判定を行う
    /// <param name="items">データ抽出対象</param>
    /// <returns>抽出されたデータ</returns>    
    /// </summary>
     protected override ArrayList correctItems(Item[] items) {
        ArrayList array = new ArrayList();
        object lockobj = new object();
        IEnumerable<Item> records = from n in items select n;
        Parallel.ForEach(records,
            (x) => {
                if (x.status == "new") {
                    lock (lockobj) { array.Add(x); }
                }
            });
        return array;
    }
}