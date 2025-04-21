package com.shobakaBarabaka.commands;

import com.shobakaBarabaka.IO.transfer.Request;
import com.shobakaBarabaka.IO.transfer.Response;
import com.shobakaBarabaka.collection.CollectionManager;

/**
 * This command shows all elements in the collection
 */
public final class Show extends Command {

    /**
     * Constructs a new {@link Show} command
     */
    Show() {
        super("show", "shows elements of the collection");
    }

    /**
     * Executes the command to display all elements in the collection.
     * @param request unused in this command
     * @return a {@link Response} containing the collection elements
     */
    @Override
    public Response execute(Request request) {
        if (CollectionManager.getInstance().list().isEmpty()) {
            return new Response("Collection is empty.");
        }
        return new Response("Elements of the collection:", CollectionManager.getInstance().list());
    }
}