package com.nashss.se.nonplayercharacter.characters;

import com.nashss.se.nonplayercharacter.io.StringPrinter;
import com.nashss.se.nonplayercharacter.io.StringProvider;

/**
 * A NonplayerCharacter that echos anything said to it
 */
public class Echo extends NonplayerCharacter {

    private NonplayerCharacter manager;

    private String help;

    public Echo(String name, String introduction, String help) {
        super(name, introduction, help);
    }

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
    public void setHelp(String helper) {
        this.help = helper;
    }

    @Override
    public String getHelp(){
        return this.help;
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
