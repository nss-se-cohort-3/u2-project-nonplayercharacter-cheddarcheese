package com.nashss.se.nonplayercharacter.characters;

import com.google.common.annotations.VisibleForTesting;
import com.nashss.se.nonplayercharacter.io.StringPrinter;
import com.nashss.se.nonplayercharacter.io.StringProvider;

import java.util.*;

/**
 * The NonplayerCharacter that orchestrates all the action in the application
 * The Host manages the user's interact with other NonplayerCharacters
 *
 * A Host instance acts as the "parent" to other "child" NonplayerCharacters
 */
public class Host extends NonplayerCharacter {
    private boolean hasBeenIntroduced = false;
    private String username;
    private NonplayerCharacter manager;
    private final Map<String, NonplayerCharacter> characters;



    /**
     * Create a Host with a given name
     * @param name The Host's name
     */
    public Host(String name) {
        super(name, String.format(
                "Hello and welcome! I'm your host, %s, and I'm glad your here!",
                name), "I am the host and I guide you through the game!");
        this.name = name;
        this.characters = new HashMap<>();
    }

    /**
     * Add a new NonplayerCharacter for the host to "manage"
     * The Host will become the "parent" of the "child" character
     * @param subordinate A character that this Host should manage
     */
    public void addSubordinate(NonplayerCharacter subordinate) {
        subordinate.setManager(this);
        characters.put(subordinate.name(), subordinate);
    }

    @Override
    public NonplayerCharacter interact(StringProvider input, StringPrinter output) {
        if (!this.hasBeenIntroduced) {
            output.println(introduction());
            output.print("What is your name? ");
            this.username = input.get();

            output.println("Great to meet you. Let's get started!\n" +
                    "Keep in mind that you can type `exit` any time you're talking to me if you want to leave.\n");

            this.hasBeenIntroduced = true;
        } else {
            output.println("---------------------------------");
            output.print(String.format("%s here... ", this.name));
        }

        output.println(String.format("Ok, %s, who would you like to talk to?%n", this.username));
        displayCharacterIntroductions(output);
        output.print("> ");
        String selected = input.get();

        if (selected.equalsIgnoreCase("exit")) {
            return null;
        }

        if (!this.characters.containsKey(selected)) {
            output.println(String.format("Sorry, %s, I don't recognize the name '%s'", this.username, selected));
            return this;
        }

        return this.characters.get(selected);
    }

    @Override
    public void setManager(NonplayerCharacter manager) {
        this.manager = manager;
    }

    @Override
    public NonplayerCharacter getManager() {
        return this.manager;
    }

    private void displayCharacterIntroductions(StringPrinter output) {
        for (String name : characterNames()) {
            NonplayerCharacter character = characters.get(name);
            String paddedName = String.format("%-15s",name);
            output.println(String.format("%s : %s", paddedName, character.introduction()));
        }
    }

    private List<String> characterNames() {
        List<String> names = new ArrayList<>(characters.keySet());
        Collections.sort(names);
        return names;
    }

    @VisibleForTesting
    public Map<String, NonplayerCharacter> getCharacters() {
        return new HashMap<>(characters);
    }
}

