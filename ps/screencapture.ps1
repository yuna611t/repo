################���O��`################
#�ǂݍ��ރt�@�C��
$fileList = ".\urllist.txt"
#�N������u���E�U
$browserlist = "ieexplore.exe","firefox.exe","chrome.exe"
################���O��`################

$wshell = new-object -com wscript.shell

#�t�@�C�����݃`�F�b�N
if (-not(Test-Path $fileList)) {
	echo "�t�@�C�����Ȃ��ł�"
	exit
}

#url���X�g�ǂݍ���
$urlList = get-content $fileList

#url���X�g���u���E�U���N��
foreach ($url in $urllist){
	#�u���E�U�N��
	foreach ($browser in $browserlist) {
		$wshell.run("${browser} ${url}")
	}
	#2�b�ҋ@
	Start-Sleep -s 2
}

