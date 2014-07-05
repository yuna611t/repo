import 'LogWriterToConsole.dart';

/**
 * LogWrite to Console
*/
class LogWriterToConsoleForXML extends LogWriterToConsole {
  
  /**
  * 
  * Write Log to Console;
  */
   void writeLog() {

     var headLog = sroundLogBody('Logger');
     
     var funcLog = sroundLogBody('Function');
     var funcHelloLog = sroundLogBody('helloFunc'); 
     var propLog = sroundLogBody('Property');
     
     var propidLog = sroundLogBody('id');
     var idLog = propidLog('001');
     var propNameLog = sroundLogBody('name');
     var nameLog = propNameLog('taro');
     
     var s = headLog(funcLog(funcHelloLog(propLog(idLog + '\n' + nameLog))));
     print(s);

   }
   
   Function sroundLogBody(String tag) {
     return (String s) => '<${tag}>\n${s}\n</${tag}>';
   }
   
  
}