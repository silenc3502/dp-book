package game;

import java.util.ArrayList;
import java.util.List;

public class Memento {
    private int money;            // ������
    private List<String> fruits;  // �t���[�c

    // �������𓾂�(narrow interface)
    public int getMoney() {
        return money;
    }

    // �R���X�g���N�^(wide interface)
    Memento(int money) {
        this.money = money;
        this.fruits = new ArrayList<>();
    }

    // �t���[�c��ǉ�����(wide interface)
    void addFruit(String fruit) {
        fruits.add(fruit);
    }

    // �t���[�c�𓾂�(wide interface)
    List<String> getFruits() {
         return new ArrayList<>(fruits);
    }
}
