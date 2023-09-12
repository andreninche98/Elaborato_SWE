package ContoBancario;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountUpgradeIsNegativeTest { //classe per test sul conto negativo

    @Test
    void upgradeToPremium() {
        PaymentStrategy strategy = new CreditCardPay();
        Account standardAccount = new StandardAccount(new User("Mario", "Rossi", 42), 50, false);
        AccountUpgrade accountUpgrade = new AccountUpgrade(10);
        Account premiumAccount = accountUpgrade.upgradeToPremium(standardAccount);
        premiumAccount.setStrategy(strategy);
        assertEquals(40, premiumAccount.getBalance());
        premiumAccount.pay(50);
        premiumAccount.checkDecrement(50);
        assertTrue(premiumAccount.getBalance() < 0);
        assertFalse(premiumAccount.getBalance() < -50);
    }
}