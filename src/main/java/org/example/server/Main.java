package org.example.server;

import org.example.UI.MainUI;
import org.example.server.Utils.DataLoader;

public class Main {
    public static void main(String[] args) {
        DataLoader.load();
        MainUI.homePage();
    }
}