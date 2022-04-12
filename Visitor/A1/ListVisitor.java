public class ListVisitor extends Visitor {
    // ���ݒ��ڂ��Ă���f�B���N�g����
    private String currentdir = "";

    // File�K�⎞
    @Override
    public void visit(File file) {
        System.out.println(currentdir + "/" + file);
    }

    // Directory�K�⎞
    @Override
    public void visit(Directory directory) {
        System.out.println(currentdir + "/" + directory);
        String savedir = currentdir;
        currentdir = currentdir + "/" + directory.getName();
        for (Entry entry: directory) {
            entry.accept(this);
        }
        currentdir = savedir;
    }
}
