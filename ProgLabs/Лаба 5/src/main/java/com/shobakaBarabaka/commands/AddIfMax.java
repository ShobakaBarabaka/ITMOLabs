package com.shobakaBarabaka.commands;

import com.shobakaBarabaka.IO.transfer.Request;
import com.shobakaBarabaka.IO.transfer.Response;
import com.shobakaBarabaka.collection.CollectionManager;
import com.shobakaBarabaka.collection.Product;

import java.util.Collections;
import java.util.List;

/**
 * This command adds element if it's price is higher than the highest price in collection
 */
public final class AddIfMax extends Command {

    /**
     * Constructs a new {@link AddIfMax} command
     */
    AddIfMax() {
        super("add_if_max", EMPTY_ARGS, "adds element to the collection if it's price is larger than max price in collection", 1);
    }

    /**
     * @param request the {@link Request} containing the {@link Product} to add
     * @return a {@link Response} indicating the result of the operation
     */
    @Override
    public Response execute(final Request request) {
        if (request.products() == null || request.products().isEmpty()) {
            return new Response("No product to add.");
        }

        if (request.products().getFirst().getPrice() > maxPrice()) {
            CollectionManager.getInstance().list().add(request.products().getFirst());
            return new Response("Product added.");
        }
        else {
            return new Response("Product is not max price.");
        }
    }
    private Float maxPrice(){
        List<Float> prices = CollectionManager.getInstance().list().stream()
                .map(Product::getPrice)
                .toList();
        return Collections.max(prices);
    }

}