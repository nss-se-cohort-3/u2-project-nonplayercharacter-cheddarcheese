package com.nashss.se.nonplayercharacter.io;

/**
 * A StringPrinter that prints Strings to the user's terminal (aka "console")
 */
public class ConsoleStringPrinter implements StringPrinter {
    @Override
    public void print(String output) {
        System.out.print(output);
    }

    @Override
    public void println(String output) {
        System.out.println(output);
    }
}
