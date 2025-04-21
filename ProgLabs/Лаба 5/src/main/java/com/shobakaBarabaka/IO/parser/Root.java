package com.shobakaBarabaka.IO.parser;

import com.shobakaBarabaka.collection.Product;

import java.util.List;

/**
 * The root structure of a JSON file containing a collection of Product objects
 * @param collection the list of {@link Product} objects
 */
public record Root(List<Product> collection) {

}