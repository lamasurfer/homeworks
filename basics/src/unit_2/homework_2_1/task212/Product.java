package unit_2.homework_2_1.task212;


public class Product implements Comparable<Product> {
    public String name;
    public int price;
    public String description;

    public Product(String name, int price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toString() {
        return getName() + " " + getPrice() + " руб " + getDescription();

    }

    public int compareTo(Product product) {
        return this.price - (product.price);
    }

}



