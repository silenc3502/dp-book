public abstract class Entry implements Element {
    public abstract String getName(); // ���O�𓾂�
    public abstract int getSize();    // �T�C�Y�𓾂�

    // ������\��
    @Override
    public String toString() {
        return getName() + " (" + getSize() + ")";
    }
}

