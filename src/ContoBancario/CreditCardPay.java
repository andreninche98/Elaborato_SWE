package ContoBancario;
import ContoBancario.Account;

public class CreditCardPay implements PaymentStrategy { // implementazione della strategy per il pagamento con carta di credito
    public boolean evaluate(Account account, int amount){ //implementazione metodo evaluate()
        System.out.println(" Pagamento con carta di credito per una spesa di "+ amount + " €, costo commissioni: 0€ ");
        try{
            Thread.sleep(5000);
        } catch(InterruptedException ex){
            System.out.println(" Errore! ");
            return false;
        }
        account.checkDecrement(amount);
        account.setState(account.isNegative);
        if(account.checkObservers()){
            account.decrement(amount);
            return true;
        } else {
            System.out.println(" Operazione interrotta. ");
            return false;
        }
    }
}
