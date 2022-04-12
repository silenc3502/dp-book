import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;

public class SafeFrame extends Frame implements Context {
    private TextField textClock = new TextField(60);        // ���ݎ����\��
    private TextArea textScreen = new TextArea(10, 60);     // �x���Z���^�[�o��
    private Button buttonUse = new Button("���Ɏg�p");      // ���Ɏg�p�{�^��
    private Button buttonAlarm = new Button("���x��");    // ���x���{�^��
    private Button buttonPhone = new Button("�ʏ�ʘb");    // �ʏ�ʘb�{�^��
    private Button buttonExit = new Button("�I��");         // �I���{�^��

    private State state = DayState.getInstance();           // ���݂̏��

    // �R���X�g���N�^
    public SafeFrame(String title) {
        super(title);
        setBackground(Color.lightGray);
        setLayout(new BorderLayout());
        // textClock��z�u
        add(textClock, BorderLayout.NORTH);
        textClock.setEditable(false);
        // textScreen��z�u
        add(textScreen, BorderLayout.CENTER);
        textScreen.setEditable(false);
        // �p�l���Ƀ{�^�����i�[
        Panel panel = new Panel();
        panel.add(buttonUse);
        panel.add(buttonAlarm);
        panel.add(buttonPhone);
        panel.add(buttonExit);
        // ���̃p�l����z�u
        add(panel, BorderLayout.SOUTH);

        // �{�^���������ꂽ�Ƃ��̃��X�i�[�������_���Őݒ�
        buttonUse.addActionListener(e -> state.doUse(this));
        buttonAlarm.addActionListener(e -> state.doAlarm(this));
        buttonPhone.addActionListener(e -> state.doPhone(this));
        buttonExit.addActionListener(e -> System.exit(0));

        // �\��
        pack();
        setVisible(true);
    }

    // �����̐ݒ�
    @Override
    public void setClock(int hour) {
        String clockstring = String.format("���ݎ�����%02d:00", hour);
        System.out.println(clockstring);
        textClock.setText(clockstring);
        state.doClock(this, hour);
    }

    // ��ԕω�
    @Override
    public void changeState(State state) {
        System.out.println(this.state + "����" + state + "�֏�Ԃ��ω����܂����B");
        this.state = state;
    }

    // �x���Z���^�[�x�����Ăяo��
    @Override
    public void callSecurityCenter(String msg) {
        textScreen.append("call! " + msg + "\n");
    }

    // �x���Z���^�[�L�^
    @Override
    public void recordLog(String msg) {
        textScreen.append("record ... " + msg + "\n");
    }
}
