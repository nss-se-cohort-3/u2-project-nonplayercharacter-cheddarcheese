package com.nashss.se.nonplayercharacter.characters;

import com.nashss.se.nonplayercharacter.io.StringPrinter;
import com.nashss.se.nonplayercharacter.io.StringProvider;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * A character who is angry about...everything
 */
public class AngryOldMan extends NonplayerCharacter {

    // You can find documentation about `Map.of` here: https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Map.html#of(K,V)
    // You can find documentation about `List.of` here: https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/List.html#of(E)
    private final Map<String, List<String>> responsesByPunctuation = Map.of(
            ".", List.of(
                    "That's how they get you!",
                    "When I was a boy people knew how to speak to their elders!",
                    "You can't trust 'em further than you can throw 'em...",
                    "I blame the government!",
                    "I blame the communists!",
                    "I blame the young people these days!",
                    "I remember when people cared about quality...",
                    "I don't need to take those pills...poison is what it is...trying to kill me..."),
            "?", List.of("Yes", "No", "Maybe", "Don't sass me!"),
            "!", List.of("Don't be so sensitive.", "What? Cut me a switch!", "No back-talk in this house!"));

    private NonplayerCharacter manager;

    /**
     * CReate an AngryOldMan with a given name
     * @param name The angry old man's name
     */
    public AngryOldMan(String name) {
        super(name, "Get off my lawn!", "I will give you wisdom of an old man");

    }

    @Override
    public NonplayerCharacter interact(StringProvider input, StringPrinter output) {
        output.print("Wha'd'ya say? Speak up! ");
        String text = input.get();

        String punctuation = text.length() > 0
                ? text.substring(text.length() - 1)
                : "";

        Set<String> punctuationOptions = responsesByPunctuation.keySet();
        if (!punctuationOptions.contains(punctuation)) {
            output.println("Folks used to know how to end a sentence!");
            return getManager();
        }

        List<String> responses = responsesByPunctuation.get(punctuation);
        int randomIndex = new Random().nextInt(responses.size());
        output.println(responses.get(randomIndex));

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
