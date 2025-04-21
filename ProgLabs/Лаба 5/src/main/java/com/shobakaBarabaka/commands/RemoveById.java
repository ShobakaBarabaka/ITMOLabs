package com.shobakaBarabaka.commands;

import com.shobakaBarabaka.IO.transfer.Request;
import com.shobakaBarabaka.IO.transfer.Response;
import com.shobakaBarabaka.collection.CollectionManager;

import java.util.Objects;

/**
 * This command removes the element from the collection with specified id
 */
public final class RemoveById extends Command {

    /**
     * Constructs a new {@link RemoveById} command
     */
    RemoveById() {
        super("remove_by_id", new String[]{"id"}, "remove element from collection with this id", 1);
    }

    /**
     * @param request the {@link Request} containing id of Product to remove
     * @return a {@link Response} indicating the result of the operation
     */
    @Override
    public Response execute(final Request request) {
        if (request.args() == null || request.args().isEmpty()) {
            return new Response("No id to remove.");
        }


        final Integer targetId = Integer.parseInt(request.args().getFirst());
        if (CollectionManager.getInstance().list().stream().noneMatch(product -> Objects.equals(product.getId(), targetId))) {
            return new Response("Person with id %s not found.".formatted(targetId));
        }
        CollectionManager.getInstance().list().removeIf(product -> Objects.equals(product.getId(), targetId));

        return new Response("Person removed. Removed element:");
    }

}