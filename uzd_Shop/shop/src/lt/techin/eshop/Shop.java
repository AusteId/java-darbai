package lt.techin.eshop;

import java.util.ArrayList;

public class Shop {
    private ArrayList<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product productToRemove) {
        for (Product product : products) {
            if(product.getTitle().equals(productToRemove.getTitle())) {
                products.remove(productToRemove);
            }
        }
    }

    public String toString() {
        for (Product product : products) {
            System.out.println(product.getTitle() + ": " + product.countBrutoInEuros2() + "€ (" + product.countBrutoInFranks2() + "CHF)");
        }
        return "";
    }
}
