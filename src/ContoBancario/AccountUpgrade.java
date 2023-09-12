package ContoBancario;

public class AccountUpgrade implements Upgrade { //implementazione metodo da standard a premium
    private int premiumCost; //costo attivazione

    public AccountUpgrade(int premiumCost) {
        this.premiumCost = premiumCost;
    }
    //override metodo dell'interfaccia upgrade
    @Override
    public Account upgradeToPremium(Account account){
        User user = account.getUser();
        int balance = account.getBalance();
        boolean isNegative = account.isNegative();
        System.out.println(" Complimenti, passaggio ad account Premium avvenuto con successo! ");
        balance -= premiumCost;
        return new PremiumAccount(user,balance,isNegative,premiumCost);
    }
}
