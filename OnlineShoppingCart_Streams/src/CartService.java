import java.util.*;
import java.util.stream.*;

public class CartService {
    private List<CartItem> cart = new ArrayList<>();

    public void addToCart(Product product, int quantity) {
        cart.add(new CartItem(product, quantity));
    }

    public void showCart() {
        cart.forEach(System.out::println);
    }

    public double getTotal() {
        return cart.stream()
                   .mapToDouble(CartItem::getTotalPrice)
                   .sum();
    }

    public void showSortedByPrice() {
        cart.stream()
            .sorted(Comparator.comparingDouble(ci -> ci.getProduct().getPrice()))
            .forEach(System.out::println);
    }

    public void groupByCategory() {
        cart.stream()
            .collect(Collectors.groupingBy(ci -> ci.getProduct().getCategory()))
            .forEach((category, items) -> {
                System.out.println("Category: " + category);
                items.forEach(System.out::println);
            });
    }

    public void filterByRating(double threshold) {
        cart.stream()
            .filter(ci -> ci.getProduct().getRating() >= threshold)
            .forEach(System.out::println);
    }

    public void applyDiscount(double discountPercent) {
        cart.forEach(ci -> {
            double original = ci.getProduct().getPrice();
            double discounted = original * (1 - discountPercent / 100);
            System.out.println(ci.getProduct().getName() + " - Original: ₹" + original + ", Discounted: ₹" + discounted);
        });
    }
}
