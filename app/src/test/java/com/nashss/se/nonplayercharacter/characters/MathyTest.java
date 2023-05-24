package com.nashss.se.nonplayercharacter.characters;

import com.nashss.se.nonplayercharacter.io.mocks.MockStringPrinter;
import com.nashss.se.nonplayercharacter.io.mocks.MockStringProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

class MathyTest {

    private Mathy mathy;

    @BeforeEach
    void setup() {
        mathy = new Mathy();
    }

    @Test
    void name_isMathy() {
        assertEquals("Mathy", mathy.name());
    }

    @Test
    void introduction_returnsCorrectIntro() {
        String intro = "We can do some math if you want to.";
        assertEquals(intro, mathy.introduction());
    }

    @Test
    void interact_whenGivenAddExpression_printsResult() {
        String expression = "2 + 2";
        String expected = "4";

        MockStringProvider input = new MockStringProvider(List.of(expression));
        MockStringPrinter output = new MockStringPrinter();

        mathy.interact(input, output);

        assertEquals(expected + "\n", output.getLatest(),
                String.format("Expected %s to be %s followed by a newline.", expression, expected));
    }
    @Test
    void interact_whenGivenADoubleExpression_printResults(){
        String expression= "3.5 * 3.65";
        String expected = "12.775";

        MockStringProvider input = new MockStringProvider(List.of(expression));
        MockStringPrinter output = new MockStringPrinter();

        mathy.interact(input, output);

        assertEquals(expected + "\n", output.getLatest(),
                String.format("Expected %s to be %s followed by a newline.", expression, expected));
    }

    @Test
    void interact_whenGivenSubtractExpression_printsResult() {
        String expression = "2 - 2";
        String expected = "0";

        MockStringProvider input = new MockStringProvider(List.of(expression));
        MockStringPrinter output = new MockStringPrinter();

        mathy.interact(input, output);

        assertEquals(expected + "\n", output.getLatest(),
                String.format("Expected %s to be %s followed by a newline.", expression, expected));
    }

    @Test
    void interact_whenGivenMultiplyExpression_printsResult() {
        String expression = "3 * 3";
        String expected = "9";

        MockStringProvider input = new MockStringProvider(List.of(expression));
        MockStringPrinter output = new MockStringPrinter();

        mathy.interact(input, output);

        assertEquals(expected + "\n", output.getLatest(),
                String.format("Expected %s to be %s followed by a newline.", expression, expected));
    }

    @Test
    void interact_whenGivenDivideExpression_printsResult() {
        String expression = "3 / 3";
        String expected = "1";

        MockStringProvider input = new MockStringProvider(List.of(expression));
        MockStringPrinter output = new MockStringPrinter();

        mathy.interact(input, output);

        assertEquals(expected + "\n", output.getLatest(),
                String.format("Expected %s to be %s followed by a newline.", expression, expected));
    }

    @Test
    void interact_whenGivenProperExpression_returnsTheSameMathy() {
        String expression = "2 + 2";
        MockStringProvider input = new MockStringProvider(List.of(expression));
        MockStringPrinter output = new MockStringPrinter();

        NonplayerCharacter result = mathy.interact(input, output);

        assertSame(mathy, result, "Expected result to be the same mathy object.");
    }

    @Test
    void interact_whenGivenInvalidExpression_returnsManagerObject() {
        String expression = "This ain't no math";
        MockStringProvider input = new MockStringProvider(List.of(expression));
        MockStringPrinter output = new MockStringPrinter();

        NonplayerCharacter Manager = new Host("Manager object");
        mathy.setManager(Manager);

        NonplayerCharacter result = mathy.interact(input, output);

        assertSame(Manager, result, "Expected result to be the same Manager object.");
    }

    @Test
    void getManager_whenManagerIsSet_returnsManager() {
        Echo echo = new Echo();

        mathy.setManager(echo);

        assertSame(echo, mathy.getManager(),
                "Expected manager to match the manager that was set.");
    }
}