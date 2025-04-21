package com.shobakaBarabaka.commands;

import com.shobakaBarabaka.IO.file.BufferedFileWorker;
import com.shobakaBarabaka.IO.transfer.Request;
import com.shobakaBarabaka.IO.transfer.Response;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;

/**
 * This command execute script from the file
 */
public final class ExecuteScript extends Command {

    /**
     * Constructs a new ExecuteScript command.
     */
    ExecuteScript() {
        super("execute_script", new String[]{"file name"}, "executes script from file");
    }

    /**
     * @param request the {@link Request} containing the file name
     * @return a {@link Response} containing the script or an error message
     */
    @Override
    public Response execute(final Request request) {
        if (request.args() == null || request.args().isEmpty()) {
            return new Response("No file name provided.");
        }

        final Path path = Paths.get(request.args().getFirst());
        if (!path.toFile().exists()) return new Response("File not found.");
        if (!path.toFile().canRead()) return new Response("Not enough rights to read file.");

        try (BufferedFileWorker file = new BufferedFileWorker(path)) {
            StringBuilder script = new StringBuilder();
            while (file.ready()) {
                script.append(file.read()).append(System.lineSeparator());
            }
            return new Response(
                    "Script loaded from file %s".formatted(path.toString()),
                    Collections.emptyList(),
                    script.toString()
            );
        } catch (Exception e) {
            return new Response("Error occurred: %s".formatted(e.getMessage()));
        }
    }
}