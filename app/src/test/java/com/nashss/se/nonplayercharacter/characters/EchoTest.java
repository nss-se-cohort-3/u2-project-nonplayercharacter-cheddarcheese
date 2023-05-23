package com.nashss.se.nonplayercharacter.characters;

import com.nashss.se.nonplayercharacter.io.mocks.MockStringPrinter;
import com.nashss.se.nonplayercharacter.io.mocks.MockStringProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EchoTest {

    private Echo echo;

    @BeforeEach
    void setup() {
        echo = new Echo();
    }

    @Test
    void name_isEchoEcho() {
        assertEquals("Echo-Echo", echo.name());
    }

    @Test
    void introduction_returnsCorrectIntro() {
        String intro = "As long as you have something to say, so do I.";
        assertEquals(intro, echo.introduction());
    }

    @Test
    void interact_whenGivenStrings_printThoseStrings() {
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

    @Test
    void interact_whenGivenEmptyString_returnsManager() {
        String emptyInput = "";
        MockStringProvider input = new MockStringProvider(List.of(emptyInput));
        MockStringPrinter output = new MockStringPrinter();

        NonplayerCharacter Manager = new Host("Manager object");
        echo.setManager(Manager);

        NonplayerCharacter result = echo.interact(input, output);

        assertSame(Manager, result, "Expected result to be the same Manager object.");
    }

    @Test
    void getManager_whenManagerIsSet_returnsManager() {
        Mathy mathy = new Mathy();

        echo.setManager(mathy);

        assertSame(mathy, echo.getManager(),
                "Expected manager to match the manager that was set.");
    }
}