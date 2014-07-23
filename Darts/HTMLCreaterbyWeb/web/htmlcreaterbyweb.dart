import 'dart:html';

void main() {
  
  querySelector("#bodyTag")
    ..onBlur.listen((e) => validTag());
  
  querySelector("#createHTML")
      ..onClick.listen((e) => setHtmlSource());
}

setHtmlSource() {
  var tag = querySelector("#bodyTag");
  var content = querySelector("#bodyText");
  var generatedContent = querySelector("#generatedHTML");
  
  var tagSrc = tag.value;
  var contentSrc = content.value;
  var bodyList = new List<Map<String,String>>();
  bodyList.add({'$tagSrc':'$contentSrc'});
  var htmlsource = generatedContent.value  + createBodySrc(bodyList);
   
  generatedContent
    ..text = htmlsource;

  tag.value = "";
  content.value = "";
  
  tag.focus();
  
}

//Bodyタグの中身になるソース生成(汎用)
String createBodySrc(List list) {
  var src = "";
  list.forEach((Map m) {
    m.forEach((String key, String value){
      var tag = createTag(key);
      src += tag(value);
    });
  });
  return src;
}

// HTMLタグ生成
Function createTag(String tag) {
  return (String s) => '<${tag}>${s}</${tag}>\n';
}

// タグの入力チェック
validTag() {
  var allowedTag = querySelector("#allowedTag");
  var tagList = allowedTag.innerHtml.split(',');
//      ['h1','h2','h3','p','span'];
    
  var tag = querySelector("#bodyTag");
  var tagSrc= tag.value;
  var isTag = false;
  
  for (var item in tagList) {
    if (item == tagSrc) {
      return isTag = true;  
    }
  }

  if (!isTag) {
    tag.value = "";
    tag.focus();      
  }

}

