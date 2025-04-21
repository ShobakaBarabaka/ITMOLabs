package com.shobakaBarabaka.IO.script;


import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Worker for reading and writing data to a script
 */
public final class DequeWorker implements AutoCloseable {

    private final Deque<String> deque = new ArrayDeque<>();
    private int recursionDepth;

    /**
     * Reads and removes the first element from the script
     * @return the first element from the script
     */
    public String read() {
        if (recursionDepth > 1) {
            close();
            recursionDepth = 0;
            return null;
        }
        return deque.pollFirst();
    }

    /**
     * @return true if the script is empty and false otherwise
     */
    public boolean ready() {
        return deque.isEmpty();
    }

    /**
     * Clears all data from the script.
     */
    public void close() {
        deque.clear();
    }
}