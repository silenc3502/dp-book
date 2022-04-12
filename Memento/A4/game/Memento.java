package game;

import java.io.*;
import java.nio.file.*;
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

    // �t�@�C���ɕۑ�
    public static boolean saveToFile(String filename, Memento memento) {
        StringBuilder sb = new StringBuilder();

        // ������
        sb.append(String.format("%d", memento.money));
        sb.append("\n");

        // �t���[�c
        for (String f: memento.getFruits()) {
            sb.append(f);
            sb.append("\n");
        }

        // ��������
        try {
            Files.writeString(Path.of(filename), sb,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING,
                    StandardOpenOption.WRITE);
        } catch (IOException e) {
            System.out.println(e.toString());
            return false;
        }
        return true;
    }

    // �t�@�C�����琶��
    public static Memento loadFromFile(String filename) {
        try {
            // �ǂݍ���
            List<String> lines = Files.readAllLines(Path.of(filename));
            if (lines.size() == 0) {
                System.out.println("Empty file");
                return null;
            }

            // ������
            int money = 0;
            try {
                money = Integer.parseInt(lines.get(0));
            } catch (NumberFormatException e) {
                System.out.println("Format error: " + e);
                return null;
            }

            // ����
            Memento memento = new Memento(money);

            // �t���[�c
            for (int i = 1; i < lines.size(); i++) {
                memento.addFruit(lines.get(i));
            }
            return memento;
        } catch (IOException e) {
            System.out.println(e.toString());
            return null;
        }
    }
}
