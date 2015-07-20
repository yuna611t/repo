var mongoose = require('mongoose');

// 定義
var Schema = mongoose.Schema;
var UserSchema = new Schema({
    name: String
    ,point: Number
});
mongoose.model('User',UserSchema);

// Create User
mongoose.model('User', UserSchema);
var User = mongoose.model('User');
var user = new User();
user.name = 'Yuta';
user.point = 777;
user.save(function(err){
    if (err) {console.log(err);}
});

// Find All User
User.find({}, function(err, docs){
    for(var i = 0, size = docs.length; i < size; ++i) {
        console.log(docs[i].doc.name);
    }
});
