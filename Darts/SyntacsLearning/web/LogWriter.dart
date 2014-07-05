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
    var callFunc = logTag('Call Function');
    var s = callFunc('hello');
    print(s);
    endInitialLog();

  }

/**
*  
*/
  Function logTag(String tag) {
  	return (String s) => '${tag}:${s}';
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
  void logTime() {
    DateTime now = new DateTime.now();
    print('Time: ' + now.toString());
  }

}
