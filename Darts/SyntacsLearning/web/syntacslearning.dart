import 'dart:html';
import 'LogWriter.dart';
import 'LogWriterToConsole.dart';

void main() {
//  LogWriter log = new LogWriterToConsole();
  LogWriter log = new LogWriter();
	log.writeLog();
}


