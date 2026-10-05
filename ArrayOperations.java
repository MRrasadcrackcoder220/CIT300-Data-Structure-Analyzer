import java.util.Scanner;

public class ArrayOperations {

    private final int[] array;
    private int size;

    public ArrayOperations(int capacity) {
        array = new int[capacity];
        size = 0;
    }

    public void insert(int value) {
        if (size == array.length) {
            System.out.println("Array is full.");
            return;
        }

        array[size] = value;
        size++;

        System.out.println(value + " inserted successfully.");
    }

    public void delete(int value) {

        int index = -1;

        for (int i = 0; i < size; i++) {
            if (array[i] == value) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Value not found.");
            return;
        }

        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }

        size--;

        System.out.println(value + " deleted successfully.");
    }

    public void search(int value) {

        for (int i = 0; i < size; i++) {

            if (array[i] == value) {
                System.out.println(
                        "Value found at index: " + i
                );
                return;
            }
        }

        System.out.println("Value not found.");
    }

    public void display() {

        if (size == 0) {
            System.out.println("Array is empty.");
            return;
        }

        System.out.print("Array: ");

        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }

        System.out.println();
    }

    public static void menu(Scanner scanner) {

        ArrayOperations array =
                new ArrayOperations(100);

        int choice;

        do {

            System.out.println("\n------ ARRAY OPERATIONS ------");
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Search");
            System.out.println("4. Display");
            System.out.println("5. Return to Main Menu");

            System.out.print("Enter choice: ");

            choice = Main.readInt(scanner);

            switch (choice) {

                case 1 -> {
                    System.out.print("Enter value: ");
                    array.insert(Main.readInt(scanner));
                }

                case 2 -> {
                    System.out.print("Enter value to delete: ");
                    array.delete(Main.readInt(scanner));
                }

                case 3 -> {
                    System.out.print("Enter value to search: ");
                    array.search(Main.readInt(scanner));
                }

                case 4 -> array.display();

                case 5 -> { }

                default -> System.out.println("Invalid choice.");
            }

        } while (choice != 5);
    }
}