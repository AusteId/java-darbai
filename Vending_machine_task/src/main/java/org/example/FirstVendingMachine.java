package org.example;

import lt.vtvpmc.vending.machine.Coin;
import lt.vtvpmc.vending.machine.ProductPurchaseResult;
import lt.vtvpmc.vending.machine.ProductType;
import lt.vtvpmc.vending.machine.VendingMachine;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class FirstVendingMachine implements VendingMachine {

    Map<ProductType, Integer> productTypes = new HashMap<>();
    Map<Coin, Integer> coins = new TreeMap<>(Comparator.reverseOrder());

    @Override
    public void addProduct(ProductType productType, int i) {
        if (i < 0 || productType == null) {
            throw new IllegalArgumentException();
        }

        int initialAmount = 0;
        for (Map.Entry<ProductType, Integer> entry : productTypes.entrySet()) {
            if (entry.getKey().equals(productType)) {
                initialAmount = entry.getValue();
            }
        }

        productTypes.put(productType, i + initialAmount);

    }

    @Override
    public ProductPurchaseResult buyProduct(ProductType productType) {


        ProductPurchaseResult productPurchaseResult = new ProductPurchaseResult(false, 0, productType);


        if (!productTypes.containsKey(productType)) {
            return new ProductPurchaseResult(false, productPurchaseResult.getChange(), productType);
        }

        double currentChange = productPurchaseResult.getChange();

        if(productType.getPrice() > currentChange) {
            return new ProductPurchaseResult(false, currentChange, productType);
        }

        int initialAmount = productTypes.get(productType);
        if(initialAmount > 0) {
            productTypes.put(productType, initialAmount - 1);
            double leftAfterBuying = currentChange - productType.getPrice();
            return new ProductPurchaseResult(true, leftAfterBuying, productType);
        } else {
            return new ProductPurchaseResult(false, currentChange, productType);
        }
    }

    @Override
    public void insertCoin(Coin coin) {

        int initialAmount = 0;
        for (Map.Entry<Coin, Integer> entry : coins.entrySet()) {
            if (entry.getKey().equals(coin)) {
                initialAmount = entry.getValue();
            }
        }

        coins.put(coin, 1 + initialAmount);
    }
}
