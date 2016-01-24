/**
 * syncronized修飾の有無による挙動の違いを確認する
 */
class SyncTest {

    // カウンターの取得
    static Counter counter = Counter.getCounter();

    /**
     * カウント1000件のカウントアップスレッドを実行する。
     * @param args コマンドライン引数
     */
    public static void main(String[] args) {
        MyThread[] threads = new MyThread[1000];
        // カウントアップスレッドを1000件起動する。
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new MyThread();
            threads[i].start();
        }

        // カウントアップスレッドの完了を待つ
        for(int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }

        System.out.println(counter.getCount());
    }
}

/**
 * カウントアップするスレッド
 */
class MyThread extends Thread {
    public void run() {
        SyncTest.counter.countUp();
    }
}

/**
 * カウンター
 */
class Counter {
    private static Counter instance = null;
    private int count;

    /**
     * Singleton化
     */
    private Counter() {}

    /**
     * Counterクラスのインスタンスを返す
     * @return Counterクラスのインスタンス
     */
    static Counter getCounter() {
        if (instance == null) {
            instance = new Counter();
        }
        return instance;
    }

    /**
     * カウントアップし、現在のカウントを表示する
     * 表示例: [1], [2]
     */
    void countUp() {
        System.out.print("[");
        int n = count;
        System.out.print(n);
        count = n + 1;
        System.out.println("]");
    }

    /**
     * 現在のカウント数
     * @return 現在のカウント数
     */
    public int getCount() {
        return this.count;
    }
}
