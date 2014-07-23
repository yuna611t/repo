import '../../HTMLCreaterbyWeb/web/packages/htmlassembler.dart';

void main() {
  
  
//set body contents
  var bodyList = new List<Map<String,String>>();
  bodyList.add({'h1':'Sample Head1'});
  bodyList.add({'h2':'Sample Head2_01'});
  bodyList.add({'p':'this is sample paragraph01.'});
  bodyList.add({'h2':'Sample Head2_02'});
  bodyList.add({'p':'this is sample paragraph02.'});
    
//set meta contents
  var metaList = new List<Map<String,String>>();
  metaList.add({'keywords':'Sample keywords'});
  metaList.add({'description':'Sample Description'});

//set title contents  
  var titleList = new List<Map<String,String>>();
  titleList.add({'title':'Sample Title'});

  
  HTMLAssember assembler = new HTMLAssember();
  var bodySrc = assembler.createBodySrc(bodyList);
  var metaSrc = assembler.createMetaSrc(metaList);
  var titleSrc = assembler.createTitleSrc(titleList);
    
//set Contets Map
  var contentsMap = new Map<String,String>();
  contentsMap['meta'] = metaSrc;
  contentsMap['title'] = titleSrc;
  contentsMap['body'] = bodySrc;
  
//assemble html source
  var htmlsource = assembler.assembleHTMLSrc(contentsMap);
  
  print(htmlsource);
}


