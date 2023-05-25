package com.nashss.se.nonplayercharacter.characters;

import com.nashss.se.nonplayercharacter.io.mocks.MockStringPrinter;
import com.nashss.se.nonplayercharacter.io.mocks.MockStringProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class HostTest {

    private static final String HOST_NAME = "The Host";

    private Host host;

    @BeforeEach
    void setup() {
        host = new Host(HOST_NAME);
    }

    @Test
    void name_isCorrect() {
        assertEquals(HOST_NAME, host.name());
    }

    @Test
    void introduction_containsName() {
        assertTrue(host.introduction().contains(HOST_NAME));
    }

    @Test
    void addNonplayerCharacter_withValidCharacter_addsCharactersToInternalMap() {
        List<NonplayerCharacter> toAdd = List.of(new Echo(), new Mathy());

        for (NonplayerCharacter sub : toAdd) {
            host.addSubordinate(sub);
        }

        Map<String, NonplayerCharacter> hostSubs = host.getCharacters();
        assertEquals(toAdd.size(), hostSubs.size(),
                "Expected same number of subordinates as were added");

        for (NonplayerCharacter cc : toAdd) {
            assertSame(cc, hostSubs.get(cc.name()),
                    "Expected subordinate to be same as the one added");
        }
    }

    @Test
    void interact_whenEchoIsChosen_returnsEcho() {
        Echo echo = new Echo();
        host.addSubordinate(echo);

        String username = "somebody";
        MockStringProvider input = new MockStringProvider(List.of(username, echo.name()));
        MockStringPrinter output = new MockStringPrinter();

        NonplayerCharacter result = host.interact(input, output);

        assertSame(echo, result,
                "Expected to get echo character back from interact.");
    }

    @Test
    void interact_whenGivenBadName_returnsHost() {
        String username = "somebody";
        String badCharacterName = "not a character";

        MockStringProvider input = new MockStringProvider(List.of(username, badCharacterName));
        MockStringPrinter output = new MockStringPrinter();

        NonplayerCharacter result = host.interact(input, output);

        assertSame(host, result,
                "Expected to get host back from interact.");
    }

    @Test
    void interact_whenGivenExit_returnsNull() {
        String username = "somebody";
        String exit = "exit";

        MockStringProvider input = new MockStringProvider(List.of(username, exit));
        MockStringPrinter output = new MockStringPrinter();

        NonplayerCharacter result = host.interact(input, output);

        assertNull(result, "Expected to get null back from interact.");
    }

    @Test
    void getManager_whenManagerIsSet_returnsManager() {
        Echo echo = new Echo();

        host.setManager(echo);

        assertSame(echo, host.getManager(),
                "Expected manager to match the manager that was set.");
    }

@Test
void interact_whenCalled_displaysPaddedNames() {
    NonplayerCharacter character1 = new Echo();
    NonplayerCharacter character2 = new Mathy();

    host.addSubordinate(character1);
    host.addSubordinate(character2);

    MockStringProvider input = new MockStringProvider(List.of("username", "exit"));
    MockStringPrinter output = new MockStringPrinter();

    host.interact(input, output);

    String paddedName1 = String.format("%-15s", character1.name()) + " : ";
    String paddedName2 = String.format("%-15s", character2.name()) + " : ";

    boolean foundPaddedName1 = false, foundPaddedName2 = false;
    for (String printedString : output.getPrintedStrings()) {
        if (printedString.startsWith(paddedName1)) {
            foundPaddedName1 = true;
        }
        if (printedString.startsWith(paddedName2)) {
            foundPaddedName2 = true;
        }
    }
    assertTrue(foundPaddedName1, "Expected to find the padded name of character1 in the output.");
    assertTrue(foundPaddedName2, "Expected to find the padded name of character2 in the output.");
    }
}