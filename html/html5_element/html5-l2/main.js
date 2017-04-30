var Person = function(name){
    this.name = name;
    this.SayHello = function(){
        console.log('Hello, ' + this.name + '!');
    }
};

var p1 = new Person('Jhon');
p1.SayHello();