package OOD.Online_Shopping_System;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * ${Description}
 *
 * @author KeithLiu on 2020-04-11
 */

public class Catalog implements Search {
    private HashMap<String, List<Product>> productNames;
    private HashMap<String, List<Product>> productCategories;

    public Catalog() {
        productNames = new HashMap<>();
        productCategories = new HashMap<>();

    }

    public List<Product> searchProductsByName(String name) {
        return productNames.get(name);
    }

    public List<Product> searchProductsByCategory(String category) {
        return productCategories.get(category);
    }
}
