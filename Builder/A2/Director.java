public class Director {
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public void construct() {
        builder.makeTitle("Bye");
        builder.makeString("�C�y�ȕʂ�̂�������");
        builder.makeItems(new String[]{
            "See you.",
            "Take care.",
            "Bye."
        });
        builder.makeString("���J�ȕʂ�̂�������");
        builder.makeItems(new String[]{
            "It was nice to see you.",
            "I'm looking forward to seeing you again.",
        });
        builder.close();
    }
}
