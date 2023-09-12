package ContoBancario;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountUpgradeBalanceTest { //classe per test sul bilancio dopo l'upgrade

    @Test
    void upgradeToPremium() {
        Account standardAccount = new StandardAccount(new User("Mario","Rossi",42),50,false);
        AccountUpgrade accountUpgrade = new AccountUpgrade(10);
        Account premiumAccount = accountUpgrade.upgradeToPremium(standardAccount);
        assertEquals(40,premiumAccount.getBalance());
    }
}