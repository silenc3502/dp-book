package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Gamer {
    // ������
    private int money;
    // �t���[�c
    private List<String> fruits = new ArrayList<>();
    // ����������
    private Random random = new Random();

    // �t���[�c���̕\
    private static String[] fruitsName = {
        "�����S", "�Ԃǂ�", "�o�i�i", "�݂���",
    };

    // �R���X�g���N�^
    public Gamer(int money) {
        this.money = money;
    }

    // ���݂̏������𓾂�
    public int getMoney() {
        return money;
    }

    // �q����c�Q�[���̐i�s
    public void bet() {
        // �T�C�R����U��
        int dice = random.nextInt(6) + 1;
        if (dice == 1) {
            // 1�̖ځc��������������
            money += 100;
            System.out.println("�������������܂����B");
        } else if (dice == 2) {
            // 2�̖ځc�������������ɂȂ�
            money /= 2;
            System.out.println("�������������ɂȂ�܂����B");
        } else if (dice == 6) {
            // 6�̖ځc�t���[�c�����炤
            String f = getFruit();
            System.out.println("�t���[�c(" + f + ")�����炢�܂����B");
            fruits.add(f);
        } else {
            // ����ȊO�c�����N���Ȃ�
            System.out.println("�����N����܂���ł����B");
        }
    }

    // �X�i�b�v�V���b�g���Ƃ�
    public Memento createMemento() {
        Memento m = new Memento(money);
        for (String f: fruits) {
            // �t���[�c�͂����������̂����ۑ�
            if (f.startsWith("��������")) {
                m.addFruit(f);
            }
        }
        return m;
    }

    // �A���h�D���s��
    public void restoreMemento(Memento memento) {
        this.money = memento.getMoney();
        this.fruits = memento.getFruits();
    }

    @Override
    public String toString() {
        return "[money = " + money + ", fruits = " + fruits + "]";
    }

    // �t���[�c��1����
    private String getFruit() {
        String f = fruitsName[random.nextInt(fruitsName.length)];
        if (random.nextBoolean()) {
            return "��������" + f;
        } else {
            return f;
        }
    }
}
