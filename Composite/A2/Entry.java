public abstract class Entry {
    private Entry parent;

    // �e��ݒ肷��
    protected void setParent(Entry parent) {
        this.parent = parent;
    }

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

    // �t���p�X�𓾂�
    public String getFullName() {
        StringBuilder fullname = new StringBuilder();
        Entry entry = this;
        do {
            fullname.insert(0, entry.getName());
            fullname.insert(0, "/");
            entry = entry.parent;
        } while (entry != null);
        return fullname.toString();
    }
}
