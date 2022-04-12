�c

class MyFileVisitor extends SimpleFileVisitor<Path> {
    �c preVisitDirectory(Path dir, �c) throws IOException {
        System.out.println("dir: " + dir);
        return FileVisitResult.CONTINUE;
    }

    �c visitFile(Path file, �c) throws IOException {
        System.out.println("file: " + file);
        return FileVisitResult.CONTINUE;
    }
}

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Main dirname");
            System.out.println("Example: java Main .");
            System.exit(0);
        }

        String dirname = args[0];

        try {
            MyFileVisitor visitor = new MyFileVisitor();
            Path root = Path.of(dirname);
            Files.walkFileTree(root, visitor);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

