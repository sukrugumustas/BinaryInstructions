package operation;

public class StoreInstruction extends Operation {

    private final int src;
    private final int immediateValue;

    protected StoreInstruction(final String input) {
        super(input);
        this.src = toUnsignedInteger(4, 7);
        this.immediateValue = toSignedInteger(7, 16);
    }

    @Override
    public void doOperation() {
        this.incrementPC();

        System.out.println("ST R" + this.src + " M[" + this.getPC() + " + #" + this.immediateValue + "]");
        System.out.println("M[" + this.getPC() + this.immediateValue + "] = " + "R" + this.src);

        this.increasePC(this.immediateValue);
    }
}
