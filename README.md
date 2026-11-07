# HirsyaLibrary.java

Storage for my own Java library, built as the final project of the Algorithms
and Data Structures course.

The library is dependency-free and implemented from scratch. Every structure
uses a linked-node design, is fully generic (`<T>`), and follows the same
conventions across the board: private internals, `public` methods, explicit
exceptions instead of console printing, `size()`, `clear()` and a readable
`toString()`.

## Structures

| Structure | Package | Order | Underlying design |
|-----------|---------|-------|-------------------|
| `HirsyaQueue<T>` | `HirsyaLibrary.queue` | FIFO | singly linked nodes, `front` / `end` |
| `HirsyaStack<T>` | `HirsyaLibrary.stack` | LIFO | singly linked nodes, `top` |
| `HirsyaLinkedList<T>` | `HirsyaLibrary.linkedlist` | index / traversal | singly linked nodes, `head` / `tail` |

## Algorithms

| Algorithm | Package | Input types | Time (worst) |
|-----------|---------|-------------|--------------|
| `BubbleSort` | `HirsyaLibrary.sorting` | `int[]`, `long[]`, `float[]`, `double[]` | O(n^2) |
| `SelectionSort` | `HirsyaLibrary.sorting` | `int[]`, `long[]`, `float[]`, `double[]` | O(n^2) |

## Repository layout

```
HirsyaLibrary/
├── README.md                     <- this file (structure of the whole library)
├── .gitignore
├── queue/
│   ├── README.md                 <- details for the queue package
│   ├── HirsyaQueue.java
│   └── EmptyQueueException.java
├── stack/
│   ├── README.md                 <- details for the stack package
│   ├── HirsyaStack.java
│   └── EmptyStackException.java
├── linkedlist/
│   ├── README.md                 <- details for the linked list package
│   └── HirsyaLinkedList.java
├── sorting/
│   ├── README.md                 <- details for the sorting package
│   ├── BubbleSort.java
│   └── SelectionSort.java
└── demo/
    ├── README.md                 <- how to run the demos
    ├── MainQueue.java
    ├── MainStack.java
    ├── MainLinkedList.java
    ├── MainSorting.java
    └── MainBubbleSort.java
```

Each folder has its own `README.md` that explains the classes inside it, the
public API, complexity, and examples.

## Design rules used everywhere

1. **Generic** - elements are typed by `T`, no raw `Object` and no casts at the
   call site.
2. **Encapsulated** - node classes are `private static` nested classes, so the
   storage detail never leaks to the user.
3. **No printing inside the library** - invalid operations throw exceptions;
   the caller decides how to report them.
4. **Explicit state tracking** - `size` is stored as a field, so `size()` and
   `isEmpty()` are O(1) instead of O(n).
5. **Reusable after `clear()`** - clearing only drops references; the same
   instance can be used again immediately.
6. **In-place algorithms** - the sorting classes take an array and reorder it
   without allocating helper collections. They accept primitive number arrays
   (`int[]`, `long[]`, `float[]`, `double[]`) through overloading.

## Build and run

All sources are plain Java 8+ with no external dependencies. From this folder:

```bash
javac -d . queue/*.java stack/*.java linkedlist/*.java sorting/*.java
javac -cp . -d . demo/*.java
```

Run the demos:

```bash
java -cp . MainQueue
java -cp . MainStack
java -cp . MainLinkedList
java -cp . MainSorting
java -cp . MainBubbleSort
```

## Using the library elsewhere

```java
import HirsyaLibrary.queue.HirsyaQueue;
import HirsyaLibrary.stack.HirsyaStack;
import HirsyaLibrary.linkedlist.HirsyaLinkedList;

HirsyaQueue<Integer> queue = new HirsyaQueue<>();
queue.add(1);
queue.add(2);
System.out.println(queue.remove());   // 1

HirsyaStack<String> stack = new HirsyaStack<>();
stack.push("a");
stack.push("b");
System.out.println(stack.peek());     // b

HirsyaLinkedList<Double> list = new HirsyaLinkedList<>();
list.add(1.5);
list.add(2.5);
System.out.println(list.getAt(1));    // 2.5

int[] numbers = {5, 2, 9, 1};
HirsyaLibrary.sorting.BubbleSort.sort(numbers);
System.out.println(java.util.Arrays.toString(numbers)); // [1, 2, 5, 9]

double[] values = {3.5, 1.2};
HirsyaLibrary.sorting.SelectionSort.sort(values);
System.out.println(java.util.Arrays.toString(values));  // [1.2, 3.5]
```

If you want to ship it as a jar, build one from the package folders:

```bash
javac -d build queue/*.java stack/*.java linkedlist/*.java sorting/*.java
jar cf hirsyalibrary.jar -C build .
```

## Notes

- Packages use the capitalized name `HirsyaLibrary` to match the folder name of
  the repository. Java's usual convention is lowercase package names; renaming
  later only requires updating the `package` line and the folder names.
- The demo classes intentionally live in the default package so they can be run
  directly with `java MainQueue` etc.
- `HirsyaQueue` and `HirsyaStack` are named with a prefix to avoid clashing with
  `java.util.Queue` and `java.util.Stack`.
