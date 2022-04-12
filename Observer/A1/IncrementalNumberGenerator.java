public class IncrementalNumberGenerator extends NumberGenerator {
    private int number; // Œ»İ‚Ì”
    private int end;    // I—¹’l(‚±‚Ì’l‚ğŠÜ‚Ü‚È‚¢)
    private int inc;    // ‘‰Á•ª

    public IncrementalNumberGenerator(int start, int end, int inc) {
        this.number = start;
        this.end = end;
        this.inc = inc;
    }

    // ”‚ğæ“¾‚·‚é
    @Override
    public int getNumber() {
        return number;
    }

    // ”‚ğ¶¬‚·‚é
    @Override
    public void execute() {
        while (number < end) {
            notifyObservers();
            number += inc;
        }
    }
}
