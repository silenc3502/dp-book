public abstract class Entry {
    // ���O�𓾂�
    public abstract String getName();

    // �T�C�Y�𓾂�
    public abstract int getSize();

    // �ꗗ��\������
    public void printList() {
        printList("");
    }

    // prefix��O�ɂ��Ĉꗗ��\������
    protected abstract void printList(String prefix);

    // ������\��
    @Override
    public String toString() {
        return getName() + " (" + getSize() + ")";
    }
}
