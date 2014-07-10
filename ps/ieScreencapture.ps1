$url = "http://www.fujitsu.com"
$filename = "fujitsu.png"
$format ="png"

$ie = new-object -com InternetExplorer.Application

# URL を開く
$ie.Navigate($url)

# ページをロードし終わるまで待つ
while ($ie.Busy) {sleep -milliseconds 10}

# バー関連はすべて消して IE を可視化
$ie.StatusBar = $false
$ie.ToolBar = $false
$ie.MenuBar = $false
$ie.AddressBar = $false
$ie.Visible = $true
$ie.FullScreen = $true

# IE のウィンドウを前面に持ってくる
$wsh = new-object -com WScript.Shell
$wsh.AppActivate("$ie.name")

# スクリーンキャプチャ
[Reflection.Assembly]::LoadWithPartialName("System.Drawing")
$bitmap = new-object Drawing.Bitmap($ie.Width, $ie.Height)
$graphics = [Drawing.Graphics]::FromImage($bitmap)
$graphics.CopyFromScreen($ie.Left, $ie.Top, 0, 0, $bitmap.Size)
$bitmap.Save($filename, $format)

while ($ie.Busy) {sleep 1}

$ie.Quit()