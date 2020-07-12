package com.epamcourse.homework5.console;

import java.util.Scanner;

public class ConsoleProcessor {
    public String readString() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Print the string");
        String line = scanner.nextLine();
        return line;
    }
}
