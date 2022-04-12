public class SpecialSupport extends Support {
    private int number; // ‚±‚Ì”Ô†‚¾‚¯‰ğŒˆ‚Å‚«‚é

    public SpecialSupport(String name, int number) {
        super(name);
        this.number = number;
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        if (trouble.getNumber() == number) {
            return true;
        } else {
            return false;
        }
    }
}
