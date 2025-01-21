package lt.techin.supermarket;

import java.util.List;
import java.util.Map;

public class SupermarketServiceImpl implements SupermarketService {

    private CashRegister cashRegister = new CashRegister();
    private ProductStorage productStorage = new ProductStorage();

    public SupermarketServiceImpl(CashRegister cashRegister, ProductStorage productStorage) {
        this.cashRegister = cashRegister;
        this.productStorage = productStorage;
    }

    @Override
    public List<Product> getAllProducts() {
        return productStorage.getProducts();
    }

    @Override
    public Map<Double, Integer> getAllCash() {
        return cashRegister.getCash();
    }

    @Override
    public Product selectProduct(String productName) {
        return productStorage.selectProduct(productName);
    }

    @Override
    public void addAdditionalCoins(double denomination, int quantity) {
        cashRegister.addAdditionalCoins(denomination, quantity);
    }


}
