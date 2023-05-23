package com.nashss.se.nonplayercharacter.io.mocks;

import com.nashss.se.nonplayercharacter.io.StringPrinter;

import java.util.ArrayList;
import java.util.List;

/**
 * A "fake" StringPrinter that saves all the Strings printed into a list
 * This class is used in unit tests.
 */
public class MockStringPrinter implements StringPrinter {

    private final List<String> printedStrings = new ArrayList<>();

    @Override
    public void print(String output) {
        printedStrings.add(output);
    }

    @Override
    public void println(String output) {
        print(String.format("%s%n", output));
    }

    /**
     * @return A copy of the list containing each String that was passed to the `print` or `println` methods
     */
    public List<String> getPrintedStrings() {
        return new ArrayList<>(printedStrings);
    }

    /**
     * @return The most recent string that was "printed"
     */
    public String getLatest() {
        return this.printedStrings.get(this.printedStrings.size() - 1);
    }
}

