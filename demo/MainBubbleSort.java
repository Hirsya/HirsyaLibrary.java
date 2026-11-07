import HirsyaLibrary.sorting.BubbleSort;

import java.util.Arrays;

public class MainBubbleSort {
    public static void main(String[] args) {
        int[] numbers = {5, 2, 9, 1, 5, 6};
        System.out.println("Awal        : " + Arrays.toString(numbers));
        BubbleSort.sort(numbers);
        System.out.println("Terurut     : " + Arrays.toString(numbers));

        long[] longs = {5000000000L, 12L, 750L};
        System.out.println("Long awal   : " + Arrays.toString(longs));
        BubbleSort.sort(longs);
        System.out.println("Long urut   : " + Arrays.toString(longs));

        double[] doubles = {3.5, 1.2, 9.9, 2.0};
        System.out.println("Double awal : " + Arrays.toString(doubles));
        BubbleSort.sort(doubles);
        System.out.println("Double urut : " + Arrays.toString(doubles));

        float[] floats = {2.5f, 0.5f, 4.0f};
        System.out.println("Float awal  : " + Arrays.toString(floats));
        BubbleSort.sort(floats);
        System.out.println("Float urut  : " + Arrays.toString(floats));

        int[] reversed = {5, 4, 3, 2, 1};
        System.out.println("Terbalik    : " + Arrays.toString(reversed));
        BubbleSort.sort(reversed);
        System.out.println("Terurut     : " + Arrays.toString(reversed));

        int[] sorted = {1, 2, 3, 4, 5};
        System.out.println("Sudah urut  : " + Arrays.toString(sorted));
        BubbleSort.sort(sorted);
        System.out.println("Tetap       : " + Arrays.toString(sorted));

        int[] negative = {-3, 0, -10, 7, -3};
        System.out.println("Negatif     : " + Arrays.toString(negative));
        BubbleSort.sort(negative);
        System.out.println("Terurut     : " + Arrays.toString(negative));

        int[] empty = {};
        BubbleSort.sort(empty);
        System.out.println("Kosong      : " + Arrays.toString(empty));

        int[] single = {7};
        BubbleSort.sort(single);
        System.out.println("Satu        : " + Arrays.toString(single));

        int[] nullArray = null;
        BubbleSort.sort(nullArray);
        System.out.println("Null array  : tidak error");
    }
}
