package OOD.Online_Shopping_System;

import java.util.List;

/**
 * ${Description}
 *
 * @author KeithLiu on 2020-04-11
 */

public class ShoppingCart {
    private List<Item> items;

    public boolean addItem(Item item);
    public boolean removeItem(Item item);
    public boolean updateItemQuantity(Item item, int quantity);
    public List<Item> getItems();
    public boolean checkout();
}