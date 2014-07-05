/**
* 
* Use for Logger
*/
class Logwiter {

 /**
 * 
 * Write Log to Console;
 */
  void writeLog() {

    // ログ記録用
    DateTime now = new DateTime.now();

    print('[-----------------Start Log-----------------]');
    print('Time: ' + now.toString());
    print('[-----------------End Log-----------------]');

  }
}
