void main() {
  print(createHTMLTag());
}

String createHTMLTag() {
  var html = createTag('html');
  var head = createTag('head');
  var title = createTag('title');
  var body = createTag('body');
  var h1 = createTag('h1');
  var h2 = createTag('h2');
  var p = createTag('p');
  
//  HeadContents
  var titleContents = title('Sample Title');
  var headContents = "";
  headContents += createMetaTag('keywords','Sample keywords');
  headContents += createMetaTag('description','Sample Description');
  headContents += titleContents;
  
//  BodyContents
  var bodyContents = "";
  bodyContents += h1("Sample Head1");
  bodyContents += h2("Sample Head2_01");
  bodyContents += p("this is sample paragraph01.");
  bodyContents += h2("Sample Head2_02");
  bodyContents += p("this is sample paragraph02.");
  
//  assemble HTML  
  headContents = head(headContents);
  bodyContents = body(bodyContents);
  var htmlSource = html('${headContents}\n${bodyContents}');
  return htmlSource;
}

Function createTag(String tag) {
  return (String s) => '<${tag}>\n${s}\n</${tag}>\n';
}

String createMetaTag(String attr, String value) {
  return '<meta name="${attr}" content="${value}">\n';
}

