package lt.techin.supermarket;

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

    @Override
    public String toString() {
        return
               
    }
}
