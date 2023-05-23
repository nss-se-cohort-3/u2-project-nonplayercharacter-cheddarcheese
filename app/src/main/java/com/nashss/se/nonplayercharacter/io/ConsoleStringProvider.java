package com.nashss.se.nonplayercharacter.io;

import java.util.Scanner;

/**
 * A StringProvider that returns text the user types in the terminal (aka "console")
 */
public class ConsoleStringProvider implements StringProvider {
    private static final Scanner INPUT = new Scanner(System.in);
    @Override
    public String get() {
        return INPUT.nextLine();
    }
}
