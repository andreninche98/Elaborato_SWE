package ContoBancario;
import ContoBancario.Account;
import ContoBancario.PremiumAccount;
import ContoBancario.User;

public class PremiumFactory implements AccountFactory { //implementazione della factory per gli account premium
    public Account create (User identity){
        System.out.println(" Grazie! Un nuovo account Premium è stato creato! ");
        return new PremiumAccount(identity, 0, false, 10);
    }
}
