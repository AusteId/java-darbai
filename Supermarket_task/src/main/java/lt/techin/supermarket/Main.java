package lt.techin.supermarket;

public class Main {
    public static void main(String[] args) {

        SupermarketServiceImpl s = new SupermarketServiceImpl();
        Product p = new Product("apple", 5);
        ProductStorage storage = new ProductStorage();
        storage.addProduct(p);
        System.out.println(s.getAllCash());
        System.out.println(s.getAllProducts());
        storage.displayAllProductsWithQuantity();
        storage.displayAllProductsWithPrice();

    }
}