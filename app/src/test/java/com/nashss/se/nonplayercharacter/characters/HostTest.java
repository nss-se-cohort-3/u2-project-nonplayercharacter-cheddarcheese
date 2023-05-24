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
    void displayCharacterIntroductions_whenCalled_returnsFixedPaddedNames(){
        String name = "John";
        String paddedName = String.format("%-9s", name);

            MockStringProvider input = new MockStringProvider(List.of(name));
            MockStringPrinter output = new MockStringPrinter();

            NonplayerCharacter result = host.interact(input, output);

        assertEquals("John     ",paddedName,"Expected names to have a fixed width" );
        }
    }