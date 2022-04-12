public class BigString {
    // �u�傫�ȕ����v�̔z��
    private BigChar[] bigchars;

    // �R���X�g���N�^�i�����Ȃ��A���L����j
    public BigString(String string) {
        initShared(string);
    }

    // �R���X�g���N�^�i�����ŋ��L���邩�ǂ������w�肷��j
    public BigString(String string, boolean shared) {
        if (shared) {
            initShared(string);
        } else {
            initUnshared(string);
        }
    }

    // ���L���ď�����
    private void initShared(String string) {
        BigCharFactory factory = BigCharFactory.getInstance();
        bigchars = new BigChar[string.length()];
        for (int i = 0; i < bigchars.length; i++) {
            bigchars[i] = factory.getBigChar(string.charAt(i));
        }
    }

    // ���L����������
    private void initUnshared(String string) {
        bigchars = new BigChar[string.length()];
        for (int i = 0; i < bigchars.length; i++) {
            bigchars[i] = new BigChar(string.charAt(i));
        }
    }

    // �\��
    public void print() {
        for (BigChar bc: bigchars) {
            bc.print();
        }
    }
}
