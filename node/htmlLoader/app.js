var fs = require('fs'),
    http = require('http'),
    urlList = "",
    linenumber = 0
;

// ファイル削除
// fs.unlinkSync('./downloadedhtml/*');


// URLリスト読み込み
fs.readFile('./urllist.txt', 'utf8', function (err, str) {
    urlList = str.split(/\r\n|\r|\n/);
    // urlごとに処理
    urlList.forEach(function(url) {
        createHTMLSource(url, ++linenumber);
    });
});

/**
 * HTMLソースファイルを生成する
 * @param  {string} url        HTMLファイル取得対象URL
 * @param  {int} linenumber 処理対象の行番号
 * @return {boolean}            正常にHTMLソース生成できたかどうか
 */
function createHTMLSource(url, linenumber) {
    var body = "";
    // 対象URLにアクセス
    http.get(url, function(res) {
        res.setEncoding('utf8');
        res.on('data', function(chunk) {
            body += chunk;
            // アクセス先URLのHTMLソースをファイル保存
            fs.writeFileSync('./downloadedhtml/'+ linenumber +'.txt', body);
            return true;
        });
    }).on('error', function(e) {
        fs.writeFileSync('./downloadedhtml/'+ linenumber +'.txt', e);
        return false;
    });
}
