package lt.techin;

import ibank.Bank;
import ibank.BaseBankTest;

public class BankTest extends BaseBankTest {
    @Override
    protected Bank createBank() {
        return new BankRuptcy();
    }
}
