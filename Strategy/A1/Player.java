public class Player {
    private String name;
    private Strategy strategy;
    private int wincount;
    private int losecount;
    private int gamecount;

    // ���O�Ɛ헪�������ăv���C���[�����
    public Player(String name, Strategy strategy) {
        this.name = name;
        this.strategy = strategy;
    }

    // �헪�ɂ����������𗧂ĂĎ��̎�����߂�
    public Hand nextHand() {
        return strategy.nextHand();
    }

    // ������
    public void win() {
        strategy.study(true);
        wincount++;
        gamecount++;
    }

    // ������
    public void lose() {
        strategy.study(false);
        losecount++;
        gamecount++;
    }

    // ��������
    public void even() {
        gamecount++;
    }

    @Override
    public String toString() {
        return "["
            + name + ":"
            + gamecount + " games, "
            + wincount + " win, "
            + losecount + " lose"
            + "]";
    }
}
