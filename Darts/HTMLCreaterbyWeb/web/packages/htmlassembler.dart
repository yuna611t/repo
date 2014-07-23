class HTMLAssember {
  
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

}