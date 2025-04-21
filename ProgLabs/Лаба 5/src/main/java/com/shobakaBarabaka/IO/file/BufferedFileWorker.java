package com.shobakaBarabaka.IO.file;

import java.io.*;
import java.nio.file.Path;

/**
 * Provides reading and writing to the file
 */
public final class BufferedFileWorker implements AutoCloseable {

    private final BufferedReader fileReader;
    private final BufferedWriter fileWriter;

    public BufferedFileWorker(
            final Path path,
            final boolean append
    ) throws IOException {
        this.fileReader = new BufferedReader(new FileReader(path.toFile()));
        this.fileWriter = new BufferedWriter(new FileWriter(path.toFile(), append));
    }

    /**
     * Creates a new instance of the {@link BufferedFileWorker} with the given file path
     * @param path the path to the file
     * @throws IOException if an IO error occurs
     */
    public BufferedFileWorker(final Path path) throws IOException {
        this(path, true);
    }

    /**
     * Reads a line of text from the file
     * @return the next line from the file
     */
    public String read() {
        try {
            return fileReader.readLine();
        } catch (IOException e) {
            return null;
        }
    }

    /**
     * Writes a string of data to the file.
     * @param data the string of data to write
     */
    public void write(final String data) {
        try {
            fileWriter.append(data).flush();
        } catch (IOException ignored) {
        }
    }

    /**
     * Checks if there is more data to read from the file.
     * @return true if the file is ready for reading and false otherwise
     */
    public boolean ready() {
        try {
            return fileReader.ready();
        } catch (IOException e) {
            return false;
        }
    }

    /**
     * Closes the file reader and file writer streams
     * @throws Exception if an IO error occurs
     */
    public void close() throws Exception {
        fileReader.close();
        fileWriter.close();
    }
}
