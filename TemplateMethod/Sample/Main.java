public class Main {
    public static void main(String[] args) {
        // 'H'��������CharDisplay�̃C���X�^���X��1���
        AbstractDisplay d1 = new CharDisplay('H');

        // "Hello, world."��������StringDisplay�̃C���X�^���X��1���
        AbstractDisplay d2 = new StringDisplay("Hello, world.");

        // d1,d2�Ƃ��A���ׂē���AbstractDisplay�̃T�u�N���X�̃C���X�^���X������
        // �p������display���\�b�h���Ăяo�����Ƃ��ł���
        // ���ۂ̓���͌X�̃N���XCharDisplay��StringDisplay�Œ�܂�
        d1.display();
        d2.display();
    }
}
