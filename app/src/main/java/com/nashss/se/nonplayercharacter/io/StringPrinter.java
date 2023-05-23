package com.nashss.se.nonplayercharacter.io;

/**
 * A interfacd for allowing NonplayerCharacters to print output
 */
public interface StringPrinter {

    /**
     * Display the output without adding a newline
     * @param output The text to display
     */
    void print(String output);

    /**
     * Display the output followed by a newline
     * @param output The text to display
     */
    void println(String output);
}
