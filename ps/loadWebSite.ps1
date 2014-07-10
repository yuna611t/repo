################事前定義################
#読み込むファイル
$fileList = ".\urllist.txt"
#タイトルリスト出力先
$titledir = ".\title"
#HTMLファイル出力先
$downloaddir = ".\download"
################事前定義################


#ファイル存在チェック
write-host "ファイル存在チェック"
if (-not(Test-Path $fileList)) {
	echo "ファイルがないです"
	exit
}

#urlリスト読み込み
write-host "urlリスト読み込み"
$urlList = get-content $fileList
write-host "urlリスト $urlList"

#WebClient初期化
write-host "WebClient初期化"
$wc = New-Object System.Net.WebClient
$i = 0

#urlリスト分処理
foreach ($url in $urllist){
    $i++
    write-host "-------${i} ${url}の処理開始-------"

    #urlから文字列を取得"
    write-host "urlから文字列を取得"
    $html = getHtmlString $url
    #タイトルを取得
    write-host "タイトルを取得"
    $title = getTitle $html
    $str = "${i}`t${title}`t${url}`n"
    
    #タイトルを出力
    write-host "タイトルを出力"
    $str >> "$titledir\title.txt"

    #念のためHTMLファイルも保存
    write-host "念のためHTMLファイルも保存"
    $fileName = "$downloaddir\$i.html"
    $wc.DownloadFile($url,$fileName)

}

function getHtmlString($url) {
    #urlの文字列取得
    $st = $wc.OpenRead($url)
    #エンコード設定
    [Reflection.Assembly]::LoadWithPartialName("mscorlib")
    $enc = [System.Text.Encoding]::GetEncoding("UTF-8")
    #$htmlに文字列を保存
    $sr = New-Object System.IO.StreamReader($st,$enc)
    $html = $sr.ReadToEnd()
    $sr.Close()
    return $html
}

function getTitle($html) {
    #Title文字を取得
    $title = [regex]::Match($html,"<title>(\n|.)*</title>","IgnoreCase")
    $title = $title.value
    #改行と前後のスペースを削除
    $title = [Regex]::Replace($title,"<title>(\n|\s)*","")
    $title = [Regex]::Replace($title,"(\n|\s)*</title>","") 
    return $title
}

