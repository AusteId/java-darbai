package lt.techin.supermarket;

import lt.techin.supermarket.exceptions.SoldOutException;

import java.util.ArrayList;

public class ProductStorage {

    private ArrayList<Product> products = new ArrayList<>();

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void takeProduct(Product product) {
        products.remove(product);
    }

    public void displayAllProductsWithQuantity() {
        products.forEach(a -> System.out.println(a.getName().toUpperCase() + " quantity: " + a.getQuantity()));
    }

    public void displayAllProductsWithPrice() {
        products.forEach(a -> System.out.println(a.getName().toUpperCase() + " price: " + a.getPrice()));
    }

    public Product selectProduct(String name) {
        return products.stream().filter(a -> name != null && name.equals(a.getName()))
                .findFirst().orElseThrow(() -> new SoldOutException("Error: Product not available!"));
    }

}
