package com.shobakaBarabaka.commands;

import com.shobakaBarabaka.IO.transfer.Request;
import com.shobakaBarabaka.IO.transfer.Response;
import com.shobakaBarabaka.collection.CollectionManager;
import com.shobakaBarabaka.collection.Product;

import java.util.HashSet;
import java.util.List;

/**
 * This command prints set of all unique part numbers in collection
 */
public final class PrintUniquePartNumber extends Command {

    /**
     * Constructs a new {@link PrintUniquePartNumber} command.
     */
    PrintUniquePartNumber() {
        super("print_unique_part_numbers", EMPTY_ARGS, "prints all unique part numbers in collection", 1);
    }

    /**
     * @param request unused for this command
     * @return a {@link Response} listing all unique part numbers
     */
    @Override
    public Response execute(final Request request) {

        List<String> partNumbers = CollectionManager.getInstance().list().stream()
                .map(Product::getPartNumber)
                .toList();
        HashSet<String> numbers = new HashSet<>(partNumbers);
        return new Response("unique part numbers: %s".formatted(numbers));

    }

}