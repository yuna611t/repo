var http = require('http');
var url = require('url');
function cnv(s) {
    console.log(s);
    return s.replace(/¥¥/g,'¥¥¥¥').replace(/"/g, '¥¥"');
}

http.createServer(function(req,res){
    var query = url.parse(req.url, true).query;
    var data = [];
    var callback;
    for (var key in query) {
        var val = query[key];
        // if (key == 'callback' && /^[a-zA-Z]+[0-9a-zA-Z]*$/.test(val)) {
        //     callback = val;
        // } else {
            data.push('"' + cnv(key) + '"' + ':' + '"' + cnv(val) + '"');
        // }
    }

    data = "{" + data.join(',') + "}";

    console.log('Accessed by ' + req.url);
    console.log('createdJson is ' + data);
    res.writeHead(200, {'Content-Type':'application/json; charset=utf-8'});
    res.end( "callback" + "(" + data + ");" );
    // res.end( callback ? callback + "(" + data + ");" : data);
}).listen(8124);

console.log('Server running ...');
