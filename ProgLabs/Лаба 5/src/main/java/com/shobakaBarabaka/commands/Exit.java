package com.shobakaBarabaka.commands;

import com.shobakaBarabaka.IO.transfer.Request;
import com.shobakaBarabaka.IO.transfer.Response;

/**
 * This command exits the program
 */
public final class Exit extends Command {

    /**
     * Constructs a new {@link Exit} command
     */
    Exit() {
        super("exit", "exits the program");
    }

    /**
     * @param request unused for this command
     * @return a {@link Response} indicating the program is exiting
     */
    @Override
    public Response execute(final Request request) {
        System.exit(0);
        return new Response("Exiting...");
    }
}