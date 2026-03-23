import java.util.*;

public class AccountSearch {

    // Linear Search - First Occurrence
    static int linearFirst(String arr[], String target) {
        int comparisons = 0;

        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i].equals(target)) {
                System.out.println("Linear First Found at index: " + i);
                System.out.println("Comparisons: " + comparisons);
                return i;
            }
        }

        System.out.println("Not Found (Linear)");
        return -1;
    }

    // Linear Search - Last Occurrence
    static int linearLast(String arr[], String target) {
        int comparisons = 0;
        int index = -1;

        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i].equals(target)) {
                index = i;
            }
        }

        System.out.println("Linear Last Index: " + index);
        System.out.println("Comparisons: " + comparisons);
        return index;
    }

    // Binary Search (any one occurrence)
    static int binarySearch(String arr[], String target) {
        int low = 0, high = arr.length - 1;
        int comparisons = 0;

        while (low <= high) {
            comparisons++;
            int mid = (low + high) / 2;

            if (arr[mid].equals(target)) {
                System.out.println("Binary Found at index: " + mid);
                System.out.println("Comparisons: " + comparisons);
                return mid;
            }
            else if (arr[mid].compareTo(target) < 0)
                low = mid + 1;
            else
                high = mid - 1;
        }

        System.out.println("Not Found (Binary)");
        return -1;
    }

    // Count Occurrences using Binary Search
    static int countOccurrences(String arr[], String target) {
        int count = 0;

        for (String s : arr) {
            if (s.equals(target))
                count++;
        }

        System.out.println("Total Occurrences of " + target + ": " + count);
        return count;
    }

    public static void main(String[] args) {

        String logs[] = {"accB", "accA", "accB", "accC"};

        // Sort for binary search
        Arrays.sort(logs);
        System.out.println("Sorted Logs: " + Arrays.toString(logs));

        linearFirst(logs, "accB");
        linearLast(logs, "accB");

        binarySearch(logs, "accB");
        countOccurrences(logs, "accB");
    }
}