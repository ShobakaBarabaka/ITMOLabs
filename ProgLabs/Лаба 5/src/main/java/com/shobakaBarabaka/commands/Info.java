package com.shobakaBarabaka.commands;


import java.time.LocalDate;
import java.util.List;
import com.shobakaBarabaka.IO.transfer.Request;
import com.shobakaBarabaka.IO.transfer.Response;
import com.shobakaBarabaka.collection.CollectionManager;
import com.shobakaBarabaka.collection.Product;


/**
 * This command show information about collection
 */
public final class Info extends Command {

    /**
     * Constructs a new {@link Info} command
     */
    Info(){
        super("info", "shows information about collection");
    }


    /**
     *
     * @param request unused for this command
     * @return a {@link Response} with information about collection
     */
    @Override
    public Response execute(final Request request){
        List<Product> collection = CollectionManager.getInstance().list();
        LocalDate initDate = CollectionManager.getInstance().list().getLast().getCreationDate();
        int quantity = collection.size();
        return new Response(String.format("""
                Collection: %s,
                \
                Initialization Date: %s,
                \
                Quantity: %d,
                \
                Type: %s""", collection, initDate, quantity, collection.getClass()));
    }
}
