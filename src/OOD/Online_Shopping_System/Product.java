package OOD.Online_Shopping_System;

/**
 * ${Description}
 *
 * @author KeithLiu on 2020-04-11
 */

public class Product {
    private String productID;
    private String name;
    private String description;
    private double price;
    private ProductCategory category;
    private int availableItemCount;

    private Account seller;

    public int getAvailableCount();
    public boolean updatePrice(double newPrice);
}