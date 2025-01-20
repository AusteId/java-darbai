package lt.techin.supermarket;

import java.util.List;
import java.util.Map;

public class SupermarketServiceImpl implements SupermarketService {

    private CashRegister cashRegister = new CashRegister();
    private ProductStorage productStorage = new ProductStorage();

    @Override
    public List<Product> getAllProducts() {
        return productStorage.getProducts();
    }

    @Override
    public Map<Double, Integer> getAllCash() {
        return cashRegister.getCash();
    }
}
