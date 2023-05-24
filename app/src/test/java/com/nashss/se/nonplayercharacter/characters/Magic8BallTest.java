package com.nashss.se.nonplayercharacter.characters;

import com.nashss.se.nonplayercharacter.io.mocks.MockStringPrinter;
import com.nashss.se.nonplayercharacter.io.mocks.MockStringProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Magic8BallTest {
    private Magic8Ball magic8Ball;



    @BeforeEach
    void setup() { magic8Ball = new Magic8Ball(); }

    @Test
    void name_isMagic8Ball() { assertEquals("Magic8Ball", magic8Ball.name());}

    @Test
    void introduction_returnsCorrectIntro() {
        String intro = "Ask me about the future!";
        assertEquals(intro, magic8Ball.introduction());
    }

    @Test
    void interact_whenGivenAQuestion_returnsARandomAnswers(){
        //Given
        String inputMessage = "Will I become rich?";

        MockStringProvider input = new MockStringProvider(List.of(inputMessage));
        MockStringPrinter output = new MockStringPrinter();


        //When
        magic8Ball.interact(input, output);


        //Then
        Assertions.assertNotNull(output.getLatest());
    }
    @Test
    void interact_whenGivenTwoQuestions_returnsDifferentRandomAnswers(){
        //Given a list of questions
        List<String> inputMessages = List.of("Will I become rich?", "Will I have kids?");

        MockStringProvider input = new MockStringProvider(inputMessages);
        MockStringPrinter output = new MockStringPrinter();


        //When interact is called on the list of questions
        for (String _msg : inputMessages) {
            magic8Ball.interact(input, output);
        }
        List<String> responses = output.getPrintedStrings();

        //Then the answers are different
        assertNotEquals(responses.get(0), responses.get(1));
    }
}