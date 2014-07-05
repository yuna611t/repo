import 'dart:html';
import '../../HTMLCreater/bin/htmlassembler.dart';

void main() {
  querySelector("#sample_text_id")
      ..text = "Click me!"
      ..onClick.listen(reverseText);
}


