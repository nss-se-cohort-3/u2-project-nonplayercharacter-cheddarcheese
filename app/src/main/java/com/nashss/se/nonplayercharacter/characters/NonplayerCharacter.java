package com.nashss.se.nonplayercharacter.characters;

import com.nashss.se.nonplayercharacter.io.StringPrinter;
import com.nashss.se.nonplayercharacter.io.StringProvider;

/**
 * Represents a computer-controlled "character" like you might find in a role-playing game
 */
public class NonplayerCharacter {
    String name;
    String introduction;
    String help;
    NonplayerCharacter manager;

    public NonplayerCharacter(String name, String introduction, String help) {
        this.name = name;
        this.introduction = introduction;
        this.help = help;
    }

    /**
     * @return The character's name
     */
    public String name() {
        return this.name;
    }

    /**
     * @return A brief introduction to/description of the character
     */
    public String introduction() {
        return this.introduction;
    }

    /**
     * Perform the main action of the character
     * @param input Provides user input
     * @param output Prints output to the user
     * @return The next NonplayerCharacter that the user should interact with.
     *         Often `this` same NonplayerCharacter, but it may be a `manager`
     *         or any other instance of this interface.
     */
    public NonplayerCharacter interact(StringProvider input, StringPrinter output) {
        return this.getManager();
    }

    public void setHelp(String helper) {
        this.help = helper;
    }

    public String getHelp(){
        return this.help;
    }

    /**
     * Sets the manager of this NonplyaerCharacter
     *
     * NOTE: A "manager" is a NonplayerCharacter that is responsible for "managing" this object.
     *       In most cases this will be an instance of the Host class, but this approach provides
     *       enough flexibility to allow for more complex hierarchies of manager-subordinate relationships
     *
     * @param manager The NonplayerCharacter responsible for this object
     */
    public void setManager(NonplayerCharacter manager) {
        this.manager = manager;
    }

    /**
     * Get the manager of this object
     *
     * NOTE: A "manager" is a NonplayerCharacter that is responsible for "managing" this object.
     *       In most cases this will be an instance of the Host class, but this approach provides
     *       enough flexibility to allow for more complex hierarchies of manager-subordinate relationships
     *
     * @return The manager of this object
     */
    public NonplayerCharacter getManager() {
        return this.manager;
    }
}
