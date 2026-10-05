import java.util.Arrays;
import java.util.Scanner;

public class PerformanceComparison {

    public static void run(Scanner scanner) {

        System.out.println(
                "\n============================================="
        );

        System.out.println(
                "        PERFORMANCE COMPARISON"
        );

        System.out.println(
                "============================================="
        );

        int[] numbers = {
                45, 12, 78, 34, 23,
                89, 67, 10, 56, 99,
                31, 44, 72, 18, 61
        };

        System.out.println(
                "Data: "
                        + Arrays.toString(numbers)
        );

        System.out.print(
                "Enter value to search: "
        );

        int target =
                Main.readInt(scanner);

        // Linear Search
        int linearSteps = 0;
        int linearResult = -1;

        long linearStart =
                System.nanoTime();

        for (int i = 0;
             i < numbers.length;
             i++) {

            linearSteps++;

            if (numbers[i] == target) {

                linearResult = i;
                break;
            }
        }

        long linearEnd =
                System.nanoTime();

        // Binary Search
        int[] sorted =
                Arrays.copyOf(
                        numbers,
                        numbers.length
                );

        Arrays.sort(sorted);

        int left = 0;
        int right =
                sorted.length - 1;

        int binarySteps = 0;
        int binaryResult = -1;

        long binaryStart =
                System.nanoTime();

        while (left <= right) {

            binarySteps++;

            int middle =
                    left
                            + (right - left)
                            / 2;

            if (sorted[middle]
                    == target) {

                binaryResult = middle;
                break;
            }

            if (sorted[middle]
                    < target) {

                left = middle + 1;

            } else {

                right = middle - 1;
            }
        }

        long binaryEnd =
                System.nanoTime();

        System.out.println(
                "\nSorted Data: "
                        + Arrays.toString(sorted)
        );

        System.out.println(
                "\n------------------------------------------------------------"
        );

        System.out.printf(
                "%-20s %-10s %-15s %-10s%n",
                "Algorithm",
                "Steps",
                "Time(ns)",
                "Found"
        );

        System.out.println(
                "------------------------------------------------------------"
        );

        System.out.printf(
                "%-20s %-10d %-15d %-10s%n",
                "Linear Search",
                linearSteps,
                linearEnd - linearStart,
                linearResult != -1
                        ? "Yes"
                        : "No"
        );

        System.out.printf(
                "%-20s %-10d %-15d %-10s%n",
                "Binary Search",
                binarySteps,
                binaryEnd - binaryStart,
                binaryResult != -1
                        ? "Yes"
                        : "No"
        );

        System.out.println(
                "------------------------------------------------------------"
        );

        System.out.println(
                "\nComplexity:"
        );

        System.out.println(
                "Linear Search : O(n)"
        );

        System.out.println(
                "Binary Search : O(log n)"
        );

        System.out.println(
                "BFS           : O(V + E)"
        );

        System.out.println(
                "DFS           : O(V + E)"
        );
    }
}