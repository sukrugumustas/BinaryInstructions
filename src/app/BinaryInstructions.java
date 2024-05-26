package app;

import java.util.Scanner;

public class BinaryInstructions {

    private static final String USAGE = """
            \
            Branch Operation: Branch operator changes the program counter (PC) by adding the sign-extended value
                              of last 9 digits of the input.
                              [0000 ### N ZZZZZZZZ, N: Sign, Z: Val]

            Add Operation: Add operator sums the values of two source registers or one register and one
                           sign-extended value in last 5 digits and stores them in a destination register.
                           2 Regs: [0001 DDD SSS 0 ## LLL, D: Dest, S: Src 1, L: Src 2]
                           1 Reg : [0001 DDD SSS 1 N ZZZZ, D: Dest, S: Src, N: Sign, Z: Val]

            Load Instruction Operation: Load instruction operator adds a sign-extended value + 1 to PC and
                                        stores the value in the memory at that address to destination register.
                                        [0010 DDD N ZZZZZZZZ, D: Dest, N: Sign, Z: Val]

            Store Instruction Operation: Store instruction operator adds a sign-extended value + 1 to PC and
                                         stores the value in the source register to memory at that address.
                                         [0011 SSS N ZZZZZZZZ, S: Src, N: Sign, Z: Val]

            Load Register Operation: Load register operator adds a sign extended value to the address of a base
                                     register and uses the value in that register as memory address and stores
                                     the value in the memory to a destination register.
                                     [0110 DDD BBB N ZZZZZ, D: Dest, B: Base, N: Sign, Z: Val]

            Store Register Operation: Store register operator adds a sign extended value to the address of a
                                      destination register and stores the value in the source register to the
                                      memory at the address in the destination register.
                                      [0111 SSS DDD N ZZZZZ, S: Src, D: Dest, N: Sign, Z: Val]

            Load Immediate Operation: Load immediate operator adds a sign extended value + 1 to the PC and uses
                                      that value as address point in memory. Then it uses the value in that
                                      address as another address point in the memory and stores the value in it
                                      to the destination register.
                                      [1010 DDD N ZZZZZZZZ, D: Dest, N: Sign, Z: Val]

            Store Immediate Operation: Store immediate operator adds a sign extended value + 1 to the PC and
                                       uses that value as address point in memory. Then it uses the value in
                                       that address as another address point in the memory and stores the value
                                       in the source register to that.
                                       [1011 SSS N ZZZZZZZZ, S: Src, N: Sign, Z: Val]

            Jump Operation: Jump operator directly assigns the value in the source register to the PC.
                            [1100 000 SSS 000000, S: Src]
            \
            """;

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        while (true) {
            String input;
            while (true) {
                System.out.println("Please enter a binary instruction (e.g. 0101... 16 characters):");
                input = scanner.nextLine();
                if (input != null && input.matches("^[01]{16}$")) {
                    break;
                }
                System.err.println("Invalid input!");
                System.out.println();
                System.out.println(USAGE);
            }

            System.out.println("Do you want to continue? (y/n)");
            final String choice = scanner.nextLine();
            if (!"y".equalsIgnoreCase(choice)) {
                System.out.println("Good bye!");
                break;
            }
        }
    }
}
