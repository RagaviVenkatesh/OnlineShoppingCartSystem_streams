import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Product> products = ProductDatabase.getAllProducts();
        CartService cartService = new CartService();

        while (true) {
            System.out.println("\n--- Shopping Cart Menu ---");
            System.out.println("1. Show All Products");
            System.out.println("2. Add Product to Cart");
            System.out.println("3. Show Cart");
            System.out.println("4. Total Amount");
            System.out.println("5. Sort Cart by Price");
            System.out.println("6. Group by Category");
            System.out.println("7. Filter by Rating");
            System.out.println("8. Apply Discount");
            System.out.println("9. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    products.forEach(System.out::println);
                    break;
                case 2:
                    System.out.print("Enter Product ID: ");
                    int id = sc.nextInt();
                    System.out.print("Enter Quantity: ");
                    int qty = sc.nextInt();
                    products.stream()
                            .filter(p -> p.getId() == id)
                            .findFirst()
                            .ifPresent(p -> cartService.addToCart(p, qty));
                    break;
                case 3:
                    cartService.showCart();
                    break;
                case 4:
                    System.out.println("Total: ₹" + cartService.getTotal());
                    break;
                case 5:
                    cartService.showSortedByPrice();
                    break;
                case 6:
                    cartService.groupByCategory();
                    break;
                case 7:
                    System.out.print("Enter min rating: ");
                    double r = sc.nextDouble();
                    cartService.filterByRating(r);
                    break;
                case 8:
                    System.out.print("Enter discount %: ");
                    double d = sc.nextDouble();
                    cartService.applyDiscount(d);
                    break;
                case 9:
                    System.out.println("Thank you for shopping!");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
