package com.nashss.se.nonplayercharacter.characters;

import com.nashss.se.nonplayercharacter.io.mocks.MockStringPrinter;
import com.nashss.se.nonplayercharacter.io.mocks.MockStringProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

public class GuessANumberTest {

    private GuessANumber guessANumber;

    @BeforeEach
    void setup() {
        guessANumber = new GuessANumber();
    }

    @Test
    void name_isGuessANumber() {
        assertEquals("GuessANumber", guessANumber.name());
    }

    @Test
    void introduction_returnsCorrectIntro() {
        String intro = "Let's guess a number!";
        assertEquals(intro, guessANumber.introduction());
    }

    
    @Test
    void getManager_whenManagerIsSet_returnsManager() {
        Echo echo = new Echo();

        guessANumber.setManager(echo);

        assertSame(echo, guessANumber.getManager(),
                "Expected manager to match the manager that was set.");
    }


}
