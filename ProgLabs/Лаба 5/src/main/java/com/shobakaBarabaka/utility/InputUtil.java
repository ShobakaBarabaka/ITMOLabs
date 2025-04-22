package com.shobakaBarabaka.utility;

import com.shobakaBarabaka.IO.console.BufferedConsoleWorker;
import com.shobakaBarabaka.collection.*;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * InputUtil class provides methods for reading input and parsing
 * it to a {@link Product} object.
 */
public class InputUtil {

    /**
     * Reads and creates a {@link Product} object from input,
     * ask for each field through console.
     * @param io the {@link BufferedConsoleWorker} used for reading and writing input
     * @return a {@link Product} object populated with user input
     * @throws InterruptedException if the input process is interrupted
     */
    public static Product get(BufferedConsoleWorker io) throws InterruptedException {
        Product product = new Product();

        while (input("name: ", product::setName, String::valueOf, io)) ;
        while (input("price: ", product::setPrice, Float::valueOf, io)) ;
        while (input("part number: ", product::setPartNumber, String::valueOf, io)) ;
        while (input("manufacture cost: ", product::setManufactureCost, Integer::valueOf, io)) ;
        while (input("unit of measure %s: ".formatted(
                Arrays.toString(UnitOfMeasure.values())), product::setUnitOfMeasure, UnitOfMeasure::valueOf, io)
        ) ;

        Coordinates coordinates = new Coordinates();
        while (input("cord x: ", coordinates::setX, Long::valueOf, io)) ;
        while (input("cord y: ", coordinates::setY, Long::valueOf, io)) ;
        product.setCoordinates(coordinates);

        Organization organization = new Organization();
        while (input("Organization name: ", organization::setName, String::valueOf, io)) ;
        while (input("Organization full name: ", organization::setFullName, String::valueOf, io)) ;
        while (input("Organization type %s: ".formatted(
                Arrays.toString(OrganizationType.values())), organization::setType, OrganizationType::valueOf, io)
        ) ;
        product.setManufacturer(organization);

        return product;
    }

    /**
     * Reads and parses input for a different fields.
     * @param fieldName the name of the field being input
     * @param setter    a method that sets the field value
     * @param parser    a method that parse the input string
     * @param io        the {@link BufferedConsoleWorker} used for reading and writing input
     * @param <K>       the type of the field being set
     * @return True if the input was successfully processed, False otherwise
     */
    private static <K> boolean input(
            final String fieldName,
            final Consumer<K> setter,
            final Function<String, K> parser,
            final BufferedConsoleWorker io
    ) throws InterruptedException {
        try {
            String line = io.read(" - " + fieldName);
            if (line == null || line.equals("return")) throw new InterruptedException("called return");

            if (line.isBlank()) setter.accept(null);
            else setter.accept(parser.apply(line));

            return false;
        } catch (InterruptedException e) {
            throw e;
        } catch (Exception ex) {
            if (ex instanceof NullPointerException) {
                return false;
            }
            io.write(ex.getMessage() + System.lineSeparator());
            return true;
        }
    }
}