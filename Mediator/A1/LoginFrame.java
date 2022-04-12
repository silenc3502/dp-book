import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends Frame implements ActionListener, Mediator {
    private ColleagueCheckbox checkGuest;
    private ColleagueCheckbox checkLogin;
    private ColleagueTextField textUser;
    private ColleagueTextField textPass;
    private ColleagueButton buttonOk;
    private ColleagueButton buttonCancel;

    // Colleague�����𐶐����A�z�u��ɕ\������
    public LoginFrame(String title) {
        super(title);

        // �w�i�F��ݒ肷��
        setBackground(Color.lightGray);

        // ���C�A�E�g�}�l�[�W�����g����4�~2�̃O���b�h�����
        setLayout(new GridLayout(4, 2));

        // Colleague�����𐶐�����
        createColleagues();

        // �z�u����
        add(checkGuest);
        add(checkLogin);
        add(new Label("Username:"));
        add(textUser);
        add(new Label("Password:"));
        add(textPass);
        add(buttonOk);
        add(buttonCancel);

        // �L��/�����̏����w�������
        colleagueChanged();

        // �\������
        pack();
        setVisible(true);
    }

    // Colleague�����𐶐�����
    @Override
    public void createColleagues() {
        // CheckBox
        CheckboxGroup g = new CheckboxGroup();
        checkGuest = new ColleagueCheckbox("Guest", g, true);
        checkLogin = new ColleagueCheckbox("Login", g, false);

        // TextField
        textUser = new ColleagueTextField("", 10);
        textPass = new ColleagueTextField("", 10);
        textPass.setEchoChar('*');

        // Button
        buttonOk = new ColleagueButton("OK");
        buttonCancel = new ColleagueButton("Cancel");

        // Mediator��ݒ肷��
        checkGuest.setMediator(this);
        checkLogin.setMediator(this);
        textUser.setMediator(this);
        textPass.setMediator(this);
        buttonOk.setMediator(this);
        buttonCancel.setMediator(this);

        // Listener�̃Z�b�g
        checkGuest.addItemListener(checkGuest);
        checkLogin.addItemListener(checkLogin);
        textUser.addTextListener(textUser);
        textPass.addTextListener(textPass);
        buttonOk.addActionListener(this);
        buttonCancel.addActionListener(this);
    }

    // Colleage�̏�Ԃ��ω������Ƃ��ɌĂ΂��
    @Override
    public void colleagueChanged() {
        if (checkGuest.getState()) {
            // �Q�X�g���O�C��
            textUser.setColleagueEnabled(false);
            textPass.setColleagueEnabled(false);
            buttonOk.setColleagueEnabled(true);
        } else {
            // ���[�U���O�C��
            textUser.setColleagueEnabled(true);
            userpassChanged();
        }
    }

    // textUser�܂���textPass�̕ύX��������
    // �eColleage�̗L��/�����𔻒肷��
    private void userpassChanged() {
        if (textUser.getText().length() > 0) {
            textPass.setColleagueEnabled(true);
            if (textUser.getText().length() >= 4 && textPass.getText().length() >= 4) {
                buttonOk.setColleagueEnabled(true);
            } else {
                buttonOk.setColleagueEnabled(false);
            }
        } else {
            textPass.setColleagueEnabled(false);
            buttonOk.setColleagueEnabled(false);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.toString());
        System.exit(0);
    }
}
