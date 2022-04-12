import java.util.*;

class Main {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("D", "B", "C", "E", "A");

        // �����������ŏ�������
        list.sort((a, b) -> a.compareTo(b));
        System.out.println(list);

        // �����������ő傫����
        list.sort((a, b) -> b.compareTo(a));
        System.out.println(list);
    }
}
