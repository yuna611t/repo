resizeTo(400,300);

function MyGetFileName() {
	MyPath = document.getElementById("Mytextbox").value;
	MyScript = new ActiveXObject("Scripting.FileSystemObject");
	MyText1 = MyScript.GetFile(MyPath);
	MyText2 = MyScript.CreateTextFile("D:\\tmp\\data\\sample.txt",true);
	MyText2.WriteLine(MyText1.Path);
	MyText2.Close();
}