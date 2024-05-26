package operation;

public abstract class Operation {

    private static int PC = 0;
    private static final int MEMORY = 4096;

    private final char[] input;

    protected Operation(final String input) {
        this.input = input.toCharArray();
        System.out.println("Current PC = " + PC);
    }

    boolean isOne(final int index) {
        return input[index] == '1';
    }

    public abstract void doOperation();

    int toSignedInteger(final int startIdx, final int endIdx) {
        final int result = toUnsignedInteger(startIdx + 1, endIdx);
        if (input[startIdx] == '1') {
            return -(~result + 1);
        }
        return result;
    }

    int toUnsignedInteger(final int startIdx, final int endIdx) {
        int result = 0;
        for (int i = startIdx; i < endIdx; i++) {
            result = result * 2 + (input[i] - '0');
        }
        return result;
    }

    int getPC() {
        return PC;
    }

    void incrementPC() {
        increasePC(1);
    }

    void increasePC(final int value) {
        if (PC + value > MEMORY || PC + value < 0) {
            throw new OutOfMemoryError("System is out of memory!");
        }
        PC += value;
    }
}
