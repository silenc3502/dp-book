import java.util.ArrayList;
import java.util.List;

public abstract class NumberGenerator {
    // •Û‚µ‚Ä‚¢‚éObserver‚½‚¿
    private List<Observer> observers = new ArrayList<>();

    // Observer‚ğ’Ç‰Á‚·‚é
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    // Observer‚ğíœ‚·‚é
    public void deleteObserver(Observer observer) {
        observers.remove(observer);
    }

    // Observer‚Ö’Ê’m‚·‚é
    public void notifyObservers() {
        for (Observer o: observers) {
            o.update(this);
        }
    }

    // ”‚ğæ“¾‚·‚é
    public abstract int getNumber();

    // ”‚ğ¶¬‚·‚é
    public abstract void execute();
}
