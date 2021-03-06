package assignment13;

import java.util.Arrays;
import java.util.Random;
import mergesort.MergeSort;

/**
 * Test sorting an array with different methods.
 *
 * Results we got when testing locally with an array of size 10000000:
 *
 * This system has 4 available cores.
 * Sequential sorting took 1691 ms
 * Concurrent sorting took 556 ms
 *
 * @author Hendrik Werner // s4549775
 * @author Jasper Haasdijk // s4449754
 */
public class SortingTester {

    private final int[] array;

    public SortingTester(int size) {
        this.array = random(size);
    }

    /**
     * Test sequential and concurrent sorting.
     */
    public void test() {
        System.out.printf(
                "This system has %d available cores.\n",
                Runtime.getRuntime().availableProcessors()
        );
        int[] a1 = Arrays.copyOf(array, array.length);
        int[] a2 = Arrays.copyOf(array, array.length);
        long startSeq = System.currentTimeMillis();
        MergeSort.sort(a1);
        long stopSeq = System.currentTimeMillis();
        long startCon = System.currentTimeMillis();
        MergeSort.concurrentSort(a2);
        long stopCon = System.currentTimeMillis();
        System.out.printf("Sequential sorting took %d ms\n", stopSeq - startSeq);
        System.out.printf("Concurrent sorting took %d ms\n", stopCon - startCon);
    }

    /**
     * @param size the size of the array
     * @return an array with the specified size initialized with random values
     */
    private int[] random(int size) {
        Random generator = new Random();
        int[] ints = new int[size];
        for (int i = 0; i < size; i++) {
            ints[i] = generator.nextInt();
        }
        return ints;
    }

}
