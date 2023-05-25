package com.nashss.se.nonplayercharacter.characters;

import com.nashss.se.nonplayercharacter.io.StringPrinter;
import com.nashss.se.nonplayercharacter.io.StringProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Magic8Ball extends NonplayerCharacter {

    private NonplayerCharacter manager;

    public Magic8Ball() {
        super("Magic8Ball", "Ask me about the future!", "I will predict the future and give great answers for any question you ask.");
    }

    @Override
    public NonplayerCharacter interact(StringProvider input, StringPrinter output) {

        List<String> responses = new ArrayList<>();
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
            responses.add("very doubtful");

        output.println("Ask me a question about the future!");
        String userText = input.get();


            Random rand = new Random();
            output.println(responses.get(rand.nextInt(responses.size())));
            return getManager();
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
