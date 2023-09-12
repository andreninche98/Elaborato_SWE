package ContoBancario;
import ContoBancario.Account;
import ContoBancario.User;

public interface AccountFactory { //interfaccia factory per creare gli account passandoci user
    public Account create(User identity);
}
