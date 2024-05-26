package operation;

public class StoreRegister extends Operation {

    private final int dest;
    private final int base;
    private final int immediateValue;

    protected StoreRegister(String input) {
        super(input);
        this.dest = toUnsignedInteger(4, 7);
        this.base = toUnsignedInteger(7, 10);
        this.immediateValue = toSignedInteger(10, 16);
    }

    @Override
    public void doOperation() {
        this.incrementPC();

        System.out.println("STR R" + this.dest + " M[R" + this.base + " + #" + this.immediateValue + "]");
        if (this.immediateValue < 0) {
            System.out.println("M[R" + this.base + " - " + -this.immediateValue + "] = R" + this.dest);
        } else {
            System.out.println("M[R" + this.base + " + " + this.immediateValue + "] = R" + this.dest);
        }
    }
}
