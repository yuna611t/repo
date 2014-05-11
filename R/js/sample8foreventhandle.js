<!--

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

//-->