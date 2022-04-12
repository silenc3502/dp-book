public class UrgentState implements State {
    private static UrgentState singleton = new UrgentState();

    private UrgentState() {                                // �R���X�g���N�^��private
    }

    public static State getInstance() {                 // �B��̃C���X�^���X�𓾂�
        return singleton;
    }

    @Override
    public void doClock(Context context, int hour) {    // �����ݒ�
        // �����ݒ�ł͉������������Ȃ�
    }

    @Override
    public void doUse(Context context) {                // ���Ɏg�p
        context.callSecurityCenter("���:��펞�̋��Ɏg�p�I");
    }

    @Override
    public void doAlarm(Context context) {              // ���x��
        context.callSecurityCenter("���x��(��펞)");
    }

    @Override
    public void doPhone(Context context) {              // �ʏ�ʘb
        context.callSecurityCenter("�ʏ�̒ʘb(��펞)");
    }

    @Override
    public String toString() {                          // ������\��
        return "[��펞]";
    }
}
