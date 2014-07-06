import 'dart:html';
import 'LogWriter.dart';
import 'LogWriterToConsole.dart';
import 'LogWriterToConsoleForXML.dart';


void main() {
  LogWriter log = new LogWriterToConsoleForXML();
//  LogWriter log = new LogWriter();
	log.writeLog();
}


