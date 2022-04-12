import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FileFindVisitor extends Visitor {
    private String filetype;
    private List<File> foundFiles = new ArrayList<>();

    // ".txt"�̂悤�Ɋg���q��.�t���Ŏw��
    public FileFindVisitor(String filetype) {
        this.filetype = filetype;
    }

    // ���������t�@�C���𓾂�
    public Iterable<File> getFoundFiles() {
        return foundFiles;
    }

    @Override
    public void visit(File file) {
        if (file.getName().endsWith(filetype)) {
            foundFiles.add(file);
        }
    }

    @Override
    public void visit(Directory directory) {
        for (Entry entry: directory) {
            entry.accept(this);
        }
    }
}
