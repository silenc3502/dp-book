import java.util.ArrayList;
import java.util.List;

public class MultiStringDisplay extends Display {
    // �\��������̊i�[�ꏊ
    private List<String> body = new ArrayList<>();
    // �\��������̍ő啶����
    private int columns = 0;

    // ������ǉ�
    public void add(String msg) {
        body.add(msg);
        if (columns < msg.length()) {
            // �ő啶�������X�V
            columns = msg.length();
        }
        updatePadding();
    }

    @Override
    public int getColumns() {
        return columns;
    }

    @Override
    public int getRows() {
        return body.size();
    }

    @Override
    public String getRowText(int row) {
        return body.get(row);
    }

    // �\��������̉E�[�ɋl�߂�󔒂�K�v�ɉ����đ��₷
    private void updatePadding() {
        for (int row = 0; row < body.size(); row++) {
            String line = body.get(row);
            int padding = columns - line.length();
            if (padding > 0) {
                body.set(row, line + spaces(padding));
            }
        }
    }

    // count�̋󔒂����
    private String spaces(int count) {
        StringBuilder spaces = new StringBuilder();
        for (int i = 0; i < count; i++) {
            spaces.append(' ');
        }
        return spaces.toString();
    }
}
