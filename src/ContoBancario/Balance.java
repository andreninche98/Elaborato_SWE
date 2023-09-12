package ContoBancario;

public class Balance extends Observer { //classe balance sottoclasse di Observer-> ConcreteObserver
    public Balance(Account anAccount){ //costruttore
        subject = anAccount;
        name = "Saldo";
        valid = true;
        subject.attach(this);
    }
    //override metodo update() della classe base
    @Override
    public void update(){
        if(subject.isNegative()){
            valid = false;
        } else {
            valid = true;
        }
    }
}
