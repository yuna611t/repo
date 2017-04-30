var person = {
    name: 'Tom',
    sex: 'man',
    email: 'dummy@dummy',
    age: 32,
    sayHello: function() {
        console.log('Hello, ' + this.name + '!');
    }
};

person.sayHello();

for(var key in person) {
    if (typeof(person[key]) !== 'function') {
        console.log(key, ":", person[key]);
    } else {
        console.log(key, ":");
        person[key]();
    }
}

var obj = {
    f1: function(){

        var that = this;
        console.log(that);
        var fn = function(){
            console.log(that);
        }
        fn();
    }
}
obj.f1();

var obj1 = {
    f1: function(){
        // thisのメソッド呼び出し => 自オブジェクト
        console.log(this);
    }
}
obj1.f1();

var obj2 = function(){
    // thisの関数呼び出し => windowオブジェクト
    console.log(this);
}
obj2();