var Person = function(name){
    this.name = name;
};
Person.prototype.SayHello = function(){
        console.log('Hello, ' + this.name + '!');
};

var Hero = function(name, level, job){
    this.name = name;
    this.level = level;
    this.job = job;
    this.SayStatus = function(){
        console.log(this.name, ":", this.level, ":", this.job);        
    }
};
/*
Hero.prototype.SayStatus = function(){
    console.log(this.name, ":", this.level, ":", this.job);
};
*/

Hero.prototype = new Person();

var hero1 = new Hero('Jhone', 2, 'Monk');
hero1.SayHello();
hero1.SayStatus();