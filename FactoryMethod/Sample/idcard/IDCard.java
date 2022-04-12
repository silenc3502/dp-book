package idcard;

import framework.Product;

public class IDCard extends Product {
    private String owner;

    IDCard(String owner) {
        System.out.println(owner + "�̃J�[�h�����܂��B");
        this.owner = owner;
    }

    @Override
    public void use() {
        System.out.println(this + "���g���܂��B");
    }

    @Override
    public String toString() {
        return "[IDCard:" + owner + "]";
    }

    public String getOwner() {
        return owner;
    }
}
