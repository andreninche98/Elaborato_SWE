package ContoBancario;
import ContoBancario.Account;

public interface PaymentStrategy { //interfaccia utilizzata per impostare il metodo di pagamento
    public boolean evaluate(Account account, int amount);
}
