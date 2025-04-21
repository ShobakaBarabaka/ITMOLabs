package com.shobakaBarabaka.commands;

import com.shobakaBarabaka.IO.transfer.Request;
import com.shobakaBarabaka.IO.transfer.Response;

/**
 * Abstract base class for all commands
 */
public abstract class Command {
    public static final String[] EMPTY_ARGS = new String[0];

    private final String name;
    private final String[] args;
    private final String help;
    private final int elementsRequired;

    /**
     * Constructs a command with all specified parameters
     * @param name             the name of the command
     * @param args             the arguments accepted by the command
     * @param help             the help message describing the command
     * @param elementsRequired the number of elements required for execution
     */
    protected Command(
            final String name,
            final String[] args,
            final String help,
            final int elementsRequired
    ) {
        this.name = name;
        this.args = args;
        this.help = help;
        this.elementsRequired = elementsRequired;
    }

    /**
     * Constructs a command with specified name, arguments, and help message.
     * @param name the name of the command
     * @param args the arguments accepted by the command
     * @param help the help message describing the command
     */
    public Command(
            final String name,
            final String[] args,
            final String help
    ) {
        this(name, args, help, 0);
    }

    /**
     * Constructs a command with a name and help message.
     * @param name the name of the command
     * @param help the help message describing the command
     */
    public Command(
            final String name,
            final String help
    ) {
        this(name, EMPTY_ARGS, help);
    }

    /**
     * Executes the command with the specified {@link Request}
     * @param request the request containing input data for the command
     * @return a {@link Response} containing the result of the execution
     */
    public abstract Response execute(Request request);

    /**
     * @return the name of the command
     */
    public String getName() {
        return name;
    }

    /**
     * @return the help message of the command
     */
    public String getHelp() {
        return help;
    }

    /**
     * @return the number of elements required
     */
    public int getElementsRequired() {
        return elementsRequired;
    }

    /**
     * @return an array of argument names
     */
    public String[] getArgs() {
        return args;
    }
}