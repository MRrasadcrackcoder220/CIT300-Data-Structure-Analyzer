import java.util.Scanner;

public class QueueOperations {

    private final int[] queue;
    private int front;
    private int rear;
    private int size;

    public QueueOperations(int capacity) {

        queue = new int[capacity];

        front = 0;
        rear = -1;
        size = 0;
    }

    public void enqueue(int value) {

        if (size == queue.length) {
            System.out.println("Queue is full.");
            return;
        }

        rear = (rear + 1) % queue.length;

        queue[rear] = value;

        size++;

        System.out.println(
                value + " added to queue."
        );
    }

    public void dequeue() {

        if (size == 0) {
            System.out.println(
                    "Queue is empty. Cannot dequeue."
            );
            return;
        }

        int removed = queue[front];

        front = (front + 1) % queue.length;

        size--;

        System.out.println(
                removed + " removed from queue."
        );
    }

    public void peek() {

        if (size == 0) {
            System.out.println("Queue is empty.");
            return;
        }

        System.out.println(
                "Front element: " + queue[front]
        );
    }

    public void display() {

        if (size == 0) {
            System.out.println("Queue is empty.");
            return;
        }

        System.out.print("Queue: ");

        for (int i = 0; i < size; i++) {

            int index =
                    (front + i) % queue.length;

            System.out.print(
                    queue[index] + " "
            );
        }

        System.out.println();
    }

    public static void menu(Scanner scanner) {

        QueueOperations queue =
                new QueueOperations(100);

        int choice;

        do {

            System.out.println(
                    "\n------ QUEUE OPERATIONS ------"
            );

            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek / Front");
            System.out.println("4. Display");
            System.out.println("5. Return to Main Menu");

            System.out.print("Enter choice: ");

            choice = Main.readInt(scanner);

            switch (choice) {

                case 1 -> {
                    System.out.print(
                            "Enter value: "
                    );

                    queue.enqueue(
                            Main.readInt(scanner)
                    );
                }

                case 2 -> queue.dequeue();

                case 3 -> queue.peek();

                case 4 -> queue.display();

                case 5 -> { }

                default -> System.out.println(
                        "Invalid choice."
                );
            }

        } while (choice != 5);
    }
}