public class CharDisplay extends AbstractDisplay {
    private char ch; // �\�����ׂ�����

    // �R���X�g���N�^
    public CharDisplay(char ch) {
        this.ch = ch;
    }

    @Override
    public void open() {
        // �J�n������Ƃ���"<<"��\������
        System.out.print("<<");
    }

    @Override
    public void print() {
        // �t�B�[���h�ɕۑ����Ă�����������1��\������
        System.out.print(ch);
    }

    @Override
    public void close() {
        // �I��������Ƃ���">>"��\������
        System.out.println(">>");
    }
}
