var http = require('http'),
    url = require('url'),
    fs = require('fs'),
    WebSocketServer = require('ws').Server,
    mongoose = require('mongoose')
;

var member = {};

// ----Definition of MongoDB --------
var Schema = mongoose.Schema;
var commentSchema = new Schema({
    message: {type: String, require: true},
    date: {type: Date, default: Date.now}
});
mongoose.model('Comment', commentSchema);
var db = mongoose.createConnection('mongodb://localhost/chat_db');
var Comment = db.model('Comment');
// ----------------------------------

// ----HTTP Server ---------
var server = http.createServer(function(req, res) {
    res.writeHead(200, {'Content-Type': 'text/html'});
    var output = fs.readFileSync("./index.html", "utf-8");
    res.end(output);
    logger("httpserver", "accessed");
}).listen(process.env.VMC_APP_PORT || 3001);
logger("httpserver", "listening....");

// -------------------------

// ----WebSocket Server ---------
var wss = new WebSocketServer({server: server});
logger("WebSocket", "initialize server");
var connections = [];

wss.on('connection', function(ws) {
    logger("WebSocket on conection", "add websocket to connections : " + ws);
    connections.push(ws);

    // when client send message -- message
    ws.on('message', function(data) {
        logger("WebSocket on message", "recieve: " + data);
        broadcast("From Server Message");
    });

    // when client is disconected
    ws.on('close', function() {
        logger("WebSocket on close", "");
        connections = connections.filter(function(conn, i) {
            logger("on close",  + conn + ", " +  i);
            return (conn === ws) ? false : true;
        });
    });

    function broadcast(message) {
        logger("broadcast",  message);
        connections.forEach(function(con, i) {
            logger("send to ", con);
            con.send(message);
        });
    }

});
// ------------------------------

function logger(title, descripton) {
    console.log("--" + title);
    console.log("  +-" + descripton);
}
