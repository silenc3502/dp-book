public class Trouble {
    private int number; // �g���u���ԍ�

    // �g���u���̐���
    public Trouble(int number) {
        this.number = number;
    }

    // �g���u���ԍ��𓾂�
    public int getNumber() {
        return number;
    }

    // �g���u���̕�����\��
    @Override
    public String toString() {
        return "[Trouble " + number + "]";
    }
}
