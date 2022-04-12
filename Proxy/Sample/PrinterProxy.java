public class PrinterProxy implements Printable {
    private String name;            // ���O
    private Printer real;           // �u�{�l�v

    // �R���X�g���N�^
    public PrinterProxy() {
        this.name = "No Name";
        this.real = null;
    }

    // �R���X�g���N�^�i���O�w��j
    public PrinterProxy(String name) {
        this.name = name;
        this.real = null;
    }

    // ���O�̐ݒ�
    @Override
    public synchronized void setPrinterName(String name) {
        if (real != null) {
            // �u�{�l�v�ɂ��ݒ肷��
            real.setPrinterName(name);
        }
        this.name = name;
    }

    // ���O�̎擾
    @Override
    public String getPrinterName() {
        return name;
    }

    // �\��
    @Override
    public void print(String string) {
        realize();
        real.print(string);
    }

    // �u�{�l�v�𐶐�
    private synchronized void realize() {
        if (real == null) {
            real = new Printer(name);
        }
    }
}
