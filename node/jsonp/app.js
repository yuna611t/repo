var http = require('http'),
    url = require('url');


function cnv(s) {
    console.log(s);
    return s.replace(/¥¥/g,'¥¥¥¥').replace(/"/g, '¥¥"');
}

http.createServer(function(req,res){
    var query = url.parse(req.url, true).query,
        data = [],
        callback,
        returnData,
        key,val
    ;
    
    for (key in query) {
        val = query[key];
        if (key == 'callback' && /^[a-zA-Z]+[0-9a-zA-Z]*$/.test(val)) {
            callback = val;
        } else {
            data.push('"' + cnv(key) + '"' + ':' + '"' + cnv(val) + '"');
        }
    }

    data = "{" + data.join(',') + "}";
    returnData = callback ? callback + "(" + data + ");" : data;

    console.log('Accessed by ' + req.url);
    console.log('createdJson is ' + returnData);
    res.writeHead(200, {'Content-Type':'application/json; charset=utf-8'});
    res.end(returnData);
}).listen(8124);

console.log('Server running ...');
