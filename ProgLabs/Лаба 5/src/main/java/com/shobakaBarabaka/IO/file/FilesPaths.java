package com.shobakaBarabaka.IO.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;


public final class FilesPaths {

    /**
     * Path to the file used for the ID sequence
     */
    public static final Path ID_FILE_PATH = Path.of("C:\\Users\\utkae\\IdeaProjects\\5labm\\src\\main\\java\\com\\shobakaBarabaka\\ID_SEQ");
    /**
     * Path to the file used for the Organization ID sequence
     */
    public static final Path ORG_ID_FILE_PATH = Path.of("C:\\Users\\utkae\\IdeaProjects\\5labm\\src\\main\\java\\com\\shobakaBarabaka\\ORG_ID_SEQ");
    /**
     * Path to the file used for storing collections
     */
    public static final Path DATA_FILE_PATH = Path.of(Optional.ofNullable(System.getenv("DATA_FILE_PATH"))
            .orElse("C:\\Users\\utkae\\IdeaProjects\\5labm\\src\\main\\java\\com\\shobakaBarabaka\\data.json"));

    static {
        checkFile(ID_FILE_PATH);
        checkFile(DATA_FILE_PATH);
    }

    private FilesPaths() {
    }

    /**
     * Ensures that the file exists and is accessible
     * @param path the path of the file to check
     */
    private static void checkFile(final Path path) {
        if (!path.toFile().exists()) {
            System.err.printf("[ERROR] File %s does not exist%n", path.toAbsolutePath());
            try {
                Files.createFile(path);
                System.out.printf("[INFO] File %s created%n", path.toAbsolutePath());
            } catch (IOException e) {
                System.err.printf("[ERROR] Failed to create file %s%n", path.toAbsolutePath());
                System.exit(1);
            }
        }

        if (!path.toFile().canRead()) System.err.printf("[WARNING] File %s is not readable%n", path.toAbsolutePath());
        if (!path.toFile().canWrite()) System.err.printf("[WARNING] File %s is not writable%n", path.toAbsolutePath());
    }
}