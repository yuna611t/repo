using System;
using Sample2;

namespace Sample1 {
    class A {
        public void Method1() {
            Console.WriteLine("in class A");
        }
    }

    class Program {
        static void Main(string[] args) {
            var x = new A();
            x.Method1();
            // class Programからはclass AのMethod1しか見えないはずなのに、
            // class BのMethod2がclass A経由で支えている
            x.Method2();
        }
    }
}

namespace Sample2 {
    static class B {
        public static void Method2(this Sample1.A a) { // 第一引数はthis と拡張対象の型名
            a.Method1();
            Console.WriteLine("in class B");
        }
    }
}
