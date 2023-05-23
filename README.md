# Non-Player Character

A [non-player character](https://en.wikipedia.org/wiki/Non-player_character) (aka "NPC") is a character in a game that is not controlled by a player. In a video game this is a character controlled by code written by the programmers who created the game.

In this project, you'll create a few non-player characters that are capable of having a (limited) interaction with the user.

You'll also make a few enhancements to existing code.

## Development Process

### Scrum

Your team will manage your work using the Scrum methodology. We've covered scrum before but here are some highlights...

* You will have a **Planning Meeting** _before_ you start coding. In this meeting you will decide how many **User Stories** your team can commit to completing.
* Each day of the **Sprint** your team will have a **Daily Standup** meeting.
* At the end of the **Sprint** your team will have **Retrospective** and **Sprint Review** meetings.
* You will pull your work from the **Product Backlog**. This is a list of **User Stories** that is in a priority order.

### Unit Testing

Your work on a user story is **NOT** done until you've written _passing_ **Unit Tests** that ensure the code is correct.

**ALL** of the **Unit Tests** _must_ be passing before you create a **Pull Request**.

### Pull Requests

You should **NEVER** commit code directly into the `main` branch. **ALL** code _must_ be merged into the `main` branch via a **Pull Request**.

Each **Pull Request** _must_ be **approved** by at least one other teammate before it is **merged**. 

The reviewer should ensure that

* the tests pass
* the tests correctly validate the production code
* the code is commented
* the code is well formatted
* the code is easy to understand
* the code works

## Running the Application

You can use the `run` script found in the root of the gradle project (the same directory as `gradlew`) to run the program.

```shell
./run
```

You can also run the application with `./gradlew`, but you probably won't want to because it will print out a bunch of gradle-specific information along side the text printed by the program. But if you want to see that...

```shell
./gradlew run
```

## Running Unit Tests

You can use IntelliJ to execute tests or you can run the tests with `./gradlew`.

```shell
./gradlew test
```

If you don't change any code, but want to re-run the tests you may need to do this:

```shell
./gradlew test --rerun-tasks
```




