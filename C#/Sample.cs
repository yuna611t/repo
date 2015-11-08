using System;

delegate void DelegateAct();

class Program {
    private static void sample() {
        Console.WriteLine("QX");
    }

    static void Main(string[] args) {
        // delegate
        DelegateAct dAct = sample;
        dAct();

        // Action
        Action act = sample;
        act();

        // Lamda
        Action lAct = () => Console.WriteLine("QX");
        lAct();
    }
}
