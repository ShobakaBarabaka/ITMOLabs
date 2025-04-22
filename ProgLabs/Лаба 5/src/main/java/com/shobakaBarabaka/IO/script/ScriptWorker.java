package com.shobakaBarabaka.IO.script;


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

/**
 * Worker for reading and writing data to a script
 */
public final class ScriptWorker implements AutoCloseable {

    private final ArrayDeque<String> deque = new ArrayDeque<>();
    private int recursionDepth;


    /**
     * Reads and removes the first element from the script
     * @return the first element from the script
     */
    public String read() {
        if (recursionDepth > 9) {
            close();
            recursionDepth = 0;
            return null;
        }
        recursionDepth = 0;
        return deque.pollFirst();
    }


    public void insert(final String data) {
        if (data == null) return;
        final ArrayDeque<String> tempDeque = deque.clone();
        deque.clear();
        deque.addAll(Arrays.asList(data.split(System.lineSeparator())));
        deque.addAll(tempDeque);
        recursionDepth++;
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