package com.shobakaBarabaka.commands;

import com.shobakaBarabaka.IO.transfer.Request;
import com.shobakaBarabaka.IO.transfer.Response;
import com.shobakaBarabaka.collection.CollectionManager;
import com.shobakaBarabaka.collection.Product;


/**
 * This command at first shows the first element of the collection and then removes it
 */
public final class RemoveHead extends Command {

    /**
     * Constructs a new {@link RemoveHead} command
     */
    RemoveHead() {
        super("remove_head", "prints first element from collection and removes it");
    }

    /**
     * @param request unused for this command
     * @return a {@link Response} telling which element has been removed
     */
    @Override
    public Response execute(final Request request) {
        if (CollectionManager.getInstance().list().isEmpty()) {
            return new Response("Collection is empty.");
        }
        Product first = CollectionManager.getInstance().list().getFirst();
        CollectionManager.getInstance().list().removeFirst();
        return new Response("First element %s removed.".formatted(first));
    }
}