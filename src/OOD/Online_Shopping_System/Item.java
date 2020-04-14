package OOD.Online_Shopping_System;

/**
 * ${Description}
 *
 * @author KeithLiu on 2020-04-11
 */

public class Item {
    private String productID;
    private int quantity;
    private double price;

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean updateQuantity(int quantity){
        if (quantity < 0) {
            return false;
        }
        this.quantity = quantity;
        return true;
    }
}
