var fs = require('fs'),
    http = require('http'),
    urlList,
    body
;

// URLリスト読み込み
fs.readFile('./urllist.txt', 'utf8', function (err, str) {
    urlList = str.split(/\r\n|\r|\n/);
    // urlごとに処理
    urlList.forEach(function(url){
        // 対象URLにアクセス
        http.get(url, function(res) {
          res.setEncoding('utf8');
          res.on('data', function(chunk) {
            body += chunk;
            // アクセス先URLのHTMLソースをファイル保存
            fs.writeFile('./downloadedhtml/writetest.txt', body , function (err) {
                console.log(err);
            });
          });
        }).on('error', function(e) {
          console.log("Got error: " + e.message);
        });
    });
});
