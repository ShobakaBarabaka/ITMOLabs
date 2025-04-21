package com.shobakaBarabaka.IO.parser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.shobakaBarabaka.IO.file.BufferedFileWorker;
import com.shobakaBarabaka.collection.Product;

import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


/**
 * Transfers collections of {@link Product} to JSON file and vice versa.
 */
public class JsonFormatter implements AutoCloseable{

    private static final Gson gson = new GsonBuilder()
            .registerTypeAdapter(LinkedList.class, new Deserializer())
            .registerTypeAdapter(LocalDate.class, new DateTypeAdapter())
            .create();

    private final Path filePath;

    /**
     * Constructs a {@link JsonFormatter} for the given filepath.
     * @param filePath the path to the JSON file
     */
    public JsonFormatter(final Path filePath) {
        this.filePath = filePath;
    }

    /**
     * Reads a collection of {@link Product} objects from the JSON file.
     * @return a list of {@link Product} objects
     */

    public List<Product> read() {
        if (Files.notExists(filePath)) {
            System.err.printf("File %s not found%n", filePath.getFileName());
            return Collections.emptyList();
        }

        if (!Files.isReadable(filePath)) {
            System.err.printf("File %s is not readable%n", filePath.getFileName());
            return Collections.emptyList();
        }

        try (BufferedFileWorker fileWorker = new BufferedFileWorker(filePath)) {
            Root root = gson.fromJson(fileWorker.read(), Root.class);

            if (root == null || root.collection() == null) {
                System.out.println("It seems the input file is empty. An empty collection will be initialized.");
                return Collections.emptyList();
            }

            System.out.println("Collection successfully initialized! Size: " + root.collection().size());
            return root.collection();
        } catch (Exception e) {
            System.err.printf("Error processing file %s%n%s%n", filePath.getFileName(), e.getMessage());
            return Collections.emptyList();
        }
    }

    /**
     * Writes a collection of {@link Product} objects to the JSON file.
     * @param values collection of {@link Product} objects
     */
    public void write(final List<Product> values) {
        if (Files.notExists(filePath)) {
            System.err.printf("File %s not found%n", filePath.getFileName());
            return;
        }

        if (!Files.isWritable(filePath)) {
            System.err.printf("Cannot write to %s%n", filePath.getFileName());
            return;
        }

        try (BufferedFileWorker fileWorker = new BufferedFileWorker(filePath, false)) {
            fileWorker.write(gson.toJson(new Root(values)));
        } catch (Exception e) {
            System.err.printf("Failed when trying to write to %s: %s%n", filePath.getFileName(), e.getMessage());
        }
    }





    /**
     * Checks if the file exists and ready.
     * @return {@code true} if the file is ready, {@code false} otherwise
     */
    public boolean ready() {
        return !Files.isDirectory(filePath)
                && Files.exists(filePath)
                && Files.isReadable(filePath)
                && Files.isWritable(filePath);
    }

    @Override
    public void close() throws Exception {

    }
}