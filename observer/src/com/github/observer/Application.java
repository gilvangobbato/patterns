package com.github.observer;

import com.github.observer.editor.Editor;
import com.github.observer.listeners.EmailNotificationListener;
import com.github.observer.listeners.LogOpenListener;

public class Application {
    public static void main(String[] args) {
        Editor editor = new Editor();
        editor.events.subscribe("open", new LogOpenListener("/path/to/log/file.txt"));
        editor.events.subscribe("save", new EmailNotificationListener("admin@example.com"));

        try {
            editor.openFile("test-1.txt");
            editor.saveFile();
            editor.openFile("test-2.txt");
            editor.openFile("test-3.txt");
            editor.saveFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
