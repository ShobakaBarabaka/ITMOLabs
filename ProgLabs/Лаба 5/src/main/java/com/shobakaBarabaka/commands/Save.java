package com.shobakaBarabaka.commands;

import com.shobakaBarabaka.IO.transfer.Request;
import com.shobakaBarabaka.IO.transfer.Response;
import com.shobakaBarabaka.collection.CollectionManager;

/**
 * This command saves collection to the file
 */
public final class Save extends Command {

    /**
     * Constructs a new {@link Save} command
     */
    Save() {
        super("save", "saves collection to file");
    }

    /**
     * @param request unused for this command
     * @return a {@link Response} confirming that the collection has been saved
     */
    @Override
    public Response execute(Request request) {
        CollectionManager.getInstance().save();
        return new Response("Collection saved.");
    }
}