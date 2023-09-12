package ContoBancario;
import ContoBancario.Account;

public class StandardAccount extends Account{ //sottoclasse di account versione standard
    public StandardAccount(User identity, int balance, boolean isNegative){
        super(identity,balance,isNegative);
    }
    //override metodi astratti della classe base
    @Override
    public void setState(boolean isBalanceNegative){
        isNegative = isBalanceNegative;
        notifyOservers();
    }
    @Override
    public void checkDecrement(int amount){
        if(balance - amount < 0){
            isNegative = true;
        }
    }
}
