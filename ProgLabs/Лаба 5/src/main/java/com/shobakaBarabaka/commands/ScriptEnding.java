package com.shobakaBarabaka.commands;

import com.shobakaBarabaka.IO.transfer.Request;
import com.shobakaBarabaka.IO.transfer.Response;

/**
 * This command exits the program
 */
public final class ScriptEnding extends Command {

    /**
     * Constructs a new {@link Exit} command
     */
    ScriptEnding() {
        super("end_script", "ends script");
    }

    /**
     * @param request unused for this command
     * @return a {@link Response} indicating the program is exiting
     */
    @Override
    public Response execute(final Request request) {
        return new Response("The end of the script");
    }
}