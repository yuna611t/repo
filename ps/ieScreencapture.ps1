$url = "http://www.fujitsu.com"
$filename = "fujitsu.png"
$format ="png"

$ie = new-object -com InternetExplorer.Application

# URL ���J��
$ie.Navigate($url)

# �y�[�W�����[�h���I���܂ő҂�
while ($ie.Busy) {sleep -milliseconds 10}

# �o�[�֘A�͂��ׂď����� IE ������
$ie.StatusBar = $false
$ie.ToolBar = $false
$ie.MenuBar = $false
$ie.AddressBar = $false
$ie.Visible = $true
$ie.FullScreen = $true

# IE �̃E�B���h�E��O�ʂɎ����Ă���
$wsh = new-object -com WScript.Shell
$wsh.AppActivate("$ie.name")

# �X�N���[���L���v�`��
[Reflection.Assembly]::LoadWithPartialName("System.Drawing")
$bitmap = new-object Drawing.Bitmap($ie.Width, $ie.Height)
$graphics = [Drawing.Graphics]::FromImage($bitmap)
$graphics.CopyFromScreen($ie.Left, $ie.Top, 0, 0, $bitmap.Size)
$bitmap.Save($filename, $format)

while ($ie.Busy) {sleep 1}

$ie.Quit()