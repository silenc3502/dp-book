public class UpDownBorder extends Border {
    private char borderChar;  // ���蕶��

    // ���g�ƂȂ�Display�Ə��蕶�����w��
    public UpDownBorder(Display display, char ch) {
        super(display);
        this.borderChar = ch;
    }

    @Override
    public int getColumns() {
        // �������͒��g�̕������ɓ���
        return display.getColumns();
    }

    @Override
    public int getRows() {
        // �s���͒��g�̏㉺�ɏ��蕶����������������
        return 1 + display.getRows() + 1;
    }

    @Override
    public String getRowText(int row) {
        if (row == 0 || row == getRows() - 1) {
            // �ŏ�s�ƍŉ��s�͏��蕶�������̍s
            return makeLine(borderChar, getColumns());
        } else {
            // ���g�̍s�i�ŏ�s�̕������s�ԍ������炷�j
            return display.getRowText(row - 1);
        }
    }

    // ����ch��count�A������������������
    private String makeLine(char ch, int count) {
        StringBuilder line = new StringBuilder();
        for (int i = 0; i < count; i++) {
            line.append(ch);
        }
        return line.toString();
    }
}
