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

var server = http.createServer(function(req, res) {
    res.writeHead(200, {'Content-Type': 'text/html'});
    var output = fs.readFileSync("./index.html", "utf-8");
    res.end(output);
}).listen(process.env.VMC_APP_PORT || 3001);
