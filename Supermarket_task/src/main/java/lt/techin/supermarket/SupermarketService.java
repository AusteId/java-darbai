package lt.techin.supermarket;
import java.util.List;
import java.util.Map;

public interface SupermarketService {

    List<Product> getAllProducts();
    Map<Double, Integer> getAllCash();


    Product selectProduct(String product);
    void addAdditionalCoins(double denomination, int quantity);
}
