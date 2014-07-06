import 'dart:html';

void main() {
  querySelector("#text_1")
      ..text = "Click me!"
      ..onClick.listen(reverseText);
}

void reverseText(MouseEvent event) {
  var text = querySelector("#text_1").text;
  var buffer = new StringBuffer();
  for (int i = text.length - 1; i >= 0; i--) {
    buffer.write(text[i]);
  }
  querySelector("#text_1").text = buffer.toString();
}
