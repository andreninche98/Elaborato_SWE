package ContoBancario;
import ContoBancario.Account;

public class BankTransferPay implements PaymentStrategy{ // implementazione della strategy per il pagamento con bonifico bancario
    public boolean evaluate(Account account, int amount){ //implementazione metodo evaluate()
        int cost = 1; //costo commissioni
        System.out.println(" Pagamento attraverso bonifico per una spesa di " + amount + " €, costo commissioni : " + cost + " € ");
        try{
            Thread.sleep(5000);
        } catch (InterruptedException ex){
            System.out.println(" Errore! ");
            return false;
        }
        account.checkDecrement(amount);
        account.setState(account.isNegative);
           if(account.checkObservers()){
               account.decrement(amount + cost);
               return true;
           } else {
               System.out.println(" Operazione Interrotta ");
               return false;
           }
    }
}
