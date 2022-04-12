public abstract class Support {
    private String name;    // ���̃g���u�������҂̖��O
    private Support next;   // ���炢�񂵂̐�

    public Support(String name) {
        this.name = name;
        this.next = null;
    }

    // ���炢�񂵂̐��ݒ肷��
    public Support setNext(Support next) {
        this.next = next;
        return next;
    }

    // �g���u�������̎菇���߂�
    public void support(Trouble trouble) {
        for (Support obj = this; true; obj = obj.next) {
            if (obj.resolve(trouble)) {
                obj.done(trouble);
                break;
            } else if (obj.next == null) {
                obj.fail(trouble);
                break;
            }
        }
    }

    @Override
    public String toString() {
        return "[" + name + "]";
    }

    // �������悤�Ƃ���
    protected abstract boolean resolve(Trouble trouble);

    // ��������
    protected void done(Trouble trouble) {
        System.out.println(trouble + " is resolved by " + this + ".");
    }

    // �������Ȃ�����
    protected void fail(Trouble trouble) {
        System.out.println(trouble + " cannot be resolved.");
    }
}

