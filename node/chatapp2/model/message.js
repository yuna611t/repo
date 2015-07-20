// setup
var mongoose = require('mongoose');
var Schema = mongoose.Schema;
// connect mongodb
mongoose.connect('mongodb://localhost/message', function(err) {
    if (err) {
        console.log(err);
    } else {
        console.log('connection success!!');
    }
});

// create a Schema
var messageSchema = new Schema({
    message: String
});

var Message = mongoose.model('Message', messageSchema);

exports = Message;
