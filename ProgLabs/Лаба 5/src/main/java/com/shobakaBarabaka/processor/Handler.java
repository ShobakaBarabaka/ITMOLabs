package com.shobakaBarabaka.processor;

import com.shobakaBarabaka.IO.console.BufferedConsoleWorker;
import com.shobakaBarabaka.IO.script.DequeWorker;
import com.shobakaBarabaka.IO.transfer.Request;
import com.shobakaBarabaka.IO.transfer.Response;
import com.shobakaBarabaka.collection.CollectionManager;
import com.shobakaBarabaka.collection.Product;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static com.shobakaBarabaka.utility.InputUtil.get;



/**
 * Handles input and sends commands to the appropriate handlers.
 */
public final class Handler implements Runnable {
    private final BufferedConsoleWorker console;
    private final DequeWorker script;

    /**
     * Creates a new {@link Handler} instance
     * @param console the console worker
     * @param script  the script worker
     */
    public Handler(
            final BufferedConsoleWorker console,
            final DequeWorker script
    ) {
        this.console = console;
        this.script = script;
    }

    /**
     * Loads collection and processes input data from script or console
     */
    @Override
    public void run() {
        console.writeln("welcome to lab5!");
        CollectionManager.getInstance().load();

        try {
            String line;
            while ((line = console.read(" > ")) != null) {
                handle(line);
                while (!script.ready()) handle(script.read());
            }
        } catch (Exception e) {
            console.writeFormatted("error: %s%n", e.getMessage());
        }
    }

    /**
     * Processes a single input line
     * @param line the input line
     */
    private void handle(final String line) {
        if (line == null) return;
        print(Director.getInstance().route(parse(line)));
    }

    /**
     * Prints a {@link Response} to the console
     * @param response the {@link Response} to print
     */
    private void print(final Response response) {
        if (response.message() != null && !response.message().isBlank()) console.writeln(response.message());
        if (response.products() != null && !response.products().isEmpty())
            response.products().stream().map(Product::toString).forEach(console::writeln);
    }

    /**
     * Parses an input line into a {@link Request}
     * @param line the input line
     * @return a {@link Request} object containing parsed line
     */
    private Request parse(final String line) {
        final String[] parts = line.split(" ", 2);
        final String command = parts[0];
        final List<String> arguments = parts.length > 1 ? Arrays.asList(parts[1].split(" ")) : Collections.emptyList();
        final List<Product> products = new LinkedList<>();
        int elementsRequired = Director.getInstance().getElementsRequiredFor(command);
        while (elementsRequired-- > 0) {
            try {
                products.add(get(console));
            } catch (InterruptedException ex) {
                console.writeln("command interrupted: %s".formatted(ex.getMessage()));
                return null;
            }
        }
        return new Request(command, arguments, products);
    }
}