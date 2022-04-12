public abstract class AbstractDisplay {
    // open, print, close�̓T�u�N���X�Ɏ������܂����钊�ۃ��\�b�h
    public abstract void open();
    public abstract void print();
    public abstract void close();

    // display��AbstractDisplay�Ŏ������Ă郁�\�b�h
    public final void display() {
        open();
        for (int i = 0; i < 5; i++) {
            print();
        }
        close();
    }
}
