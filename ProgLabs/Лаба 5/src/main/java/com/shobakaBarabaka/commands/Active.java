package com.shobakaBarabaka.commands;

import java.util.List;

/**
 * Class representing the list of commands used
 */
public final class Active {

    /**
     * A static immutable list of commands used
     */
    public static final List<Command> LIST = List.of(
            new Add(),
            new AddIfMax(),
            new Clear(),
            new ExecuteScript(),
            new Exit(),
            new Info(),
            new MaxByPrice(),
            new PrintUniquePartNumber(),
            new RemoveById(),
            new RemoveFirst(),
            new RemoveAllByPrice(),
            new RemoveHead(),
            new Save(),
            new Show(),
            new Update()
    );

    private Active() {
    }
}