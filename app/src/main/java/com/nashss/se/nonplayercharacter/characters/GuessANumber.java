package com.nashss.se.nonplayercharacter.characters;


import com.nashss.se.nonplayercharacter.io.StringPrinter;
import com.nashss.se.nonplayercharacter.io.StringProvider;

import java.util.Random;

public class GuessANumber implements NonplayerCharacter {


    private NonplayerCharacter manager;

    @Override
    public String name() {
        return "GuessANumber";
    }

    @Override
    public String introduction() {
        return "Let's guess a number!";
    }

    @Override
    public NonplayerCharacter interact(StringProvider input, StringPrinter output) {
        output.println("Enter a number between 1-100. You have 5 guesses!");
        int maxAttempts = 5;
        String userText = input.get();
        int guess = Integer.parseInt(userText);

        Random rand = new Random();
        int answer = rand.nextInt(100) + 1; //CORRECT ANSWER
        //output.println("yo! The answer is " + answer);
        int attemptsNum = 1;


            while (attemptsNum < maxAttempts) {

                if (guess == answer) {
                    output.println("Correct! The answer was " + answer);
                    break;

                } else if (guess < answer) {
                    output.println("Your guess was too LOW.");
                    //attemptsNum++;
                    output.println("Enter another number between 1-100.");
                    //userText = input.get();
                    //guess = Integer.parseInt(userText);

                } else {
                    output.println("Your guess was too HIGH.");
                    //attemptsNum++;
                    output.println("Enter another number between 1-100.");
                    //userText = input.get();
                    //guess = Integer.parseInt(userText);

                }
                userText = input.get();
                guess = Integer.parseInt(userText);
                attemptsNum++;
            }


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