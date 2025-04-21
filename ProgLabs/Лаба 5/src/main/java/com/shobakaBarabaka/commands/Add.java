package com.shobakaBarabaka.commands;

import com.shobakaBarabaka.IO.transfer.Request;
import com.shobakaBarabaka.IO.transfer.Response;
import com.shobakaBarabaka.collection.CollectionManager;
import com.shobakaBarabaka.collection.Product;

/**
 * This command adds new element to the collection
 */
public final class Add extends Command {

    /**
     * Constructs a new {@link Add} command
     */
    Add() {
        super("add", EMPTY_ARGS, "adds element to the collection", 1);
    }

    /**
     * @param request the {@link Request} containing the {@link Product} to add
     * @return a {@link Response} indicating the result of the operation
     */
    @Override
    public Response execute(final Request request) {
        if (request.products() == null || request.products().isEmpty()) {
            return new Response("No products to add.");
        }
        CollectionManager.getInstance().list().add(request.products().getFirst());
        return new Response("Person added.");
    }
}