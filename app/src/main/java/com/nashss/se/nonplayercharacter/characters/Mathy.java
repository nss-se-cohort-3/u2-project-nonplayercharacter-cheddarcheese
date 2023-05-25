package com.nashss.se.nonplayercharacter.characters;

import com.nashss.se.nonplayercharacter.io.StringPrinter;
import com.nashss.se.nonplayercharacter.io.StringProvider;

/**
 * A NonplayerCharacter that evaluates simple math expressions.
 */
public class Mathy extends NonplayerCharacter {
    private NonplayerCharacter manager;

    public Mathy() {

        super("Mathy", "We can do some math if you want to.", "I will calculate the answer for a given math expression.");
    }

    @Override
    public NonplayerCharacter interact(StringProvider input, StringPrinter output) {
        output.println("Enter an expression like: 2 + 2. (+, - , *, % and / are supported)");
        output.print("> ");
        String expression = input.get();

        try {
            String[] parts = expression.split(" ");
            String operator = parts[1];

            if (parts[0].contains(".") || parts[2].contains(".")) {
                double first = Double.parseDouble(parts[0]);
                double second = Double.parseDouble(parts[2]);
                double result;
                switch (operator) {
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
                        break;
                    case "%":
                        result = first % second;
                        break;
                    default:
                        throw new Exception("Unknown operator: " + operator);
                }

                output.println(String.valueOf(result));
            } else {
                int first= Integer.parseInt(parts[0]);
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
                        break;
                    case "%":
                        result = first % second;
                        break;
                    default:
                        throw new Exception("Unknown operator: " + operator);
                }

                output.println(String.valueOf(result));
            }

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
