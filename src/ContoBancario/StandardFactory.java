package ContoBancario;
import ContoBancario.Account;
import ContoBancario.StandardAccount;

public class StandardFactory implements AccountFactory{ //implementazione della factory per gli account standard
    public Account create(User identity){
        System.out.println(" Grazie! Un nuovo account Standard è stato creato! ");
        return new StandardAccount(identity, 0, false);
    }
}
