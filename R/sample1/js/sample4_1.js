resizeTo(300,150);
MyArray1 = new Array("リンクA","リンクB");
MyArray2 = new Array("リンクC","リンクD");
MyValue1 = new Array("sample4_2.hta","samle4_2.hta");
MyValue2 = new Array("sample4_2.hta","samle4_2.hta");
ListNumber = 2;

function $(_id) {
	return document.getElementById(_id);
}

function Switch(nType) {
	for(var i = 0; i < ListNumber; i++) {
		if (nType == 1) {
			$("MySelect").options[i].text = MyArray1[i];
			$("MySelect").options[i].value = MyValue1[i];
		} else if (nType == 2) {
			$("MySelect").options[i].text = MyArray2[i];
			$("MySelect").options[i].text = MyValue2[i];	
		}
	}
}

function Go() {
	MyShell = new ActiveXObject("WScript.Shell");
	MyShell.Run($("MySelect").value,1,false);
}