import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class BigChar {
    // �����̖��O
    private char charname;
    // �傫�ȕ�����\�����镶����('#' '.' '\n'�̗�)
    private String fontdata;

    // �R���X�g���N�^
    public BigChar(char charname) {
        this.charname = charname;
        try {
            String filename = "big" + charname + ".txt";
            StringBuilder sb = new StringBuilder();
            for (String line: Files.readAllLines(Path.of(filename))) {
                sb.append(line);
                sb.append("\n");
            }
            this.fontdata = sb.toString();
        } catch (IOException e) {
            this.fontdata = charname + "?";
        }
    }

    // �傫�ȕ�����\������
    public void print() {
        System.out.print(fontdata);
    }
}
