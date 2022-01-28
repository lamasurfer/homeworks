package unit_4.homework4_3.training43;

public class Product {

    private int number;
    private String productName;
    private int price;

    public Product(int number, String productName, int price) {
        this.number = number;
        this.productName = productName;
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj.getClass() != getClass()) return false;
        Product other = (Product) obj;
        return productName.equals(other.productName);
    }

    @Override
    public int hashCode() {
        return productName.hashCode();
    }

    @Override
    public String toString() {
        return String.format("№ %s %s %s у.е.", number, productName, price);
    }
}
