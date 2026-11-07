# linkedlist

Singly linked list with O(1) append and O(1) removal at both ends.

## Files

| File | Purpose |
|------|---------|
| `HirsyaLinkedList.java` | Generic singly linked list |

## Design

- Private nested `Node<T>` holding `data` and `next`.
- Two references: `head` (first node) and `tail` (last node), so appending and
  reading the last element never require a full traversal.
- No dummy node: `head == null` means the list is empty.
- `size` is stored, so `size()` and `isEmpty()` are O(1).
- There is no separate `Node.java`/`Entity.java`; the node is an internal detail
  and the list is not tied to any domain class.

## Public API

| Method | Description | Complexity |
|--------|-------------|------------|
| `void add(T data)` | Appends at the end | O(1) |
| `void addFirst(T data)` | Inserts at the front | O(1) |
| `void insertAt(int index, T data)` | Inserts at an index | O(n) |
| `T getAt(int index)` | Returns the element at an index | O(n) |
| `T getFirst()` | Returns the first element | O(1) |
| `T getLast()` | Returns the last element | O(1) |
| `boolean delete(T data)` | Removes the first matching element | O(n) |
| `boolean contains(T data)` | Whether an element exists | O(n) |
| `int indexOf(T data)` | Index of the first match, or `-1` | O(n) |
| `boolean isEmpty()` | Whether the list has no elements | O(1) |
| `int size()` | Number of elements | O(1) |
| `void clear()` | Removes every element | O(1) |
| `String toString()` | Prints as `[a, b, c]` | O(n) |

`getAt`, `insertAt`, `getFirst` and `getLast` throw `IndexOutOfBoundsException`
for invalid indexes or empty lists. `delete` and `contains` never throw; they
report the result with a `boolean`.

## Example

```java
import HirsyaLibrary.linkedlist.HirsyaLinkedList;

HirsyaLinkedList<String> list = new HirsyaLinkedList<>();
list.add("A");
list.add("B");
list.add("C");

System.out.println(list);            // [A, B, C]
System.out.println(list.getFirst()); // A
System.out.println(list.getLast());  // C
System.out.println(list.getAt(1));   // B

list.addFirst("Z");
System.out.println(list);            // [Z, A, B, C]

list.insertAt(2, "X");
System.out.println(list);            // [Z, A, X, B, C]

System.out.println(list.contains("B")); // true
System.out.println(list.indexOf("C"));  // 4

System.out.println(list.delete("B"));   // true
System.out.println(list);               // [Z, A, X, C]

list.clear();
System.out.println(list.isEmpty());     // true
```

## Implementation notes

- `delete` handles three cases: removing the head, removing the tail (which must
  also move `tail` back to the previous node), and removing from the middle.
- `equalsData` guards against `null` elements, so the list can store `null`
  values and still compare safely.
- `insertAt(index == size)` is routed to `add`, and `index == 0` to `addFirst`,
  so the general traversal path only runs for middle insertions.

## Demo

See `../demo/MainLinkedList.java`.
