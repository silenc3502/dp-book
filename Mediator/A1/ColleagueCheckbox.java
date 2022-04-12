import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ColleagueCheckbox extends Checkbox implements ItemListener, Colleague {
    private Mediator mediator;

    public ColleagueCheckbox(String caption, CheckboxGroup group, boolean state) {
        super(caption, group, state);
    }

    // Mediator‚ğİ’è‚·‚é
    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    // Mediator‚©‚ç—LŒø/–³Œø‚ªw¦‚³‚ê‚é
    @Override
    public void setColleagueEnabled(boolean enabled) {
        setEnabled(enabled);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        // ó‘Ô‚ª•Ï‰»‚µ‚½‚çMediator‚É’Ê’m‚·‚é
        mediator.colleagueChanged();
    }
}
