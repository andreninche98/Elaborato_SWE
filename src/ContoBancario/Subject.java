package ContoBancario;
import ContoBancario.Observer;
import java.util.ArrayList;

public abstract class Subject { //classe astratta
    private ArrayList<Observer> observers; //lista di subjects
    public Subject(){
        observers = new ArrayList<Observer>();
    }
    //metodi per gli observers
    public void attach(Observer ob){
        observers.add(ob);
    }
    public void detach(Observer ob){
        observers.remove(ob);
    }
    public boolean checkObservers(){
        for (int i=0; i < observers.size(); i++){
            if(!observers.get(i).valid){
                System.out.println(observers.get(i).name + " ha notato un problema ");
                return false;
            }
        }
        return true;
    }
    public void notifyOservers(){
        for (int i=0; i < observers.size(); i++){
            observers.get(i).update();
        }
    }
}
