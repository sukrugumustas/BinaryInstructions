package operation;

public class Branch extends Operation {

    private final int immediateValue;

    Branch(String input) {
        super(input);
        this.immediateValue = toSignedInteger(7, 16);
    }

    @Override
    public void doOperation() {
        this.incrementPC();

        System.out.println("BR #" + this.immediateValue);
        System.out.println("PC = " + this.getPC() + this.immediateValue);

        this.increasePC(this.immediateValue);
    }
}
