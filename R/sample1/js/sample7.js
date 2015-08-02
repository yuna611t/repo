<!--
resizeTo(450,200);
var MyArray1 = new Array("(データファイルを取得してください)");

window.onload = function() {

	MyGetParameter(1);

	parseTags('input');
	
}

function parseTags(_tagname) {
	var objTemp = document.getElementsByTagName(_tagname);
	for ( var i = 0; i < objTemp.length; i++) {
		var aryTemp = objTemp[i].className.toLowerCase().split(' ');
		for (var j = 0; j < aryTemp.length; j++) {
			doClassNameEvent(objTemp[i],aryTemp[j]);
		}
	}	
}

function doClassNameEvent(_tag, _classname) {
	if (_classname == 'mybutton') {
		_tag.onclick = function() {
			MyGetParameter(2);
		}
	} else if (_classname == 'go') {
		_tag.onclick = function() {
			Go();
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
	window.alert("変数：" + $("MySelect").value + " が選択されています");
}


//-->