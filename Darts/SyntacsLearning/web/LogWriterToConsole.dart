import 'LogWriter.dart';


/**
 * LogWrite to Console
*/
class LogWriterToConsole extends LogWriter {
  
  /**
  * 
  * Write Log to Console;
  */
   void writeLog() {
     
     print('[-----------------Start Log-----------------]');
     logTime();
     print('[-----------------End Log-----------------]');
   }

  
}