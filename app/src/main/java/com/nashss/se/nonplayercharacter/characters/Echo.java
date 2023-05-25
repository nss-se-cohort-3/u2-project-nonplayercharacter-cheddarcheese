package com.nashss.se.nonplayercharacter.characters;

import com.nashss.se.nonplayercharacter.io.StringPrinter;
import com.nashss.se.nonplayercharacter.io.StringProvider;

/**
 * A NonplayerCharacter that echos anything said to it
 */
public class Echo extends NonplayerCharacter {

    private NonplayerCharacter manager;

    public Echo() {
        super("Echo-Echo", "As long as you have something to say, so do I.","I will repeat whatever you type.");
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
