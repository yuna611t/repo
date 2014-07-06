<!--
resizeTo(500,250);
var MyArray = new Array("（データファイルを取得してください）");

// ロード時に実行
window.onload = function() {
	MyGetParameter(1);

// イベントハンドルするタグを設定
	eventHandler('input');	

}

// 所得したタグ名をパースしてクラス名で
function eventHandler(_tagname) {
	var objTemp = document.getElementsByTagName(_tagname);
	for (var i = 0; objTemp.length; i++) {
		var aryTemp = objTemp[i].className.toLowerCase().split(' ');
		for (var j = 0; j < aryTemp.length; j++) {
			// クラス名で処理を振り分ける
			doClassNameEvent(objTemp[i],aryTemp[j]);
		}
	}
}

// クラス名で処理を振り分ける
function doClassNameEvent(_tag,_classname) {
	if (_classname == 'my-get-parameter2') {
		_tag.onclick = function() {
			MyGetParameter(2);
		}
	} 
}


function $(_id) {
	return document.getElementById(_id);
}

function MyGetParameter(nType) {
	if (nType == 1) {
		for (var i = 0; i < MyArray1.length; i++) {
			$("MySelect").options[i].text = MyArray1[i];
			$("MySelect").options[i].value = MyArray1[i];
		}
	} else if (nType == 2) {
		MyPath = $("file").value;
		MyScript = new ActiveXObject("Scripting.FileSystemObject");
		MyFile = MyScript.OpenTextFile(MyPath,1,true);
		MyText = MyFile.ReadLine();
		MyFile.close();
		MyArray1 = MyText.split(",");
		for (var i = 0; i < MyArray1.length; i++) {
			$("MySelect").options[i] = new Option(MyArray1[i],MyArray1[i]);
		}
	}
}

function Go() {
	MyScript= new ActiveXObject("Scripting.FileSystemObject");
	MyShell = new ActiveXObject("Wscript.Shell");
	MyPath = $("Mytextbox").value.replace(/\\/g,"/");
	MyFolder = MyScript.GetParentFolderName(location.href).substr("file:///*.length");
	MyText = MyScript.CreateTextFile(MyFolder + '/source.R', true);

	MyText.WriteLine('x <- read.csv("' + MyPath + ')');
	if ($("MyRadio1").checked) {
		MyText.WriteLine('bmp("' + MyFolder 
			+ '/result.bmp");'
			+ 'hist(x$' 
			+ $("MySelect").value + ');' + 'dev.off()');
	} else if ($("MyRadio2").checked) {
			+ '/result.bmp");'
			+ 'boxplot(x$' 
			+ $("MySelect").value + ');' + 'dev.off()');
	} else if ($("MyRadio3").checked) {
			+ '/result.bmp");'
			+ 'plot(x$' 
			+ $("MySelect").value + ');' + 'dev.off()');
	}
	MyText.close();

	MyCommand = '"D:\dev\R\R-3.0.3\bin\R.exe" '
		+ '--no-restore --no-save < "'
		+ MyFolder + '/source.R"';

	MyShell.Exec(MyCommand);
	window.alert("変数 " + $("MySelect").value + "のグラフを作成します");
	MyShell.Excec('mspaint "' + MyFolder + '/result.bmp');
}

//-->