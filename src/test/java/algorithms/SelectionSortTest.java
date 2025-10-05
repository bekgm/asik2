package algorithms;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SelectionSortTest {

    @Test
    void testSort() {
        int[] arr = {64, 25, 12, 22, 11};
        SelectionSort.sort(arr);
        assertArrayEquals(new int[] {11, 12, 22, 25, 64}, arr);
    }

    @Test
    void testEmptyArray() {
        int[] arr = {};
        SelectionSort.sort(arr);
        assertArrayEquals(new int[] {}, arr);
    }

    @Test
    void testSingleElement() {
        int[] arr = {1};
        SelectionSort.sort(arr);
        assertArrayEquals(new int[] {1}, arr);
    }

    @Test
    void testDuplicates() {
        int[] arr = {3, 1, 2, 3, 3};
        SelectionSort.sort(arr);
        assertArrayEquals(new int[] {1, 2, 3, 3, 3}, arr);
    }
}
