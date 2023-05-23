package com.nashss.se.nonplayercharacter.characters;

import com.nashss.se.nonplayercharacter.io.StringPrinter;
import com.nashss.se.nonplayercharacter.io.StringProvider;

/**
 * A NonplayerCharacter that evaluates simple math expressions.
 */
public class Mathy implements NonplayerCharacter {
    private NonplayerCharacter manager;

    @Override
    public String name() {
        return "Mathy";
    }

    @Override
    public String introduction() {
        return "We can do some math if you want to.";
    }

    @Override
    public NonplayerCharacter interact(StringProvider input, StringPrinter output) {
        output.println("Enter an expression like: 2 + 2. (+, - , * and / are supported)");
        output.print("> ");
        String expression = input.get();

        try {
            String[] parts = expression.split(" ");
            int first = Integer.parseInt(parts[0]);
            String operator = parts[1];
            int second = Integer.parseInt(parts[2]);

            int result;
            switch(operator) {
                case "+":
                    result = first + second;
                    break;
                case "-":
                    result = first - second;
                    break;
                case "*":
                    result = first * second;
                    break;
                case "/":
                    result = first / second;
                case "%":
                    result = first % second;
                    break;
                default:
                    throw new Exception("Unknown operator: " + operator);
            }

            output.println(String.valueOf(result));

            return this;
        } catch (Exception e) {
            output.println("You did something wrong...I'm out!");
            return getManager();
        }
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
