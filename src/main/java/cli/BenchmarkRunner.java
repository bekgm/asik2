package cli;

import algorithms.SelectionSort;
import metrics.PerformanceTracker;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class BenchmarkRunner {

    public static void main(String[] args) {
        int[] inputSizes = {100, 1000, 10000, 100000};

        String folderPath = "docs/performance_plots";
        File folder = new File(folderPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }

        String csvFile = folderPath + "/selection_sort_benchmark.csv";

        try (FileWriter writer = new FileWriter(csvFile)) {
            writer.append("Case,Size,Comparisons,ArrayAccesses,MemoryAllocations,Time(ms),Big-O,Big-Theta,Big-Omega\n");

            benchmarkCase(writer, "Best Case", inputSizes, true, false);

            benchmarkCase(writer, "Worst Case", inputSizes, false, false);

            benchmarkCase(writer, "Average Case", inputSizes, false, true);

            System.out.println("CSV file saved: " + csvFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void benchmarkCase(FileWriter writer, String caseName, int[] inputSizes, boolean sorted, boolean random) throws IOException {
        for (int n : inputSizes) {
            int[] arr;
            if (sorted) {
                arr = generateSortedArray(n);
            } else if (random) {
                arr = generateRandomArray(n);
            } else {
                arr = generateReverseSortedArray(n);
            }

            PerformanceTracker tracker = new PerformanceTracker();
            long startTime = System.nanoTime();
            SelectionSort.sort(arr, tracker);
            long endTime = System.nanoTime();

            double timeMs = (endTime - startTime) / 1_000_000.0;
            long comparisons = tracker.getComparisons();
            long arrayAccesses = tracker.getSwaps() * 2;
            long memoryAllocations = 0;

            String bigONotation = "O(n^2)";
            String bigThetaNotation = "Θ(n^2)";
            String bigOmegaNotation = "Ω(n^2)";

            writer.append(String.format("%s,%d,%d,%d,%d,%.6f,%s,%s,%s\n",
                    caseName, n, comparisons, arrayAccesses, memoryAllocations, timeMs,
                    bigONotation, bigThetaNotation, bigOmegaNotation));

            System.out.println(caseName + " completed for n = " + n);
        }
    }

    private static int[] generateSortedArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) arr[i] = i + 1;
        return arr;
    }

    private static int[] generateReverseSortedArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) arr[i] = size - i;
        return arr;
    }

    private static int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) arr[i] = (int)(Math.random() * 10000);
        return arr;
    }
}