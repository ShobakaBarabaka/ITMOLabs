package com.shobakaBarabaka.collection;


import com.shobakaBarabaka.IO.parser.JsonFormatter;
import com.shobakaBarabaka.IO.file.FilesPaths;

import java.util.LinkedList;
import java.util.List;

/**
 * Manages the collection of {@link Product} objects
 * Class provides methods to loads and save collection of {@link Product} to a file
 */
public class CollectionManager {
    private static CollectionManager instance;

    private final List<Product> list = new LinkedList<>();


    private CollectionManager() {
        load();
    }

    /**
     * @return the  instance of {@link CollectionManager}
     */
    public static CollectionManager getInstance() {
        return instance == null ? instance = new CollectionManager() : instance;
    }

    /**
     * Loads the collection of products from the file.
     */
    public void load() {
        JsonFormatter formatter = new JsonFormatter(FilesPaths.DATA_FILE_PATH);
        try (formatter) {
            list.clear();
            list.addAll(formatter.read());
            System.out.printf("loaded %d elements%n", list.size());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }


    /**
     * Saves the collection of products to the file.
     */
    public void save() {
        JsonFormatter formatter = new JsonFormatter(FilesPaths.DATA_FILE_PATH);
        try (formatter) {
            formatter.write(list);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * @return a list of {@link Product} objects
     */
    public List<Product> list() {
        return list;
    }
}