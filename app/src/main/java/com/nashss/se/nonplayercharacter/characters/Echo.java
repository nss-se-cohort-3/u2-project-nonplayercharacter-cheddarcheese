package com.nashss.se.nonplayercharacter.characters;

import com.nashss.se.nonplayercharacter.io.StringPrinter;
import com.nashss.se.nonplayercharacter.io.StringProvider;

/**
 * A NonplayerCharacter that echos anything said to it
 */
public class Echo implements NonplayerCharacter {

    private NonplayerCharacter manager;

    @Override
    public String name() {
        return "Echo-Echo";
    }

    @Override
    public String introduction() {
        return "As long as you have something to say, so do I.";
    }

    @Override
    public NonplayerCharacter interact(StringProvider input, StringPrinter output) {
        String userText = input.get();

        if (userText.equals("")) {
            return getManager();
        }

        output.println(userText);
        return this;
    }

    @Override
    public void setManager(NonplayerCharacter manager) {
        this.manager = manager;
    }

    @Override
    public NonplayerCharacter getManager() {
        return this.manager;
    }
}
