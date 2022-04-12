import java.awt.Color;
import java.awt.TextField;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

public class ColleagueTextField extends TextField implements TextListener, Colleague {
    private Mediator mediator;

    public ColleagueTextField(String text, int columns) {
        super(text, columns);
    }

    // Mediator��ݒ肷��
    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    // Mediator����L��/�������w�������
    @Override
    public void setColleagueEnabled(boolean enabled) {
        setEnabled(enabled);
        // �L��/�����ɍ��킹�Ĕw�i�F��ύX����
        setBackground(enabled ? Color.white : Color.lightGray);
    }

    @Override
    public void textValueChanged(TextEvent e) {
        // �����񂪕ω�������Mediator�ɒʒm����
        mediator.colleagueChanged();
    }
}
