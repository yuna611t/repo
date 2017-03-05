using System;

class StaticMethodTest {
    public static void Main(string[] Args) {
        MyClass m = new MyClass();
        MyClass.StaticMethod(m);
    }
}

class MyClass {
    void NonStaticMethod() {
        Console.WriteLine("NonStaticMethod");
    }

    // Staticメソッドからインスタンスメソッドを呼び出す
    public static void StaticMethod(MyClass obj) {
        obj.NonStaticMethod();
    }
}
