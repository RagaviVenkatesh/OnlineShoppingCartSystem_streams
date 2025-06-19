public class Product {
    private int id;
    private String name;
    private String category;
    private double price;
    private double rating;

    public Product(int id, String name, String category, double price, double rating) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.rating = rating;
    }

    // Getters + toString
    public int getId() { return id; }
    public String getName() { return name; }
    public String getCategory() { return category; }
    public double getPrice() { return price; }
    public double getRating() { return rating; }

    @Override
    public String toString() {
        return id + " - " + name + " | " + category + " | ₹" + price + " | ⭐ " + rating;
    }
}
