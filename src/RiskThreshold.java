import java.util.*;

public class RiskThreshold {

    // Linear Search (unsorted)
    static void linearSearch(int arr[], int target) {
        int comparisons = 0;

        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i] == target) {
                System.out.println("Found at index " + i);
                System.out.println("Comparisons: " + comparisons);
                return;
            }
        }

        System.out.println("Not Found (Linear)");
        System.out.println("Comparisons: " + comparisons);
    }

    // Binary Search for insertion point
    static int binaryInsertion(int arr[], int target) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == target)
                return mid;
            else if (arr[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return low; // insertion position
    }

    // Floor (largest <= target)
    static int floor(int arr[], int target) {
        int low = 0, high = arr.length - 1;
        int ans = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] <= target) {
                ans = arr[mid];
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    // Ceiling (smallest >= target)
    static int ceiling(int arr[], int target) {
        int low = 0, high = arr.length - 1;
        int ans = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] >= target) {
                ans = arr[mid];
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        int risks[] = {50, 10, 100, 25};

        // Linear search on unsorted
        System.out.println("Unsorted Array: " + Arrays.toString(risks));
        linearSearch(risks, 30);

        // Sort for binary operations
        Arrays.sort(risks);
        System.out.println("\nSorted Risks: " + Arrays.toString(risks));

        int pos = binaryInsertion(risks, 30);
        System.out.println("Insertion Position for 30: " + pos);

        System.out.println("Floor of 30: " + floor(risks, 30));
        System.out.println("Ceiling of 30: " + ceiling(risks, 30));
    }
}