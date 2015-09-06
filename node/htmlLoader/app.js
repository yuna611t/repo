var fs = require('fs'),
    http = require('http'),
    urlList,
    i
;

// ファイル削除
// fs.unlinkSync('./downloadedhtml/*');


// URLリスト読み込み
fs.readFile('./urllist.txt', 'utf8', function (err, str) {
    urlList = str.split(/\r\n|\r|\n/);
    i = 0;
    // urlごとに処理
    urlList.forEach(function(url) {
        i++;
        createHTMLSource(url, i);
    });
});

function createHTMLSource(url, i) {
    var body = "";
    // 対象URLにアクセス
    http.get(url, function(res) {
        res.setEncoding('utf8');
        res.on('data', function(chunk) {
            body += chunk;
            // アクセス先URLのHTMLソースをファイル保存
            fs.writeFileSync('./downloadedhtml/'+ i +'.txt', body);
        });
    }).on('error', function(e) {
        fs.writeFileSync('./downloadedhtml/'+ i +'.txt', e);
    });
}
