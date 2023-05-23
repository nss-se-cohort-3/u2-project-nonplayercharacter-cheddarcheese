package com.nashss.se.nonplayercharacter.characters;

import com.nashss.se.nonplayercharacter.io.mocks.MockStringPrinter;
import com.nashss.se.nonplayercharacter.io.mocks.MockStringProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AngryOldManTest {

    private AngryOldMan angryOldMan;
    private static final String NAME = "Marv";

    @BeforeEach
    void setup() {
        angryOldMan = new AngryOldMan(NAME);
    }

    @Test
    void name_returnsTheName() {
        assertEquals(NAME, angryOldMan.name());
    }

    @Test
    void introduction_returnsCorrectIntro() {
        String intro = "Get off my lawn!";
        assertEquals(intro, angryOldMan.introduction());
    }

    @Test
    void interact_withEndingPunctuation_printsResponse() {
        List<String> inputMessages = List.of("?", ".", "!");
        MockStringProvider input = new MockStringProvider(inputMessages);
        MockStringPrinter output = new MockStringPrinter();

        for (String _msg : inputMessages) {
            angryOldMan.interact(input, output);
        }

        // Each time we call `interact` the old man prints two things:
        //  1. A prompt: "Wha'd'ya say? Speak up! "
        //  2. The actual response
        List<String> responses = output.getPrintedStrings();

        assertEquals(inputMessages.size() * 2, responses.size(),
                "Expected to get twice the number of responses as size of input.");
    }

    @Test
    void interact_withoutEndingPunctuation_returnsManager() {
        MockStringProvider input = new MockStringProvider(List.of("no period at the end"));
        MockStringPrinter output = new MockStringPrinter();

        NonplayerCharacter Manager = new Host("Manager object");
        angryOldMan.setManager(Manager);

        NonplayerCharacter result = angryOldMan.interact(input, output);

        assertSame(Manager, result);
    }

    @Test
    void getManager_whenManagerIsSet_returnsManager() {
        Echo echo = new Echo();

        angryOldMan.setManager(echo);

        assertSame(echo, angryOldMan.getManager(),
                "Expected manager to match the manager that was set.");
    }
}