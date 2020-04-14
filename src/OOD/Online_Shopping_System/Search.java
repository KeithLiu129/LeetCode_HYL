package OOD.Online_Shopping_System;

import java.util.List;

/**
 * ${Description}
 *
 * @author KeithLiu on 2020-04-11
 */

public interface Search {
    public List<Product> searchProductsByName(String name);
    public List<Product> searchProductsByCategory(String category);

}
