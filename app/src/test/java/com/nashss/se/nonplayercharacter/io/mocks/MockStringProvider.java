package com.nashss.se.nonplayercharacter.io.mocks;

import com.nashss.se.nonplayercharacter.characters.NonplayerCharacter;
import com.nashss.se.nonplayercharacter.io.StringProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * A "fake" StringProvider that contains a list of Strings to be provided
 * This class is used in unit tests.
 */
public class MockStringProvider implements StringProvider {

    private final List<String> providedStrings;
    private int currentStringIndex;

    /**
     * Create a new MockStringProvider
     * @param providedStrings The list of strings that should be return when the `get()` method is called
     *                        If the `get()` method is called more times than there are elements in the list
     *                        it "wraps around" back to index 0 again and repeats.
     * @throws IllegalArgumentException if providedStrings is null or empty
     */
    public MockStringProvider(List<String> providedStrings) {
        if (providedStrings == null || providedStrings.isEmpty()) {
            throw new IllegalArgumentException("providedStrings must contain at least one String");
        }

        this.providedStrings = new ArrayList<>(providedStrings);
        this.currentStringIndex = -1;
    }

    @Override
    public String get() {
        this.currentStringIndex++;
        if (this.currentStringIndex == this.providedStrings.size()) {
            this.currentStringIndex = 0;
        }
        return this.providedStrings.get(this.currentStringIndex);
    }
}
