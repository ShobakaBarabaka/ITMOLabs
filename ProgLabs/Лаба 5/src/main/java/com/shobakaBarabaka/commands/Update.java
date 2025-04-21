package com.shobakaBarabaka.commands;

import com.shobakaBarabaka.IO.transfer.Request;
import com.shobakaBarabaka.IO.transfer.Response;
import com.shobakaBarabaka.collection.CollectionManager;
import com.shobakaBarabaka.collection.Product;

import java.util.Objects;


/**
 * This command updates a Product with specified id
 */
public final class Update extends Command {

    /**
     * Constructs a new {@link Update} command.
     */
    Update() {
        super("update", new String[]{"id"}, "updates product with specified id", 1);
    }

    /**
     * Executes the command to update an element in the collection with given id
     * @param request the {@link Request} containing the id of Product
     * @return a {@link Response} indicating the result of the operation
     */
    @Override
    public Response execute(final Request request) {
        if (request.args() == null || request.args().isEmpty()) {
            return new Response("No product to update");
        }

        final Integer targetId = Integer.parseInt(request.args().getFirst());
        if (CollectionManager.getInstance().list().stream().noneMatch(product -> Objects.equals(product.getId(), targetId))) {
            return new Response("Product with id %s not found.".formatted(targetId));
        }
        Product targetProduct = CollectionManager.getInstance().list().stream()
                .filter(product -> Objects.equals(product.getId(), targetId))
                .toList()
                .getFirst();
        targetProduct.setManufacturer(request.products().getFirst().getManufacturer());
        targetProduct.setCoordinates(request.products().getFirst().getCoordinates());
        targetProduct.setName(request.products().getFirst().getName());
        targetProduct.setPrice(request.products().getFirst().getPrice());
        targetProduct.setPartNumber(request.products().getFirst().getPartNumber());
        targetProduct.setManufactureCost(request.products().getFirst().getManufactureCost());
        targetProduct.setUnitOfMeasure(request.products().getFirst().getUnitOfMeasure());

        return new Response("Person updated");
    }

}