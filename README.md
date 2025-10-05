# Assignment 2: Selection Sort Benchmarking

##Project Overview

This project implements the Selection Sort algorithm in Java and benchmarks its performance across arrays of different sizes.

The benchmark measures:
- Comparisons – Number of element comparisons
- Array Accesses – Estimated as (number of swaps × 2)
- Memory Allocations – Extra memory used (0 for in-place sort)
- Execution Time – Measured in milliseconds

Benchmarks are executed for three cases:
1. Best Case – Already sorted array
2. Worst Case – Reverse sorted array
3. Average Case – Randomly shuffled array

Results are saved in a CSV file that includes Big-O, Big-Theta, and Big-Omega notations for theoretical analysis.

---

## Requirements

- Java 17 or higher
- Maven (optional for build management)
- No external dependencies for sorting and benchmarking
- Optional: [JFreeChart](https://www.jfree.org/jfreechart/) – to generate graphs from benchmark data

---

## How to Run the Benchmark

### 1. Compile the project

javac -d target/classes src/main/java/cli/BenchmarkRunner.java

### 2. Run the benchmark

java -cp target/classes cli.BenchmarkRunner

The benchmark will automatically execute for array sizes:

100, 1000, 10000, 100000

### 3. Output location

Results are saved to:

docs/performance_plots/selection_sort_benchmark.csv

---

## CSV Output Format

| Column | Description |
|--------|-------------|
| Case | Benchmark case: Best / Worst / Average |
| Size | Array size (n) |
| Comparisons | Total number of element comparisons |
| ArrayAccesses | Estimated array accesses (swaps × 2) |
| MemoryAllocations | Extra memory allocated (0 for in-place sort) |
| Time(ms) | Execution time in milliseconds |
| Big-O | Big-O time complexity |
| Big-Theta | Big-Theta time complexity |
| Big-Omega | Big-Omega time complexity |

---

## Example CSV Output

Case,Size,Comparisons,ArrayAccesses,MemoryAllocations,Time(ms),Big-O,Big-Theta,Big-Omega
Best Case,100,4950,0,0,0.033459,O(n^2),Θ(n^2),Ω(n^2)
Worst Case,1000,499500,500,0,0.295375,O(n^2),Θ(n^2),Ω(n^2)
Average Case,10000,49995000,9989,0,1.843959,O(n^2),Θ(n^2),Ω(n^2)

---

## Algorithm Complexity

Selection Sort is a simple, comparison-based sorting algorithm.

| Case | Comparisons | Swaps | Time Complexity |
|------|-------------|-------|-----------------|
| Best Case (sorted) | O(n²) | O(0) | O(n²) |
| Worst Case (reverse) | O(n²) | O(n) | O(n²) |
| Average Case (random) | O(n²) | O(n) | O(n²) |

- Big-O (O): Upper bound – algorithm will never be worse than O(n²)
- Big-Theta (Θ): Tight bound – actual performance is Θ(n²)
- Big-Omega (Ω): Lower bound – algorithm will not be faster than Ω(n²)

---

## Folder Structure

assignment2-selection-sort/
├── src/
│   └── main/
│       └── java/
│           ├── algorithms/
│           │   └── SelectionSort.java
│           ├── metrics/
│           │   └── PerformanceTracker.java
│           └── cli/
│               └── BenchmarkRunner.java
├── docs/
│   └── performance_plots/
│       └── selection_sort_benchmark.csv
├── README.md
└── pom.xml

---

## Optional: Visualizing Results

To visualize the benchmark results, you can:

1. Import the CSV into Excel, Google Sheets, or any data visualization tool
2. Use [JFreeChart](https://www.jfree.org/jfreechart/) to generate graphs programmatically
3. Use Python with matplotlib or pandas to create performance plots

---

## License

This project is created for educational purposes as part of Assignment 2.

---

##  Author

*Bekzat Murat*

---