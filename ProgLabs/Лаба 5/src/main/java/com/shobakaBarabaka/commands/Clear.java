package com.shobakaBarabaka.commands;

import com.shobakaBarabaka.IO.transfer.Request;
import com.shobakaBarabaka.IO.transfer.Response;
import com.shobakaBarabaka.collection.CollectionManager;

/**
 * This command to clear the entire collection
 */
public final class Clear extends Command {

    /**
     * Constructs a new {@link Clear} command
     */
    Clear() {
        super("clear", "clears all collection");
    }

    /**
     * @param request unused for this command
     * @return a {@link Response} indicating whether the collection was cleared or was already empty
     */
    @Override
    public Response execute(final Request request) {
        if (CollectionManager.getInstance().list().isEmpty()) {
            return new Response("Collection is already empty.");
        }
        CollectionManager.getInstance().list().clear();
        return new Response("Collection cleared.");
    }
}