package com.shobakaBarabaka.IO.parser;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.shobakaBarabaka.collection.Product;

import java.lang.reflect.Type;
import java.util.LinkedList;
import java.util.List;

/**
 * Deserializer for a {@link List} of {@link Product} objects
 */
public class Deserializer implements JsonDeserializer<List<Product>> {

    /**
     * Deserializes a JSON element into a {@link List} of {@link Product} objects
     * @param json    the JSON element to deserialize
     * @param typeOfT the type of the object to deserialize to
     * @param context the context for deserialization
     * @return a {@link List} of {@link Product} objects
     * @throws JsonParseException if the JSON is not in the expected format
     */
    @Override
    public List<Product> deserialize(
            final JsonElement json,
            final Type typeOfT,
            final JsonDeserializationContext context
    ) throws JsonParseException {
        List<Product> myCollection = new LinkedList<>();
        json.getAsJsonArray().forEach(element -> myCollection.add(context.deserialize(element, Product.class)));
        return myCollection;
    }
}

