package operation;

public class LoadInstruction extends Operation {

    private final int dest;
    private final int immediateValue;

    protected LoadInstruction(String input) {
        super(input);
        this.dest = toUnsignedInteger(4, 7);
        this.immediateValue = toSignedInteger(7, 16);
    }

    @Override
    public void doOperation() {
        this.incrementPC();

        System.out.println("LD R" + this.dest + " M[" + this.getPC() + " + #" + this.immediateValue + "]");
        System.out.println("R" + this.dest + " = M[" + this.getPC() + this.immediateValue + "]");

        this.increasePC(this.immediateValue);
    }
}
