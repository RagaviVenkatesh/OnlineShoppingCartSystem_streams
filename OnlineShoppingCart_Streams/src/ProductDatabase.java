import java.util.*;

public class ProductDatabase {
    public static List<Product> getAllProducts() {
        return Arrays.asList(
            new Product(1, "Laptop", "Electronics", 70000, 4.5),
            new Product(2, "Mouse", "Electronics", 500, 4.1),
            new Product(3, "Jeans", "Clothing", 1500, 4.0),
            new Product(4, "T-shirt", "Clothing", 800, 4.2),
            new Product(5, "Cooking Oil", "Grocery", 180, 3.8),
            new Product(6, "Milk", "Grocery", 60, 4.0)
        );
    }
}
