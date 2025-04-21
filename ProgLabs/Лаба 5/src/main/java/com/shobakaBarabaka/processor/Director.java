package com.shobakaBarabaka.processor;

import com.shobakaBarabaka.IO.transfer.Request;
import com.shobakaBarabaka.IO.transfer.Response;
import com.shobakaBarabaka.commands.Active;
import com.shobakaBarabaka.commands.Command;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Sends requests to the right command for execution.
 */
public final class Director {

    /**
     * Instance of the {@link Director} class
     */
    private static Director instance;

    private Director() {
    }

    /**
     * @return the instance of {@link Director} class
     */
    public static Director getInstance() {
        return instance == null ? instance = new Director() : instance;
    }

    /**
     * Sends the specified {@link Request} to the appropriate Command
     * @param request the {@link Request} to send
     * @return the {@link Response} from the executed command
     */
    public Response route(Request request) {
        if (request == null || request.command() == null || request.command().isBlank()) return Response.empty();
        if (request.command().equals("help")) return getHelp();

        return Active.LIST.stream()
                .filter(temp -> temp.getName().equalsIgnoreCase(request.command()))
                .findFirst()
                .map(temp -> temp.execute(request))
                .orElse(new Response("command '%s' not found, type 'help' for help".formatted(request.command())));
    }

    /**
     * @param command the name of the command
     * @return the number of elements required for the command
     */
    public int getElementsRequiredFor(String command) {
        return Active.LIST.stream()
                .filter(temp -> temp.getName().equalsIgnoreCase(command)).findFirst()
                .map(Command::getElementsRequired).orElse(0);
    }

    /**
     * Gives help information for all commands
     * @return a {@link Response} containing help information
     */
    private Response getHelp() {
        return new Response("Available commands:%s".formatted(
                Active.LIST.stream()
                        .map(command -> "%n ~ %s %s - %s".formatted(
                                command.getName(),
                                Arrays.toString(command.getArgs()),
                                command.getHelp()
                        ))
                        .collect(Collectors.joining()))
        );
    }
}