package ContoBancario;
import ContoBancario.Account;

public class PremiumAccount extends Account{ //sottoclasse di Account in versione premium
    private int premiumCost; //costo di attivazione

    public PremiumAccount(User identity, int balance, boolean isNegative, int premiumCost){
        super(identity,balance,isNegative);
        this.premiumCost = premiumCost;
    }
    //override dei metodi della classe base account
    @Override
    public void setState( boolean isBalanceNegative){
        isNegative = isBalanceNegative;
        notifyOservers();
    }
    @Override
    public void checkDecrement(int amount){
        if(balance < -100){
            isNegative = true;
        }
    }
}
