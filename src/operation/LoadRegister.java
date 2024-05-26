package operation;

public class LoadRegister extends Operation {

    private final int base;
    private final int dest;
    private final int immediateValue;

    protected LoadRegister(String input) {
        super(input);
        this.base = toUnsignedInteger(4, 7);
        this.dest = toUnsignedInteger(7, 10);
        this.immediateValue = toSignedInteger(10, 16);
    }

    @Override
    public void doOperation() {
        this.incrementPC();

        System.out.println("LDR R" + this.dest + " M[R" + this.base + " + #" + this.immediateValue + "]");
        if (this.immediateValue < 0) {
            System.out.println("R" + this.dest + " = M[R" + this.base + " - " + -this.immediateValue + "]");
        } else {
            System.out.println("R" + this.dest + " = M[R" + this.base + " + " + this.immediateValue + "]");
        }
    }
}
