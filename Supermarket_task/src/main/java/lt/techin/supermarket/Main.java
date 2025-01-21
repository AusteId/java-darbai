package lt.techin.supermarket;

import lt.techin.supermarket.exceptions.NotEnoughChangeException;
import lt.techin.supermarket.exceptions.SoldOutException;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Product p = new Product("apple", 1.5, 20);
        Product b = new Product("milk", 2.5, 10);
        ProductStorage storage = new ProductStorage();
        storage.addProduct(p);
        storage.addProduct(b);
//        storage.displayAllProductsWithQuantity();
//        storage.displayAllProductsWithPrice();

        CashRegister cashRegister = new CashRegister();
        cashRegister.addCash(CashRegister.CENTS_10, 50);
        cashRegister.addCash(CashRegister.CENTS_50, 20);
        cashRegister.addCash(CashRegister.EUROS_1, 10);
        cashRegister.addCash(CashRegister.EUROS_2, 10);

        SupermarketServiceImpl lidl = new SupermarketServiceImpl(cashRegister, storage);
        System.out.println(lidl.getAllProducts());
        System.out.println(lidl.getAllCash());
//        try {
//            cashRegister.giveChange(10000007.7);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            System.out.println(lidl.getAllCash());
//        }

        System.out.println("==============================================================================");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to TECHIN Supermarket!");
        System.out.println();
        System.out.println("Initial Product Inventory:");
        storage.displayAllProductsWithQuantity();
        System.out.println();
        System.out.println("Initial Cash Inventory:");
        cashRegister.displayAllCashWithQuantity();
        System.out.println();


        System.out.println("What would you like to buy? Type in the name of the desired product: ");
        String product = scanner.nextLine();
        Product prod = lidl.selectProduct(product);
        System.out.println("You are trying to buy " + prod.getName().toUpperCase() + ". You need to pay " + prod.getPrice() + ".");
        System.out.println("Provide bill or coin (accepted values: 0.1, 0.5, 1, 2):");
        double productPrice = prod.getPrice();
        double productPriceModified = prod.getPrice();
        double totalCoinsValue = 0;
        Map<Double, Integer> coinsGiven = new HashMap<>();
        double change = 0;

        while (true) {
            if (productPriceModified <= 0) {
                break;
            }
            double coin = Double.parseDouble(scanner.nextLine());
            lidl.executePayment(productPriceModified, coin);
            productPriceModified -= coin;
            totalCoinsValue += coin;
            coinsGiven.put(coin, coinsGiven.getOrDefault(coin, 0) + 1);
            System.out.println("You paid " + totalCoinsValue + " in total.");
            if (productPriceModified <= 0) {
                break;
            }
            System.out.println("You still need to pay " + productPriceModified);
        }
        System.out.println("Coin given: " + coinsGiven);

        change = cashRegister.countChange(totalCoinsValue, productPrice);

        var changeCoins = cashRegister.giveChange(change);
        System.out.println("Here is your product: " + prod.getName().toUpperCase());
        System.out.println("Here is your change:");
        for (Map.Entry<Double, Integer> entry : changeCoins.entrySet()) {
            System.out.println("Value: " + entry.getKey() + " , quantity: " + entry.getValue());
        }
        System.out.println("----------");
        cashRegister.displayAllCashWithQuantity();
    }
}
