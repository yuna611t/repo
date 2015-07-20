var mongoose = require('mongoose');

// Schema Definition
var MemoSchema = new mongoose.Schema({
    title: String
    ,body: String
});
// regist model
var Memo = mongoose.model('Memo', MemoSchema);

// connect mongodb
mongoose.connect('mongodb://localhost/memo', function(err) {
    if (err) {
        console.log(err);
    } else {
        console.log('connection success!!');
    }
});

// finde
Memo.find({}, function(err, docs) {
    if (!err) {
        console.log("num of item => " + docs.length);
        for (var i = 0; i < docs.length; i++) {
            console.log(docs[i]);
        }
        mongoose.disconnect();
        process.exit();
    } else {
        console.log("find error");
    }
});
