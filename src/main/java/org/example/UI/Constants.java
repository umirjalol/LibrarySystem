package org.example.UI;

import java.util.Scanner;

public interface Constants {
    Scanner SCANNER = new Scanner(System.in);
    Scanner INT_SCANNER = new Scanner(System.in);

    String ANSI_RESET = "\u001B[0m";
    String ANSI_RED = "\u001B[31m";
    String ANSI_GREEN = "\u001B[32m";
    String ERROR_INPUT = "Enter correct command";

}
