package com.javarush.task.task32.task3209;

import javax.swing.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.*;

public class Controller {
    private View view;
    private HTMLDocument document;
    private File currentFile;

    public HTMLDocument getDocument() {
        return document;
    }

    public Controller(View view) {
        this.view = view;
    }
    public static void main(String ... args){
        View view = new View();
        Controller controller = new Controller(view);
        view.setController(controller);

        view.init();
        controller.init();
    }

    public void init(){
        createNewDocument();
    }
    public void exit(){
        System.exit(0);
    }
    public void resetDocument(){
        if(document != null){
            document.removeUndoableEditListener(view.getUndoListener());

        }
        document = (HTMLDocument) new HTMLEditorKit().createDefaultDocument();
        document.addUndoableEditListener(view.getUndoListener());
        view.update();
    }
    public void setPlainText(String text){
        resetDocument();
        StringReader reader = new StringReader(text);
        try {
            new HTMLEditorKit().read(reader, document, 0);
        }
        catch (Exception e){
            ExceptionHandler.log(e);
        }
    }

    public String getPlainText(){
        StringWriter writer= new StringWriter();
        try{
        new HTMLEditorKit().write(writer,document,0,document.getLength());
        }
        catch (Exception e){
            ExceptionHandler.log(e);
        }
        return writer.toString();
    }
    public void createNewDocument(){
        view.selectHtmlTab();
        resetDocument();
        view.setTitle("HTML редактор");
        view.resetUndo();
        currentFile = null;
    }
    public void openDocument(){
        view.selectHtmlTab();
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new HTMLFileFilter());
        chooser.setDialogTitle("Open File");
        if(chooser.showOpenDialog(view) == JFileChooser.APPROVE_OPTION){
            currentFile = chooser.getSelectedFile();
            resetDocument();
            view.setTitle(currentFile.getName());
            try {
                FileReader writer = new FileReader(currentFile);
                new HTMLEditorKit().read(writer,document,0);
                view.resetUndo();
            }
            catch (Exception e){
                ExceptionHandler.log(e);
            }
        }

    }
    public void saveDocument(){
        view.selectHtmlTab();
        if(currentFile == null)
            saveDocumentAs();
        else{
            try {
                FileWriter writer = new FileWriter(currentFile);
                new HTMLEditorKit().write(writer,document,0,document.getLength());
            }
            catch (Exception e){
                ExceptionHandler.log(e);
            }
        }
    }
    public void saveDocumentAs(){
        view.selectHtmlTab();
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new HTMLFileFilter());
        chooser.setDialogTitle("Save File");
        if(chooser.showSaveDialog(view) == JFileChooser.APPROVE_OPTION){
            currentFile = chooser.getSelectedFile();
            view.setTitle(currentFile.getName());
            try {
                FileWriter writer = new FileWriter(currentFile);
                new HTMLEditorKit().write(writer,document,0,document.getLength());
            }
            catch (Exception e){
                ExceptionHandler.log(e);
            }
        }

    }
}
