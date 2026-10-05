import java.util.Scanner;

public class StackOperations {

    private final int[] stack;
    private int top;

    public StackOperations(int capacity) {
        stack = new int[capacity];
        top = -1;
    }

    public void push(int value) {

        if (top == stack.length - 1) {
            System.out.println("Stack Overflow.");
            return;
        }

        stack[++top] = value;

        System.out.println(
                value + " pushed to stack."
        );
    }

    public void pop() {

        if (top == -1) {
            System.out.println(
                    "Stack is empty. Cannot pop."
            );
            return;
        }

        System.out.println(
                stack[top--] + " popped from stack."
        );
    }

    public void peek() {

        if (top == -1) {
            System.out.println("Stack is empty.");
            return;
        }

        System.out.println(
                "Top element: " + stack[top]
        );
    }

    public void display() {

        if (top == -1) {
            System.out.println("Stack is empty.");
            return;
        }

        System.out.print("Stack: ");

        for (int i = top; i >= 0; i--) {
            System.out.print(stack[i] + " ");
        }

        System.out.println();
    }

    public static void menu(Scanner scanner) {

        StackOperations stack =
                new StackOperations(100);

        int choice;

        do {

            System.out.println(
                    "\n------ STACK OPERATIONS ------"
            );

            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Return to Main Menu");

            System.out.print("Enter choice: ");

            choice = Main.readInt(scanner);

            switch (choice) {

                case 1 -> {
                    System.out.print(
                            "Enter value: "
                    );

                    stack.push(
                            Main.readInt(scanner)
                    );
                }

                case 2 -> stack.pop();

                case 3 -> stack.peek();

                case 4 -> stack.display();

                case 5 -> { }

                default -> System.out.println(
                        "Invalid choice."
                );
            }

        } while (choice != 5);
    }
}