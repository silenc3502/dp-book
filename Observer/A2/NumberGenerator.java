import java.util.ArrayList;
import java.util.List;

public abstract class NumberGenerator {
    // �ێ����Ă���Observer����
    private List<Observer> observers = new ArrayList<>();

    // Observer��ǉ�����
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    // Observer���폜����
    public void deleteObserver(Observer observer) {
        observers.remove(observer);
    }

    // Observer�֒ʒm����
    public void notifyObservers() {
        for (Observer o: observers) {
            o.update(this);
        }
    }

    // �����擾����
    public abstract int getNumber();

    // ���𐶐�����
    public abstract void execute();
}
