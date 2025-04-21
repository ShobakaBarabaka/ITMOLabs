package com.shobakaBarabaka.IO.transfer;

import com.shobakaBarabaka.collection.Product;

import java.util.List;

/**
 * Represents a request with a command, arguments, and products
 * @param command the command being executed
 * @param args   required arguments
 * @param products the list of {@link Product} objects associated with the command
 */
public record Request(String command, List<String> args, List<Product> products) {
}