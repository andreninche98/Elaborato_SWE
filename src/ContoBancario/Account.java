package ContoBancario;

public abstract class Account extends Subject{ //classe astratta Account -> ConcreteSubject
    protected User user;
    protected PaymentStrategy strategy;
    protected int balance;
    protected boolean isNegative;

    public Account(User user, int balance, boolean isNegative) { //costruttore
        this.user = user;
        this.balance = balance;
        this.isNegative = isNegative;
    }

    public void deposit (int amount){ //metodo per versamento
        System.out.println("Versamento effettuato per un totale di " + amount + " € ");
        balance += amount;
        if(balance >= 0){
            isNegative = false;
        }
    }
    //metodi astratti utili per le sottoclassi
    public abstract void setState ( boolean isBalanceNegative);

    public abstract void checkDecrement ( int amount);

    public int getBalance(){
        return balance;
    }
    public boolean isNegative(){
        return isNegative;
    }

    public void decrement (int amount){ //metodo per controllare che un pagamento può essere effettutato
        try{
            System.out.println("Attendere prego....");
            Thread.sleep(2000);
        } catch(InterruptedException e){
            System.out.println("Operazione non eseguita. Errore ");
            e.printStackTrace();
        }
        System.out.println("Sto valutando una spesa di "+ amount + " € ");
        balance -= amount;
        System.out.println("Pagamento effettutato con successo ");
    }
    public void setStrategy (PaymentStrategy strategy){ //metodo per decidere il metodo di pagamento
        this.strategy = strategy;
    }
    public void pay (int amount){ //metodo per pagamento
        strategy.evaluate(this,amount);
    }
    public User getUser(){
        return user;
    }
}

