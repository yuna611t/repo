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
    user: {
        id: Number
        ,name: String
    }
    ,message: String
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
                var msg = docs[i];
                // console.log(msg.user.name + ' ' + msg.message);
            }
        }
    });
}

// has of user control
var userHash = {};

// routing
app.get('/', function(req, res){
  res.sendfile('index.html');
});

// jsonserver
app.get('/json/oldmessages', function(req, res) {
    Message.find(function(err, msgs) {
        if (err) {
            console.log(err);
        }
        res.json(msgs);
    });
});

//　socket.io.on
io.on('connection', function(socket){
  // connect chat room
  socket.on("con room", function(user) {
      console.log(user.name + "が入室しました");
      userHash[socket.id] = user;
      // show old message
    //   findAllMessage();
  });

  // chat message
  socket.on('chat message', function(msg){
    console.log('user.name: ' + msg.user.name);
    console.log('message: ' + msg.message);
    io.emit('chat message', msg);
    // save
    var message = new Message({
        user: {
            name: msg.user.name
        }
        ,message: msg.message
    });
    saveMessage(message);
  });
});


// up server
http.listen(3000, function(){
  console.log('listening on *:3000');
});
