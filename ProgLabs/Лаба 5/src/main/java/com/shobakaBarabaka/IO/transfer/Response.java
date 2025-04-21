package com.shobakaBarabaka.IO.transfer;

import com.shobakaBarabaka.collection.Product;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Represents a response with a message, a list of products, and an optional script.
 * @param message the response message
 * @param products the list of Product objects coming with the response
 * @param script  a script to execute (optional)
 */
public record Response(String message, List<Product> products, String script) {

    /**
     * Constructs a {@link Response} with a message and a list of products
     * @param message the {@link Response} message
     * @param products the list of {@link Product} objects
     */
    public Response(
            final String message,
            final List<Product> products
    ) {
        this(message, products, null);
    }

    /**
     * Constructs a {@link Response} with a message and a variable number of products.
     * @param message the response message
     * @param products the {@link Product} objects
     */
    public Response(
            final String message,
            final Product... products
    ) {
        this(message, Arrays.asList(products), null);
    }

    /**
     * Constructs a {@link Response} with only a message.
     * @param message the response message
     */
    public Response(final String message) {
        this(message, Collections.emptyList(), null);
    }

    /**
     * @return an empty {@link Response} instance
     */
    public static Response empty() {
        return new Response(null);
    }
}