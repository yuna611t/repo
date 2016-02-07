var http = require('http'),
    url = require('url'),
    fs = require('fs'),
    socketio = require('socket.io')
;

var member = {};

// ----HTTP Server ---------
var server = http.createServer(function(req, res) {
    res.writeHead(200, {'Content-Type': 'text/html'});
    var output = fs.readFileSync("./index.html", "utf-8");
    res.end(output);
    logger("httpserver", "accessed");
}).listen(process.env.VMC_APP_PORT || 3002);
logger("httpserver", "listening....");

// -------------------------

// ----Socket.io Server ---------
var io = socketio.listen(server);
io.sockets.on("connection", function(socket) {

    socket.on("message", function(data) {
        logger("Socket.io on message", "recieve: " + data);
        socket.broadcast.emit("message", data);
    });

    socket.on("disconnect", function() {
        logger("socket.io on disconnect", "");
    });
});
// ------------------------------

function logger(title, descripton) {
    console.log("--" + title);
    console.log("  +-" + descripton);
}
