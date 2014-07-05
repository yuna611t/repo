/**
* 
* Use for Logger
*/
class LogWriter {

  /**
 * 
 * Write Log to Console;
 */
  void writeLog() {
    startInitialLog();
    print('This is Log Sample');
    logTime();
    endInitialLog();
  }
  
  /**
   * start Loging
   */
  void startInitialLog() {
    print('[-----------------Start Log-----------------]');
  }
  
  /**
  * end Loging
  */
  void endInitialLog() {
    print('[-----------------End Log-----------------]');
  }

  /**
   * Log Time
   */
  String getLogTime() {
    DateTime now = new DateTime.now();
    return 'Time:\t${now}';    
  }
  void logTime() {
    print(getLogTime());
  }
  


}
