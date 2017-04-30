var Person = function(name){
    this.name = name;
};
Person.prototype.SayHello = function(){
        console.log('Hello, ' + this.name + '!');
;}

var p1 = new Person('Jhon');
p1.SayHello();

var p2 = new Person('Ryo');
p2.SayHello();
