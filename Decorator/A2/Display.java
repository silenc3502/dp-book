public abstract class Display {
    public abstract int getColumns();           // ���̕������𓾂�
    public abstract int getRows();              // �c�̍s���𓾂�
    public abstract String getRowText(int row); // row�s�ڂ̕�����𓾂�

    // ���ׂĂ̍s��\������
    public void show() {
        for (int i = 0; i < getRows(); i++) {
            System.out.println(getRowText(i));
        }
    }
}
