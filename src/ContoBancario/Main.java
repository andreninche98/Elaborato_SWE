package ContoBancario;

public class Main {
    public static void main(String[] args) {
        //imposto i metodi di pagamenti
        PaymentStrategy strategy1 = new CreditCardPay();
        PaymentStrategy strategy2 = new BankTransferPay();

        //creo un account standard e provo ad usarlo pagando con carta di credito
        User client1 = new User("Andrea", "Nincheri", 25);
        AccountFactory standardFactory = new StandardFactory();
        Account standardAccount = standardFactory.create(client1);
        standardAccount.setStrategy(strategy1);
        Observer balance = new Balance(standardAccount);
        standardAccount.attach(balance);
        System.out.println("Saldo Attuale: " + standardAccount.getBalance());
        standardAccount.pay(50);
        standardAccount.deposit(120);
        System.out.println("Saldo Attuale: " + standardAccount.getBalance());
        standardAccount.pay(50);
        System.out.println("Saldo Attaule: " + standardAccount.getBalance());

        //creo un account premium e provo ad usarlo pagando con bonifico bancario
        User client2 = new User("Federico", "Bigagli", 43);
        AccountFactory premiumFactory = new PremiumFactory();
        Account premiumAccount = premiumFactory.create(client2);
        premiumAccount.setStrategy(strategy2);
        Observer balance2 = new Balance(premiumAccount);
        premiumAccount.attach(balance2);
        premiumAccount.deposit(15000);
        System.out.println("Saldo Attuale: " + premiumAccount.getBalance());
        premiumAccount.pay(7640);
        System.out.println("Saldo Attaule: " + premiumAccount.getBalance());

        //prendo il primo account e da standard passo a premium
        //quindi adesso uso questo acccount premium pagando con carta di credito
        int premiumCost = 10;
        Upgrade accountUpgrade = new AccountUpgrade(premiumCost);
        Account upgradedAccount = accountUpgrade.upgradeToPremium(standardAccount);
        upgradedAccount.setStrategy(strategy1);
        upgradedAccount.attach(balance);
        System.out.println("Saldo Attuale: "+ upgradedAccount.getBalance());
        upgradedAccount.pay(100);
        System.out.println("Saldo Attuale: "+ upgradedAccount.getBalance());


        System.out.println("Grazie. A presto!");
    }
}