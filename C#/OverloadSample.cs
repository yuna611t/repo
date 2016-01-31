using System;

class OverloadSample {
    static void Main() {
        Console.WriteLine("----------");
        OverloadThis t1 = new OverloadThis();
        Console.WriteLine("----------");
        OverloadThis t2 = new OverloadThis(8, 9);
        Console.WriteLine("----------");
        OverloadThis t3 = new OverloadThis(t2);
        Console.WriteLine("----------");        
    }
}


class OverloadThis {
    public int x, y;

    public OverloadThis() : this(0, 0) {
        Console.WriteLine("Inside OverloadThis()");
    }

    public OverloadThis(OverloadThis obj) : this(obj.x, obj.y) {
        Console.WriteLine("Inside OverloadThis(OverloadThis obj)");
    }

    public OverloadThis(int i, int j) {
        Console.WriteLine("Inside OverloadThis(OverloadThis(int, int))");
        x = i;
        y = j;
    }
}
