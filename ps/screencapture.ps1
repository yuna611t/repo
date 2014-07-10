################事前定義################
#読み込むファイル
$fileList = ".\urllist.txt"
#起動するブラウザ
$browserlist = "ieexplore.exe","firefox.exe","chrome.exe"
################事前定義################

$wshell = new-object -com wscript.shell

#ファイル存在チェック
if (-not(Test-Path $fileList)) {
	echo "ファイルがないです"
	exit
}

#urlリスト読み込み
$urlList = get-content $fileList

#urlリスト分ブラウザを起動
foreach ($url in $urllist){
	#ブラウザ起動
	foreach ($browser in $browserlist) {
		$wshell.run("${browser} ${url}")
	}
	#2秒待機
	Start-Sleep -s 2
}

