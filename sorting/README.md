# sorting

Elementary sorting algorithms implemented from scratch, without any helper
collection from `java.util`.

## Files

| File | Purpose |
|------|---------|
| `BubbleSort.java` | Bubble sort |
| `SelectionSort.java` | Selection sort |

## Design

- Both classes are plain utility classes used as `BubbleSort.sort(array)` and
  `SelectionSort.sort(array)`.
- Both work on **primitive number arrays**: `int[]`, `long[]`, `float[]` and
  `double[]`. The type is picked by overloading, so no autoboxing and no casts
  are needed at the call site.
- Both sort **in place** and allocate no extra array.
- The output is always **ascending**.
- `null` arrays and arrays shorter than two elements are returned untouched, so
  the algorithms never throw and never index out of bounds.
- There is no generic / `Comparable` version: these classes are intentionally
  limited to numbers.

## Public API

| Class | Method | Best | Average | Worst | Space | Stable |
|-------|--------|------|---------|-------|-------|--------|
| `BubbleSort` | `static void sort(int[] array)` | O(n) | O(n^2) | O(n^2) | O(1) | yes |
| `BubbleSort` | `static void sort(long[] array)` | O(n) | O(n^2) | O(n^2) | O(1) | yes |
| `BubbleSort` | `static void sort(float[] array)` | O(n) | O(n^2) | O(n^2) | O(1) | yes |
| `BubbleSort` | `static void sort(double[] array)` | O(n) | O(n^2) | O(n^2) | O(1) | yes |
| `SelectionSort` | `static void sort(int[] array)` | O(n^2) | O(n^2) | O(n^2) | O(1) | no |
| `SelectionSort` | `static void sort(long[] array)` | O(n^2) | O(n^2) | O(n^2) | O(1) | no |
| `SelectionSort` | `static void sort(float[] array)` | O(n^2) | O(n^2) | O(n^2) | O(1) | no |
| `SelectionSort` | `static void sort(double[] array)` | O(n^2) | O(n^2) | O(n^2) | O(1) | no |

`BubbleSort` reaches O(n) on an already sorted array thanks to an early-exit
flag (`swapped`). `SelectionSort` always needs the full O(n^2) scan, but it
performs at most n-1 swaps, which makes it the better choice when writing is
expensive.

## How each algorithm works

**Bubble sort** compares every pair of adjacent elements and swaps them when the
left one is greater. After one full pass the largest remaining element is in its
final position on the right, so the scanned range shrinks by one each pass. If a
pass performs no swap, the array is already sorted and the loop stops.

**Selection sort** keeps a sorted prefix. On every pass it scans the unsorted
part for the smallest element and swaps it into the first unsorted position.
The swap happens at most once per pass, and is skipped when the smallest element
is already in place (`minIndex == i`).

## Example

```java
import HirsyaLibrary.sorting.BubbleSort;
import HirsyaLibrary.sorting.SelectionSort;
import java.util.Arrays;

int[] numbers = {5, 2, 9, 1};
BubbleSort.sort(numbers);
System.out.println(Arrays.toString(numbers));  // [1, 2, 5, 9]

double[] values = {3.5, 1.2, 9.9};
SelectionSort.sort(values);
System.out.println(Arrays.toString(values));   // [1.2, 3.5, 9.9]

float[] ratios = {2.5f, 0.5f};
BubbleSort.sort(ratios);
System.out.println(Arrays.toString(ratios));   // [0.5, 2.5]

long[] big = {5000000000L, 1L};
SelectionSort.sort(big);
System.out.println(Arrays.toString(big));      // [1, 5000000000]
```

## Sorting a `HirsyaLinkedList`

The sorting classes work on arrays, so copy the elements out first:

```java
HirsyaLinkedList<Integer> list = new HirsyaLinkedList<>();
list.add(5);
list.add(2);
list.add(9);

int[] array = new int[list.size()];
for (int i = 0; i < list.size(); i++) {
    array[i] = list.getAt(i);
}

BubbleSort.sort(array);
```

## Notes

- `float` literals need the `f` suffix: `{2.5f, 0.5f}`.
- `NaN` does not compare consistently (`NaN > x` and `NaN < x` are both false),
  so arrays containing `NaN` are not sorted meaningfully. `Infinity` and
  `-Infinity` work correctly.
- `Byte` and `Short` are not provided because they are rarely used for sorting;
  widening to `int[]` covers them.
- Selection sort is not stable: a long distance swap can move equal elements
  behind each other. Bubble sort is stable because it only swaps when the left
  element is strictly greater.

## Demo

See `../demo/MainSorting.java` (both algorithms) and
`../demo/MainBubbleSort.java` (bubble sort in detail).
