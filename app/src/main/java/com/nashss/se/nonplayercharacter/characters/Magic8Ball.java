package com.nashss.se.nonplayercharacter.characters;

import java.util.ArrayList;
import java.util.List;

public class Magic8Ball implements NonplayerCharacter {

    private List<String> responses = new ArrayList<>();
        responses.add("It is certain");
        responses.add("It is decidedly so");
        responses.add("Without a doubt");
        responses.add("Yes definitely");
        responses.add("You may rely on it");
        responses.add("As I see it, yes");
        responses.add("Most likely");
        responses.add("Outlook good");
        responses.add("Yes");
        responses.add("Ask again later");
        responses.add("Better not tell you now");
        responses.add("Cannot predict now");
        responses.add("Concentrate and ask again");
        responses.add("Don’t count on it");
        responses.add("My reply is no");
        responses.add("My sources say no");
        responses.add("Outlook not so good");
        responses.add("ery doubtful");

    private final String name;
    private final NonplayerCharacter manager;

    public Magic8Ball(String name) {
        this.name = name;
    }

    @Override
    public String name() {
        return this.name;
    }

    @Override
    public String introduction() {
        return "Ask me a question to ";
    }
}
