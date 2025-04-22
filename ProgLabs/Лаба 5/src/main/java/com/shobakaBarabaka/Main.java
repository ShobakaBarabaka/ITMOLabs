package com.shobakaBarabaka;

import com.shobakaBarabaka.IO.console.BufferedConsoleWorker;
import com.shobakaBarabaka.IO.script.ScriptWorker;
import com.shobakaBarabaka.processor.Handler;
import com.shobakaBarabaka.collection.*;



public final class Main {

    private Main() {
    }

    /**
     * The main method that starts the program.
     */
    public static void main(final String... args) {
        new Main().run();
    }

    /**
     * Initializes {@link BufferedConsoleWorker} and {@link ScriptWorker} and starts the program
     */
    private void run(){
        try (BufferedConsoleWorker console = new BufferedConsoleWorker(); ScriptWorker script = new ScriptWorker()) {
            new Handler(console, script).run();
        } catch (Exception e) {
            System.err.printf("An error occurred: %s%n", e.getMessage());
        }
    }
}