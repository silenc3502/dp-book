public class FullBorder extends Border {
    public FullBorder(Display display) {
        super(display);
    }

    @Override
    public int getColumns() {
        // �������͒��g�̗����ɍ��E�̏��蕶����������������
        return 1 + display.getColumns() + 1;
    }

    @Override
    public int getRows() {
        // �s���͒��g�̍s���ɏ㉺�̏��蕶����������������
        return 1 + display.getRows() + 1;
    }

    @Override
    public String getRowText(int row) {
        if (row == 0) {                                             // ��[�̘g
            return "+" + makeLine('-', display.getColumns()) + "+";
        } else if (row == display.getRows() + 1) {                  // ���[�̘g
            return "+" + makeLine('-', display.getColumns()) + "+";
        } else {                                                    // ����ȊO
            return "|" + display.getRowText(row - 1) + "|";
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
