# demo

Runnable examples for every structure in the library.

## Files

| File | Structure demonstrated |
|------|------------------------|
| `MainQueue.java` | `HirsyaLibrary.queue.HirsyaQueue` |
| `MainStack.java` | `HirsyaLibrary.stack.HirsyaStack` |
| `MainLinkedList.java` | `HirsyaLibrary.linkedlist.HirsyaLinkedList` |
| `MainSorting.java` | `HirsyaLibrary.sorting` - bubble and selection sort |
| `MainBubbleSort.java` | `HirsyaLibrary.sorting.BubbleSort` in detail |

The structure demos exercise the normal flow (add/push, read, remove/pop, size,
empty check), the reuse-after-`clear()` case, and the exception thrown when an
operation is attempted on an empty structure. The sorting demos cover int, long,
float and double arrays, plus the empty, single element, already sorted,
reversed, negative and `null` cases.

These classes deliberately have **no `package` declaration**, so they can be
compiled and run straight from the repository root.

## Build and run

From the repository root (`HirsyaLibrary/`):

```bash
javac -d . queue/*.java stack/*.java linkedlist/*.java sorting/*.java
javac -cp . -d . demo/*.java
```

```bash
java -cp . MainQueue
java -cp . MainStack
java -cp . MainLinkedList
java -cp . MainSorting
java -cp . MainBubbleSort
```

## Expected output

`MainQueue`

```
Isi queue : [A, B, C]
Size      : 3
Front     : A
Empty     : false
Remove    : A
Remove    : B
Front     : C
Sisa      : [C]
Setelah clear: size=0 empty=true
Tambah lagi  : [X] size=1
Kosong       : size=0 empty=true
Exception    : Queue is empty
```

`MainStack`

```
Isi stack : bottom [1, 2, 3] top
Size      : 3
Peek      : 3
Empty     : false
Pop       : 3
Pop       : 2
Peek      : 1
Sisa      : bottom [1] top
Setelah clear: size=0 empty=true
Tambah lagi  : bottom [9] top size=1
Kosong       : size=0 empty=true
Exception    : pop() on an empty stack
String stack : bottom [a, b] top peek=b
```

`MainLinkedList`

```
Isi list  : [A, B, C]
Size      : 3
First     : A
Last      : C
getAt(1)  : B
Empty     : false
addFirst  : [Z, A, B, C]
insertAt  : [Z, A, X, B, C]
contains B: true
indexOf C : 4
delete B  : true -> [Z, A, X, C]
delete Q  : false
Setelah hapus depan & belakang: [A, X]
Setelah clear: size=0 empty=true
Tambah lagi  : [baru]
Exception    : Index out of range: 5
Integer list : [10, 20] contains 10=true
```

`MainSorting`

```
Awal      : [5, 2, 9, 1, 5, 6]
Bubble    : [1, 2, 5, 5, 6, 9]
Selection : [1, 2, 5, 5, 6, 9]

Long awal : [5000000000, 12, 750]
Long urut : [12, 750, 5000000000]
Double awal : [3.5, 1.2, 9.9, 2.0]
Double urut : [1.2, 2.0, 3.5, 9.9]
Float awal  : [2.5, 0.5, 4.0]
Float urut  : [0.5, 2.5, 4.0]

Negatif awal: [-3, 0, -10, 7, -3]
Bubble      : [-10, -3, -3, 0, 7]
Selection   : [-10, -3, -3, 0, 7]
Terbalik awal: [5, 4, 3, 2, 1]
Bubble       : [1, 2, 3, 4, 5]
Selection    : [1, 2, 3, 4, 5]
Sudah urut awal: [1, 2, 3, 4, 5]
Bubble         : [1, 2, 3, 4, 5]
Selection      : [1, 2, 3, 4, 5]

Array kosong: []
Satu elemen : [7]
Array null  : tidak error

List awal   : [5, 2, 9, 1]
List urut   : [1, 2, 5, 9]
```

`MainBubbleSort`

```
Awal        : [5, 2, 9, 1, 5, 6]
Terurut     : [1, 2, 5, 5, 6, 9]
Long awal   : [5000000000, 12, 750]
Long urut   : [12, 750, 5000000000]
Double awal : [3.5, 1.2, 9.9, 2.0]
Double urut : [1.2, 2.0, 3.5, 9.9]
Float awal  : [2.5, 0.5, 4.0]
Float urut  : [0.5, 2.5, 4.0]
Terbalik    : [5, 4, 3, 2, 1]
Terurut     : [1, 2, 3, 4, 5]
Sudah urut  : [1, 2, 3, 4, 5]
Tetap       : [1, 2, 3, 4, 5]
Negatif     : [-3, 0, -10, 7, -3]
Terurut     : [-10, -3, -3, 0, 7]
Kosong      : []
Satu        : [7]
Null array  : tidak error
```

The demo output labels are in Indonesian; the library code itself is in
English.
