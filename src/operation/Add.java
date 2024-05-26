package operation;

public class Add extends Operation {

    private final int dest;
    private final int src;
    private final int srcTwo;
    private final boolean isImmediateValue;

    protected Add(final String input) {
        super(input);
        this.dest = toUnsignedInteger(4, 7);
        this.src = toUnsignedInteger(7, 10);
        this.isImmediateValue = isOne(10);
        this.srcTwo = this.isImmediateValue ? toSignedInteger(11, 16) : toUnsignedInteger(13, 16);
    }

    @Override
    public void doOperation() {
        this.incrementPC();

        if (this.isImmediateValue) {
            System.out.println("ADD R" + this.dest + " R" + this.src + " #" + this.srcTwo);
            if (this.srcTwo < 0) {
                System.out.println("R" + this.dest + " = R" + this.src + " - " + -this.srcTwo);
            } else {
                System.out.println("R" + this.dest + " = R" + this.src + " + " + this.srcTwo);
            }
        } else {
            System.out.println("ADD R" + this.dest + " R" + this.src + " R" + this.srcTwo);
            System.out.println("R" + this.dest + " = R" + this.src + " + R" + this.srcTwo);
        }
    }
}
