package com.nashss.se.nonplayercharacter.characters;

import com.nashss.se.nonplayercharacter.io.mocks.MockStringPrinter;
import com.nashss.se.nonplayercharacter.io.mocks.MockStringProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NonplayerCharacterTest {
    private NonplayerCharacter nonplayerCharacter;

    @BeforeEach
    void setup() {
        nonplayerCharacter = new NonplayerCharacter("npc", "intro", "help");
    }
    @Test
    void name() {
        assertEquals("npc", nonplayerCharacter.name());
    }

    @Test
    void introduction() {
        assertEquals("intro", nonplayerCharacter.introduction());
    }

    @Test
    void help() {
        assertEquals("help", nonplayerCharacter.help());
    }

    @Test
    void getManager_whenManagerIsSet_returnsManager() {
        NonplayerCharacter npc = new NonplayerCharacter("npc2", "intro2", "help2");
        nonplayerCharacter.setManager(npc);

        assertSame(npc, nonplayerCharacter.getManager(), "Expected manager to match the manager that was set.");
    }

    @Test
    void getManager_withNewSubclassNonPlayerCharacter_overridesReturnManager() {
        NonplayerCharacter echo = new Echo();
        NonplayerCharacter mathy = new Mathy();

        echo.setManager(mathy);

        assertSame(mathy, echo.getManager(),
                "Expected manager to match the manager that was set.");
    }

    @Test
    void interact_withANewSubClassNonPlayerCharacter_overridesInteractMethod() {
        NonplayerCharacter echo = new Echo();
        List<String> inputStrings = List.of("first", "second", "third");
        MockStringProvider input = new MockStringProvider(inputStrings);
        MockStringPrinter output = new MockStringPrinter();

        for (int i = 0; i < inputStrings.size(); i++) {
            echo.interact(input, output);
        }

        List<String> outputStrings = output.getPrintedStrings();
        assertEquals(inputStrings.size(), outputStrings.size(),
                "Expected echo to print all strings.");
        for (int i = 0; i < inputStrings.size(); i++) {
            String expected = inputStrings.get(i) + "\n";
            String actual = outputStrings.get(i);

            assertEquals(expected, actual, "Expected output string to match imput string.");
        }

    }
}