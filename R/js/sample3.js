resizeTo(200,250);
function MyGetParameter () {
	MyVariable01 = document.MyForm.Mytextbox01;
	MyVariable02 = document.MyForm.Mytextbox02;
	if (MyVariable01 != "" & MyVariable02 != "") {
		MyScript = new ActiveXObject("Scripting.FileSystemObject");
		MyText = MyScript.CreateTextFile("D:\\tmp\\data\\sample3.R", true);
		MyText.WriteLine("n <- " + MyVariable01.value + " ;");
		MyText.WriteLine("k <- " + MyVariable02.value + " ;");
		MyText.Close();
	}
	window.alert("セーブ完了:\n n = " + MyVariable01.value
		+ "\n k = " + MyVariable02.value);
}