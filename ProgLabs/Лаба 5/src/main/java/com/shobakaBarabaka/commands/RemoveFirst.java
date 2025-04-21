package com.shobakaBarabaka.commands;

import com.shobakaBarabaka.IO.transfer.Request;
import com.shobakaBarabaka.IO.transfer.Response;
import com.shobakaBarabaka.collection.CollectionManager;


/**
 * This command removes first element from the collection
 */
public final class RemoveFirst extends Command {

    /**
     * Constructs a new {@link RemoveFirst} command
     */
    RemoveFirst() {
        super("remove_first", "remove first element from collection");
    }

    /**
     * @param request unused for this command
     * @return a {@link Response} indicating that the first element was removed
     */
    @Override
    public Response execute(final Request request) {
        if (CollectionManager.getInstance().list().isEmpty()) {
            return new Response("Collection is empty.");
        }
        CollectionManager.getInstance().list().removeFirst();
        return new Response("First element removed.");
    }
}