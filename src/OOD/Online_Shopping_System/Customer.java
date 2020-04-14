package OOD.Online_Shopping_System;

import java.util.List;

/**
 * ${Description}
 *
 * @author KeithLiu on 2020-04-11
 */

public abstract class Customer {
    private ShoppingCart cart;
    private Order order;

    public ShoppingCart getShoppingCart();
    public boolean addItemToCart(Item item);
    public boolean removeItemFromCart(Item item);
    public List<Product> searchByName(String input){
        return
    }
}
