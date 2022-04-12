import java.util.HashMap;
import java.util.Map;

public class BigCharFactory {
    // ���łɍ����BigChar�̃C���X�^���X���Ǘ�
    private Map<String,BigChar> pool = new HashMap<>();
    // Singleton�p�^�[��
    private static BigCharFactory singleton = new BigCharFactory();

    // �R���X�g���N�^
    private BigCharFactory() {
    }

    // �B��̃C���X�^���X�𓾂�
    public static BigCharFactory getInstance() {
        return singleton;
    }

    // BigChar�̃C���X�^���X����(���L)
    public synchronized BigChar getBigChar(char charname) {
        BigChar bc = pool.get(String.valueOf(charname));
        if (bc == null) {
            // ������BigChar�̃C���X�^���X�𐶐�
            bc = new BigChar(charname);
            pool.put(String.valueOf(charname), bc);
        }
        return bc;
    }
}
