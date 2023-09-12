package ContoBancario;

public abstract class Observer { //classe astratta
    protected Account subject;
    protected String name;
    protected boolean valid;

    public abstract void update(); //metodo per le sottoclassi
}
