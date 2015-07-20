// setup
var app = require('express')()
    ,http = require('http').Server(app)
    ,io = require('socket.io')(http)
    ,mongoose = require('mongoose')
    // ,Message = require('./model/message.js')
;

// Schema
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

// save message
function saveMessage(message) {
    message.save(function(err) {
        if(err) {console.log("save err: " + err );}
    });
}

// find all message
function findAllMessage() {
    Message.find({}, function(err, docs) {
        if (err) {
            console.log("find error");
        } else {
            for (var i = 0; i < docs.length; i++) {
                var msg = docs[i].message;
                console.log(msg);
                io.emit('chat message', msg);
            }
            // mongoose.disconnect();
        }
    });
}

// has of user control
var userHash = {};

// routing
app.get('/', function(req, res){
  res.sendfile('index.html');
});

//　socket.io.on
io.on('connection', function(socket){
  // connect chat room
  socket.on("con room", function(name) {
      console.log(name + "が入室しました");
      // show old message
      findAllMessage();
  });

  // chat message
  socket.on('chat message', function(msg){
    console.log('message: ' + msg);
    io.emit('chat message', msg);
    // save
    var message = new Message({
        message: msg
    });
    saveMessage(message);
  });
});


// up server
http.listen(3000, function(){
  console.log('listening on *:3000');
});
