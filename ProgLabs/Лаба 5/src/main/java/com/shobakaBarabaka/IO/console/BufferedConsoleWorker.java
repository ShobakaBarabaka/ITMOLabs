package com.shobakaBarabaka.IO.console;

import java.io.*;
import java.nio.file.Path;

/**
 * Class for reading and writing to the console
 */
public final class BufferedConsoleWorker implements AutoCloseable {

    private BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter consoleWriter = new BufferedWriter(new OutputStreamWriter(System.out));


    public BufferedConsoleWorker(String consoleReader) throws FileNotFoundException {
        this.consoleReader = new BufferedReader(new FileReader(consoleReader));
    }
    public BufferedConsoleWorker(){}
    /**
     * Reads a line of input from the console
     * @return the string entered by the user
     */
    public String read() {
        try {
            return consoleReader.readLine();
        } catch (IOException e) {
            return null;
        }
    }

    /**
     * writes the text, then reads a line from the console
     * @param text text to write
     * @return the string entered by the user
     */
    public String read(String text) {
        write(text);
        return read();
    }

    /**
     * Writes a string to the console
     * @param data the string to write
     */
    public void write(final String data) {
        try {
            consoleWriter.append(data).flush();
        } catch (IOException ignored) {
        }
    }

    /**
     * Writes a string following by newline character
     * @param data the string to write
     */
    public void writeln(String data) {
        write(data.concat(System.lineSeparator()));
    }

    /**
     * Writes formatted data to console
     * @param format the format to being applied
     * @param args arguments to which the format is applied
     */
    public void writeFormatted(String format, Object... args) {
        write(String.format(format, args));
    }



    /**
     * Closes the console reader and console writer streams.
     * @throws Exception if an error occurs
     */
    public void close() throws Exception {
        consoleReader.close();
        consoleWriter.close();
    }
}