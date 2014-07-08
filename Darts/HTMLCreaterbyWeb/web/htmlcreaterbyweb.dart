import 'dart:html';

void main() {
  
  querySelector("#createHTML").onClick.listen(eventHandler1);
 }

/**
 * 入力フィールドの文字列をHTMLタグ付きの文字列に変換して出力フィールドに出力する。
 * @method convertTextToTagText
 * @param event MouseEvent　マウスイベント
 * @return なし
 */
void eventHandler1(MouseEvent event) {
//　　HTMLタグの種類を取得
  var inputTag = getInputTag();
//  入力フィールドの文字列を取得
  var inputText = getInputText();
//　取得した文字列をタグ付きの文字列に変換
  var convText = convertTextToTagText(inputTag, inputText);
//　出力フィールドの文字列を取得
  var existingText = getExistingText();
//　既存の文字列を新規取得した文字列を合成
  var outputText = getConcatText(existingText,convText);
//　出力フィールドに合成した文字列を出力
  querySelector("#outputText").value = outputText;
}

/**
 * 使用するタグを取得
 * @method getInputTag
 * @param なし
 * @return タグの種類を指定する文字列
 * 
 */
String getInputTag() {
  var tagText = "";
  tagText = querySelector("[name=bodyTag]:checked").value;
  return tagText;
}

/**
 * 入力フィールドの値を取得する
 * @method getInputText
 * @param なし
 * @return 入力フィールドの値
 */
String getInputText() {
  var inputText = "";
  inputText = querySelector("#inputText").value;
  return inputText;
}

/**
 * 文字列をHTMLタグ付きの文字列に変換する
 * @method convertTextToTagText
 * @param tag String
 * @param text String
 * @return HTMLタグつきの文字列
 */
String convertTextToTagText(String tag,String text) {
//  TODO 変換のダミー処理
  var outputText = "";
  outputText = "<${tag}>${text}</${tag}>";
  return outputText;
}

/**
 * 出力フィールドに既に入っている文字列を取得する
 * @method getExistingText
 * @param なし
 * @return 既に出力フィールドにある文字列
 */
String getExistingText() {
  var existingText = "";
  existingText = querySelector("#outputText").value;
  return existingText;
}

/**
 * 出力フィールドに文字列を出力する。
 * getConcatText
 * @param text1 前半部分の文字列
 * @param text2 後半部分の文字列
 * @return text1とtext2を合成した文字列
 */
String getConcatText(String text1,String text2) {
  text1 = text1 != "" ? "${text1}\n${text2}":text2;
  return text1;
}