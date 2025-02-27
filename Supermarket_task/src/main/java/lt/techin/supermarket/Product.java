package lt.techin.supermarket;

public class Product {

    private String name;
    private double price;
    private int quantity = 0;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantityWithAmount(int howMuch) {
        quantity += howMuch;
    }

    public void setQuantityByOneUp() {
        quantity++;
    }

    public void setQuantityByOneDown() {
        quantity--;
    }

    public String toString() {
        return name.toUpperCase() + " Quantity: " + quantity;
    }
}
