public class Director {
    private Builder builder;

    // �R���X�g���N�^
    public Director(Builder builder) {
        this.builder = builder;
    }

    // ��������郁�\�b�h
    public void construct() {
        builder.makeTitle("Greeting");
        builder.makeString("��ʓI�Ȃ�������");
        builder.makeItems(new String[]{
            "How are you?",
            "Hello.",
            "Hi.",
        });
        builder.makeString("���ԑтɉ�������������");
        builder.makeItems(new String[]{
            "Good morning.",
            "Good afternoon.",
            "Good evening.",
        });
        builder.close();
    }
}
