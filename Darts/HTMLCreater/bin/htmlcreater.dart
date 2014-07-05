void main() {

//set body contents
  var bodyList = new List<Map<String,String>>();
  bodyList.add({'h1':'Sample Head1'});
  bodyList.add({'h2':'Sample Head2_01'});
  bodyList.add({'p':'this is sample paragraph01.'});
  bodyList.add({'h2':'Sample Head2_02'});
  bodyList.add({'p':'this is sample paragraph02.'});
    
  var bodySrc = createBodySrc(bodyList);

//set meta contents
  var metaList = new List<Map<String,String>>();
  metaList.add({'keywords':'Sample keywords'});
  metaList.add({'description':'Sample Description'});
  var metaSrc = createMetaSrc(metaList);
  
//set title contents  
  var titleList = new List<Map<String,String>>();
  titleList.add({'title':'Sample Title'});
  var titleSrc = createTitleSrc(titleList);
  
//set Contets Map
  var contentsMap = new Map<String,String>();
  contentsMap['meta'] = metaSrc;
  contentsMap['title'] = titleSrc;
  contentsMap['body'] = bodySrc;
  
//assemble html source
  var htmlsource = assembleHTMLSrc(contentsMap);
  
  print(htmlsource);
}

String assembleHTMLSrc(Map<String,String> map) {
  var html = createTag('html');
  var head = createTag('head');
  var body = createTag('body');
  
  var src = "";
  var headSrc = "";
  var bodySrc = "";
  
  map.forEach((String key, String value){
    
    if (key == "body") {
      bodySrc += body(value);
    } else {
      headSrc += value;
    }
    
  });
  
  headSrc = head(headSrc);
  
  src = html('${headSrc}\n${bodySrc}');
  
  return src;
}

//Bodyタグの中身になるソース生成
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

//Title部分のタグを生成
String createTitleSrc(List list) {
  var src = "";
  list.forEach((Map m) {
    m.forEach((String key, String value){
      var tag = createTitleTag(key);
      src += tag(value);
    });
  });
  return src;
}

//Metaタグのソース生成
String createMetaSrc(List list) {
  var src = "";
  list.forEach((Map m){
    m.forEach((String key,String value){
      src += createMetaTag(key,value);      
    });
  });
  return src;
}

Function createTag(String tag) {
  return (String s) => '<${tag}>${s}</${tag}>\n';
}

Function createTitleTag(String tag) {
  return (String s) => '\n<${tag}>${s}</${tag}>';
}

String createMetaTag(String attr, String value) {
  return '\n<meta name="${attr}" content="${value}">';
}

