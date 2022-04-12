public enum Hand {
    // ����񂯂�̎��\��3��enum�萔
    ROCK("�O�[", 0),
    SCISSORS("�`���L", 1),
    PAPER("�p�[", 2);

    // enum�����t�B�[���h
    private String name; // ����񂯂�̎�̖��O
    private int handvalue; // ����񂯂�̎�̒l

    // ��̒l����萔�𓾂邽�߂̔z��
    private static Hand[] hands = {
        ROCK, SCISSORS, PAPER
    };

    // �R���X�g���N�^
    private Hand(String name, int handvalue) {
        this.name = name;
        this.handvalue = handvalue;
    }

    // ��̒l����enum�萔�𓾂�
    public static Hand getHand(int handvalue) {
        return hands[handvalue];
    }

    // this��h��苭���Ƃ�true
    public boolean isStrongerThan(Hand h) {
        return fight(h) == 1;
    }

    // this��h���ア�Ƃ�true
    public boolean isWeakerThan(Hand h) {
        return fight(h) == -1;
    }

    // ����������0, this�̏����Ȃ�1, h�̏����Ȃ�-1
    private int fight(Hand h) {
        if (this == h) {
            return 0;
        } else if ((this.handvalue + 1) % 3 == h.handvalue) {
            return 1;
        } else {
            return -1;
        }
    }

    // ����񂯂�́u��v�̕�����\��
    @Override
    public String toString() {
        return name;
    }
}
