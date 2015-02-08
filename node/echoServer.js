var net = require('net');
net.createServer(function(socket) {
    socket.on("data",function(data) {
        console.log(socket.remoteAddress + " " + data);
        socket.write(data);
    });
}).listen(8007,"127.0.0.1");
