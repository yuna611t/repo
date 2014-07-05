void main() {

//set body contents
  var bodyMap = new Map<String, String>();
  bodyMap['h1'] = 'Sample Head1';
  bodyMap['h2'] = 'Sample Head2_01';
  bodyMap['p'] = 'this is sample paragraph01.';
  bodyMap['h2'] = 'Sample Head2_02';
  bodyMap['p'] = 'this is sample paragraph02.';
  var bodySrc = createBodySrc(bodyMap);

//set meta contents
  var metaMap = new Map<String,String>();
  metaMap['keywords'] = 'Sample keywords';
  metaMap['description'] = 'Sample Description';
  var metaSrc = createMetaSrc(metaMap);
  
//set title contents  
  var titleMap = new Map<String,String>();
  titleMap['title'] = 'Sample Title';
  var titleSrc = createBodySrc(titleMap);
  
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

String createBodySrc(Map map) {
  var src = "";
  map.forEach((String key, String value) {
    var tag = createTag(key);
    src += tag(value); 
  });
  return src;
}

String createMetaSrc(Map map) {
  var src = "";
  map.forEach((String key, String value) {
    src += createMetaTag(key,value);
  });
  return src;
}

Function createTag(String tag) {
  return (String s) => '<${tag}>${s}</${tag}>\n';
}

String createMetaTag(String attr, String value) {
  return '<meta name="${attr}" content="${value}">\n';
}
