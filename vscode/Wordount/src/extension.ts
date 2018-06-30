'use strict';
// The module 'vscode' contains the VS Code extensibility API
// Import the module and reference it with the alias vscode in your code below
import {window, commands, Disposable, ExtensionContext, StatusBarItem, StatusBarAlignment, TextDocument} from 'vscode';

// this method is called when your extension is activated
// your extension is activated the very first time the command is executed
export function activate(context: vscode.ExtensionContext) {

    // Use the console to output diagnostic information (console.log) and errors (console.error)
    // This line of code will only be executed once when your extension is activated
    console.log('Congratulations, your extension "Wordount" is now active!');


    let wordCounter = new WordCounter();
    let controller = new WordCounterController(wordCounter);

    context.subscriptions.push(controller);
    context.subscriptions.push(wordCounter);
}

// this method is called when your extension is deactivated
export function deactivate() {
}

class WordCounter {
    private _statusBarItem: StatusBarItem = window.createStatusBarItem(StatusBarAlignment.Left);

    public updateWordCount() {
        let editor = window.activeTextEditor;
        if (!editor) {
            this._statusBarItem.hide();
            return;
        }

        let doc = editor.document;

        if (doc.languageId === 'markdown') {
            let wordCount = this._getWordCount(doc);

            this._statusBarItem.text = wordCount !== 1 ? `$(pencil) ${wordCount} Words` : '$(pencil) 1 Word';
            this._statusBarItem.show();
        } else {
            this._statusBarItem.hide();
        }
    }

    public _getWordCount(doc: TextDocumnent): number {
        let docContent = doc.getText();

        docContent = docContent.replace(/(< ([^>]+)<)/g, '').replace(/\s+/g, ' ');
        docContent = docContent.replace(/^\s\s*/, '').replace(/\s\s*$/, '');
    
        let wordCount = 0;
        if (docContent !== "") {
            wordCount = docContent.split(" ").length;
        }
        return wordCount;
    }

    dispose() {
        this._statusBarItem.dispose();
    }
}

class WordCounterController {
    private _wordCounter: WordCounter;
    private _disposable: Disposable;

    constructor(wordCounter: WordCounter) {
        this._wordCounter = wordCounter;

        let subscriptions: Disposable[] = [];
        window.onDidChangeTextEditorSelection(this._onEvent, this, subscriptions);
        window.onDidChangeActiveTextEditor(this._onEvent, this, subscriptions);

        this._wordCounter.updateWordCount();

        this._disposable = Disposable.from(...subscriptions);
    }

    dispose() {
        this._disposable.dispose();
    }

    private _onEvent() {
        this._wordCounter.updateWordCount();
    }
}