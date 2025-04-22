package com.shobakaBarabaka.commands;

import com.shobakaBarabaka.IO.transfer.Request;
import com.shobakaBarabaka.IO.transfer.Response;
import com.shobakaBarabaka.collection.CollectionManager;
import com.shobakaBarabaka.collection.Product;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * This command prints any element with the highest price in collection
 */
public final class MaxByPrice extends Command {

    /**
     * Constructs a new {@link MaxByPrice} command.
     */
    MaxByPrice() {
        super("max_by_price", EMPTY_ARGS, "prints any element with highest price");
    }

    /**
     * @param request unused for this command
     * @return a {@link Response} with the highest price product
     */
    @Override
    public Response execute(final Request request) {
        for (Product product: CollectionManager.getInstance().list()){
            if (Objects.equals(product.getPrice(), maxPrice())){
                return new Response("product with highest price:", product);
            }
        }
        return new Response("there is no product to add");
    }
    private Float maxPrice(){
        List<Float> prices = CollectionManager.getInstance().list().stream()
                .map(Product::getPrice)
                .toList();
        return Collections.max(prices);
    }

}