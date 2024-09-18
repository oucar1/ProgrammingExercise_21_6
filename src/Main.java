import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * This program allows the user to input a series of numbers, ending with 0.
 * It then counts how many times each number was entered and prints the number(s)
 * with the most occurrences.
 */

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // HashMap to store the numbers and their occurrences
        Map<Integer, Integer> occurrences = new HashMap<>();

        System.out.println("Enter numbers and input ends with 0:");

        // Loop to read numbers from the user
        while (true) {
            int number = input.nextInt(); // Get number from the user

            // If the number is 0, terminate the loop
            if (number == 0) {
                break;
            }

            // If the number was entered before, increment its count
            occurrences.put(number, occurrences.getOrDefault(number, 0) + 1);
        }

        // Find the maximum occurrence to determine the number that appears the most
        int maxCount = 0;
        for (int count : occurrences.values()) {
            if (count > maxCount) {
                maxCount = count;
            }
        }

        // Print the number(s) with the most occurrences
        System.out.println("Number(s) with the most occurrences:");
        for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
            if (entry.getValue() == maxCount) {
                System.out.println("Number " + entry.getKey() + " occurred " + maxCount + " times");
            }
        }

        input.close();
    }
}
