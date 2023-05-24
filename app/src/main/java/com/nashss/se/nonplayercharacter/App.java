package com.nashss.se.nonplayercharacter;

import com.nashss.se.nonplayercharacter.characters.*;
import com.nashss.se.nonplayercharacter.io.ConsoleStringPrinter;
import com.nashss.se.nonplayercharacter.io.ConsoleStringProvider;
import com.nashss.se.nonplayercharacter.io.StringPrinter;
import com.nashss.se.nonplayercharacter.io.StringProvider;

import java.util.List;

/**
 * The entry point for the application
 */
public class App {
    private final StringPrinter output;
    private final StringProvider input;
    private final Host host;

    /**
     * Create a new App
     * @param input Provides String input from the user
     * @param output Prints String output for the user to see
     * @param host Orchestrates the user interaction with various non-player characters
     * @param subordinates A list of NonplayerCharacters that the host will use to engage with the user
     */
    public App(StringProvider input, StringPrinter output,
               Host host, List<NonplayerCharacter> subordinates ) {
        this.input = input;
        this.output = output;
        this.host = host;

        for (NonplayerCharacter subordinate : subordinates) {
            host.addSubordinate(subordinate);
        }
    }

    /**
     * Initiates and manages the main "game loop"
     */
    public void run() {
        NonplayerCharacter character = this.host;
        while (character != null) {
            character = character.interact(input, output);
            output.println("");
        }
        output.println("Exiting...");
    }

    public static void main(String[] args) {
        StringProvider input = new ConsoleStringProvider();
        StringPrinter output = new ConsoleStringPrinter();
        Host host = new Host("Phil");
        List<NonplayerCharacter> subordinates = List.of(
                new Echo(),
                new Mathy(),
                new AngryOldMan("Herbert"),
                new Magic8Ball());

        App app = new App(input, output, host, subordinates);
        app.run();
    }
}
