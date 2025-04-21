package com.shobakaBarabaka.collection;

import com.shobakaBarabaka.IO.file.BufferedFileWorker;
import com.shobakaBarabaka.IO.file.FilesPaths;

import java.io.IOException;


/**
 * class for generating unique IDs
 */
public class IdGenerator {
    private static IdGenerator instance = null;

    private final BufferedFileWorker fileWorker;
    private final BufferedFileWorker orgFileWorker;
    private Integer currentId;
    private Long currentOrgId;


    /**
     * Private constructor for initializing the {@link IdGenerator}
     * @throws IOException if an error occurs during file operations
     */
    private IdGenerator() throws IOException {
        this.fileWorker = new BufferedFileWorker(FilesPaths.ID_FILE_PATH, true);
        initialize();
        this.orgFileWorker = new BufferedFileWorker(FilesPaths.ORG_ID_FILE_PATH, true);
        orgInitialize();
    }





    /**
     * @return the instance of {@link IdGenerator}
     * @throws IOException if an error occurs during initialization
     */
    public static synchronized IdGenerator getInstance() throws IOException {
        return instance == null ? instance = new IdGenerator() : instance;
    }


    /**
     * Initializes the current ID
     * If the file does not contain a valid ID, the current ID is reset to 0
     */
    private void initialize() {
        try {
            String lastIdStr = fileWorker.read();
            currentId = lastIdStr != null ? Integer.parseInt(lastIdStr) : 0;
        } catch (NumberFormatException e) {
            fileWorker.write(Integer.toString(currentId = 0));
        }
    }


    /**
     * Initializes the current Organization ID
     * If the file does not contain a valid Organization ID, the current ID is reset to 0
     */
    private void orgInitialize() {
        try {
            String lastIdStr = orgFileWorker.read();
            currentOrgId = lastIdStr != null ? Long.parseLong(lastIdStr) : 0;
        } catch (NumberFormatException e) {
            orgFileWorker.write(Long.toString(currentId = 0));
        }
    }

    /**
     * Generates a new unique ID and saves it to the file.
     * @return the newly generated unique ID
     * @throws IOException if an error occurs during file operations
     */
    public synchronized int generateId() throws IOException {
        currentId++;
        fileWorker.write(currentId + System.lineSeparator());
        return currentId;
    }


    /**
     * Generates a new unique ID for Organization and saves it to the file.
     * @return the newly generated unique Organization ID
     * @throws IOException if an error occurs during file operations
     */
    public synchronized Long generateOrgId() throws IOException {
        currentOrgId++;
        orgFileWorker.write(currentOrgId + System.lineSeparator());
        return currentOrgId;
    }

}