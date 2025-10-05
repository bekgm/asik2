package algorithms;

import metrics.PerformanceTracker;

public class SelectionSort {

    public static void sort(int[] arr, PerformanceTracker tracker) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;

            for (int j = i + 1; j < n; j++) {
                tracker.incrementComparisons();
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }

            if (minIdx != i) {
                int temp = arr[minIdx];
                arr[minIdx] = arr[i];
                arr[i] = temp;
                tracker.incrementSwaps();
            }
        }
    }

    public static void main(String[] args) {

        int[] sortedArray = {1,2,3,4,5,6,7,8,9,10};
        int[] reverseArray = {10,9,8,7,6,5,4,3,2,1};
        int[] randomArray = {5,9,2,8,3,7,1,10,6,4};

        runBenchmark("Best Case (Sorted Array)", sortedArray);
        runBenchmark("Worst Case (Reverse Sorted Array)", reverseArray);
        runBenchmark("Average Case (Random Array)", randomArray);
    }

    private static void runBenchmark(String caseName, int[] arr) {
        PerformanceTracker tracker = new PerformanceTracker();
        long startTime = System.nanoTime();
        SelectionSort.sort(arr, tracker);
        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        System.out.println("\n" + caseName + ":");
        System.out.println("Time: " + duration + " ns");
        System.out.println("Comparisons: " + tracker.getComparisons());
        System.out.println("Swaps: " + tracker.getSwaps());
    }
}