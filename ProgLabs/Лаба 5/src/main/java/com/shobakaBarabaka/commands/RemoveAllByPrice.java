package com.shobakaBarabaka.commands;

import com.shobakaBarabaka.IO.transfer.Request;
import com.shobakaBarabaka.IO.transfer.Response;
import com.shobakaBarabaka.collection.CollectionManager;
import com.shobakaBarabaka.collection.Product;

import java.util.Objects;

/**
 * This command removes all elements with specified price
 */
public final class RemoveAllByPrice extends Command {

    /**
     * Constructs a new {@link RemoveAllByPrice} command
     */
    RemoveAllByPrice() {
        super("remove_all_by_price", new String[]{"price"}, "removes all products with given price", 1);
    }

    /**
     * @param request the {@link Request} containing the price
     * @return a {@link Response} indicating the result of the operation
     */
    @Override
    public Response execute(final Request request) {
        if (request.args() == null || request.args().isEmpty()) {
            return new Response("No price to remove.");
        }


        final Float targetPrice = Float.parseFloat(request.args().getFirst());
        if (CollectionManager.getInstance().list().stream().noneMatch(product -> Objects.equals(product.getPrice(), targetPrice))) {
            return new Response("Person with price %s not found.".formatted(targetPrice));
        }
        CollectionManager.getInstance().list().removeIf(product -> Objects.equals(product.getPrice(), targetPrice));

        return new Response("Person removed. Removed element:");
    }

}