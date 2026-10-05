import java.util.Arrays;
import java.util.Scanner;

public class SearchingOperations {

    public static int linearSearch(
            int[] array,
            int target
    ) {

        for (int i = 0; i < array.length; i++) {

            if (array[i] == target) {
                return i;
            }
        }

        return -1;
    }

    public static int binarySearch(
            int[] array,
            int target
    ) {

        int left = 0;
        int right = array.length - 1;

        while (left <= right) {

            int middle = left + (right - left) / 2;

            if (array[middle] == target) {
                return middle;
            }

            if (array[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return -1;
    }

    public static void menu(Scanner scanner) {

        System.out.print(
                "How many numbers do you want to enter? "
        );

        int size = Main.readInt(scanner);

        if (size <= 0) {
            System.out.println("Size must be greater than 0.");
            return;
        }

        int[] numbers = new int[size];

        for (int i = 0; i < size; i++) {

            System.out.print(
                    "Enter number " + (i + 1) + ": "
            );

            numbers[i] = Main.readInt(scanner);
        }

        int choice;

        do {

            System.out.println(
                    "\n------ SEARCHING OPERATIONS ------"
            );

            System.out.println("1. Linear Search");
            System.out.println("2. Binary Search");
            System.out.println("3. Display Numbers");
            System.out.println("4. Return to Main Menu");

            System.out.print("Enter choice: ");

            choice = Main.readInt(scanner);

            switch (choice) {

                case 1 -> {

                    System.out.print(
                            "Enter value to search: "
                    );

                    int target = Main.readInt(scanner);

                    int result =
                            linearSearch(numbers, target);

                    if (result != -1) {
                        System.out.println(
                                "Value found at index " + result
                        );
                    } else {
                        System.out.println(
                                "Value not found."
                        );
                    }
                }

                case 2 -> {

                    int[] sorted =
                            Arrays.copyOf(
                                    numbers,
                                    numbers.length
                            );

                    Arrays.sort(sorted);

                    System.out.println(
                            "Sorted Array: "
                                    + Arrays.toString(sorted)
                    );

                    System.out.print(
                            "Enter value to search: "
                    );

                    int target = Main.readInt(scanner);

                    int result =
                            binarySearch(sorted, target);

                    if (result != -1) {
                        System.out.println(
                                "Value found at sorted index "
                                        + result
                        );
                    } else {
                        System.out.println(
                                "Value not found."
                        );
                    }
                }

                case 3 -> System.out.println(
                        Arrays.toString(numbers)
                );

                case 4 -> { }

                default -> System.out.println(
                        "Invalid choice."
                );
            }

        } while (choice != 4);
    }
}