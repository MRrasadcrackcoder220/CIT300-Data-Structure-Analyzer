import java.util.Scanner;

public class Main {

    public static int readInt(
            Scanner scanner
    ) {

        while (true) {

            String input =
                    scanner.nextLine().trim();

            try {

                return Integer.parseInt(input);

            } catch (NumberFormatException e) {

                System.out.print(
                        "Invalid input. Enter a number: "
                );
            }
        }
    }

    public static void displayTeam() {

        System.out.println(
                "\n============================================="
        );

        System.out.println(
                "              GROUP MEMBERS"
        );

        System.out.println(
                "============================================="
        );

        System.out.println(
                "23DA2-1158 - M.R. Rasad Ahamed"
        );

        System.out.println(
                "Responsibility: Array + Searching"
        );

        System.out.println();

        System.out.println(
                "23DA2-0967 - M.I.M. ASKhan"
        );

        System.out.println(
                "Responsibility: Stack + Queue"
        );

        System.out.println();

        System.out.println(
                "23DA2-0865 - M.N.Y. Ahamed"
        );

        System.out.println(
                "Responsibility: Linked List"
        );

        System.out.println();

        System.out.println(
                "23DA2-0750 - M.S.M. Asifak"
        );

        System.out.println(
                "Responsibility: Graph + BFS/DFS + Integration + Performance"
        );

        System.out.println(
                "============================================="
        );
    }

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {

            int choice;

            System.out.println(
                    "============================================="
            );

            System.out.println(
                    " CIT300 - DATA STRUCTURE & GRAPH ANALYZER"
            );

            System.out.println(
                    "============================================="
            );

            do {

                System.out.println(
                        "\n============================================="
                );

                System.out.println(
                        "     DATA STRUCTURE & GRAPH ANALYZER"
                );

                System.out.println(
                        "============================================="
                );

                System.out.println(
                        "1. Array Operations"
                );

                System.out.println(
                        "2. Stack Operations"
                );

                System.out.println(
                        "3. Queue Operations"
                );

                System.out.println(
                        "4. Linked List Operations"
                );

                System.out.println(
                        "5. Searching Operations"
                );

                System.out.println(
                        "6. Graph Operations"
                );

                System.out.println(
                        "7. Performance Comparison"
                );

                System.out.println(
                        "8. Display Group Details"
                );

                System.out.println(
                        "9. Exit"
                );

                System.out.print(
                        "Enter your choice: "
                );

                choice = readInt(scanner);

                switch (choice) {

                    case 1 -> ArrayOperations.menu(scanner);
                    case 2 -> StackOperations.menu(scanner);
                    case 3 -> QueueOperations.menu(scanner);
                    case 4 -> LinkedListOperations.menu(scanner);
                    case 5 -> SearchingOperations.menu(scanner);
                    case 6 -> GraphOperations.menu(scanner);
                    case 7 -> PerformanceComparison.run(scanner);
                    case 8 -> displayTeam();
                    case 9 -> {
                        System.out.println(
                                "\nThank you for using the system."
                        );
                        System.out.println(
                                "Program terminated."
                        );
                    }
                    default -> System.out.println(
                            "Invalid choice. Please enter 1-9."
                    );
                }

            } while (choice != 9);
        }
    }
}