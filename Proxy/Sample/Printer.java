public class Printer implements Printable {
    private String name; // ���O

    // �R���X�g���N�^
    public Printer() {
        heavyJob("Printer�̃C���X�^���X�𐶐���");
    }

    // �R���X�g���N�^�i���O�w��j
    public Printer(String name) {
        this.name = name;
        heavyJob("Printer�̃C���X�^���X(" + name + ")�𐶐���");
    }

    // ���O�̐ݒ�
    @Override
    public void setPrinterName(String name) {
        this.name = name;
    }

    // ���O�̎擾
    @Override
    public String getPrinterName() {
        return name;
    }

    // ���O�t���ŕ\��
    @Override
    public void print(String string) {
        System.out.println("=== " + name + " ===");
        System.out.println(string);
    }

    // �d�����(�̂���)
    private void heavyJob(String msg) {
        System.out.print(msg);
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            System.out.print(".");
        }
        System.out.println("�����B");
    }
}
