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