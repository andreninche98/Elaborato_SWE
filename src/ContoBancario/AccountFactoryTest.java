package ContoBancario;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AccountFactoryTest { //classe per test sulle factories
    @Test
    public void testStandardAccountCreation(){
        AccountFactory standardFactory = new StandardFactory();
        User user = new User("Mario","Rossi",40);
        Account account = standardFactory.create(user);
        assertTrue(account instanceof StandardAccount);
        assertEquals(user, account.getUser());
        assertEquals(0,account.getBalance());
    }
    @Test
    public void testPremiumAccountCreation(){
        AccountFactory premiumFactory = new PremiumFactory();
        User user = new User("Paolo","Bianchi",50);
        Account account = premiumFactory.create(user);
        assertTrue(account instanceof PremiumAccount);
        assertEquals(user, account.getUser());
        assertEquals(0, account.getBalance());
    }
}
