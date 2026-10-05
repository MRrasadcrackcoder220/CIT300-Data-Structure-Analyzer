import java.util.Scanner;

public class LinkedListOperations {

    private static class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    public void insert(int value) {

        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
        } else {

            Node current = head;

            while (current.next != null) {
                current = current.next;
            }

            current.next = newNode;
        }

        System.out.println(
                value + " inserted successfully."
        );
    }

    public void delete(int value) {

        if (head == null) {
            System.out.println(
                    "Linked List is empty."
            );
            return;
        }

        if (head.data == value) {

            head = head.next;

            System.out.println(
                    value + " deleted."
            );

            return;
        }

        Node current = head;

        while (current.next != null
                && current.next.data != value) {

            current = current.next;
        }

        if (current.next == null) {

            System.out.println(
                    "Value not found."
            );

        } else {

            current.next =
                    current.next.next;

            System.out.println(
                    value + " deleted."
            );
        }
    }

    public void search(int value) {

        Node current = head;

        int position = 0;

        while (current != null) {

            if (current.data == value) {

                System.out.println(
                        "Value found at position "
                                + position
                );

                return;
            }

            current = current.next;
            position++;
        }

        System.out.println(
                "Value not found."
        );
    }

    public void display() {

        if (head == null) {

            System.out.println(
                    "Linked List is empty."
            );

            return;
        }

        Node current = head;

        System.out.print(
                "Linked List: "
        );

        while (current != null) {

            System.out.print(
                    current.data
            );

            if (current.next != null) {
                System.out.print(" -> ");
            }

            current = current.next;
        }

        System.out.println();
    }

    public static void menu(Scanner scanner) {

        LinkedListOperations list =
                new LinkedListOperations();

        int choice;

        do {

            System.out.println(
                    "\n------ LINKED LIST OPERATIONS ------"
            );

            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Search");
            System.out.println("4. Display");
            System.out.println("5. Return to Main Menu");

            System.out.print(
                    "Enter choice: "
            );

            choice = Main.readInt(scanner);

            switch (choice) {

                case 1 -> {
                    System.out.print(
                            "Enter value: "
                    );

                    list.insert(
                            Main.readInt(scanner)
                    );
                }

                case 2 -> {
                    System.out.print(
                            "Enter value to delete: "
                    );

                    list.delete(
                            Main.readInt(scanner)
                    );
                }

                case 3 -> {
                    System.out.print(
                            "Enter value to search: "
                    );

                    list.search(
                            Main.readInt(scanner)
                    );
                }

                case 4 -> list.display();

                case 5 -> { }

                default -> System.out.println(
                        "Invalid choice."
                );
            }

        } while (choice != 5);
    }
}