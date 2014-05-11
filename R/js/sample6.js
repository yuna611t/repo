resizeTo(400,300);

function MyGetFileName() {
	MyPath = document.getElementById("Mytextbox").value;
	MyScript = new ActiveXObject("Scripting.FileSystemObject");
	MyFile = MyScript.OpenTextFile(MyPath,1,true);
	MyText = MyFile.ReadLine();
	MyFile.close();
	MyArray = MyText.split(",");
	window.alert(MyArray);
}