import HirsyaLibrary.linkedlist.HirsyaLinkedList;
import HirsyaLibrary.sorting.BubbleSort;
import HirsyaLibrary.sorting.SelectionSort;

import java.util.Arrays;

public class MainSorting {
    public static void main(String[] args) {
        int[] data = {5, 2, 9, 1, 5, 6};
        System.out.println("Awal      : " + Arrays.toString(data));

        int[] bubble = data.clone();
        BubbleSort.sort(bubble);
        System.out.println("Bubble    : " + Arrays.toString(bubble));

        int[] selection = data.clone();
        SelectionSort.sort(selection);
        System.out.println("Selection : " + Arrays.toString(selection));

        System.out.println();

        long[] longs = {5000000000L, 12L, 750L};
        System.out.println("Long awal : " + Arrays.toString(longs));
        BubbleSort.sort(longs);
        System.out.println("Long urut : " + Arrays.toString(longs));

        double[] doubles = {3.5, 1.2, 9.9, 2.0};
        System.out.println("Double awal : " + Arrays.toString(doubles));
        SelectionSort.sort(doubles);
        System.out.println("Double urut : " + Arrays.toString(doubles));

        float[] floats = {2.5f, 0.5f, 4.0f};
        System.out.println("Float awal  : " + Arrays.toString(floats));
        BubbleSort.sort(floats);
        System.out.println("Float urut  : " + Arrays.toString(floats));

        System.out.println();

        int[] negative = {-3, 0, -10, 7, -3};
        System.out.println("Negatif awal: " + Arrays.toString(negative));
        BubbleSort.sort(negative);
        System.out.println("Bubble      : " + Arrays.toString(negative));

        int[] negative2 = {-3, 0, -10, 7, -3};
        SelectionSort.sort(negative2);
        System.out.println("Selection   : " + Arrays.toString(negative2));

        int[] reversed = {5, 4, 3, 2, 1};
        System.out.println("Terbalik awal: " + Arrays.toString(reversed));
        BubbleSort.sort(reversed);
        System.out.println("Bubble       : " + Arrays.toString(reversed));

        int[] reversed2 = {5, 4, 3, 2, 1};
        SelectionSort.sort(reversed2);
        System.out.println("Selection    : " + Arrays.toString(reversed2));

        int[] alreadySorted = {1, 2, 3, 4, 5};
        System.out.println("Sudah urut awal: " + Arrays.toString(alreadySorted));
        BubbleSort.sort(alreadySorted);
        System.out.println("Bubble         : " + Arrays.toString(alreadySorted));

        int[] alreadySorted2 = {1, 2, 3, 4, 5};
        SelectionSort.sort(alreadySorted2);
        System.out.println("Selection      : " + Arrays.toString(alreadySorted2));

        System.out.println();

        int[] empty = {};
        BubbleSort.sort(empty);
        System.out.println("Array kosong: " + Arrays.toString(empty));

        int[] single = {7};
        SelectionSort.sort(single);
        System.out.println("Satu elemen : " + Arrays.toString(single));

        int[] nullArray = null;
        BubbleSort.sort(nullArray);
        SelectionSort.sort(nullArray);
        System.out.println("Array null  : tidak error");

        System.out.println();

        HirsyaLinkedList<Integer> list = new HirsyaLinkedList<>();
        list.add(5);
        list.add(2);
        list.add(9);
        list.add(1);
        System.out.println("List awal   : " + list);

        int[] toArray = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            toArray[i] = list.getAt(i);
        }
        SelectionSort.sort(toArray);
        System.out.println("List urut   : " + Arrays.toString(toArray));
    }
}
