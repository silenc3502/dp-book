public class PrinterProxy implements Printable {
    private String name;            // ���O
    private Printable real;         // �u�{�l�v
    private String className;       // �u�{�l�v�̃N���X��

    // �R���X�g���N�^�i���O�ƃN���X���w��j
    public PrinterProxy(String name, String className) {
        this.name = name;
        this.real = null;
        this.className = className;
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
            try {
                real = (Printable)Class.forName(className).getDeclaredConstructor().newInstance();
                real.setPrinterName(name);
            } catch (ClassNotFoundException e) {
                System.out.println("�N���X " + className + " ��������܂���B");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
