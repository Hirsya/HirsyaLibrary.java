# queue

FIFO (first in, first out) queue backed by a singly linked list.

## Files

| File | Purpose |
|------|---------|
| `HirsyaQueue.java` | Generic queue implementation |
| `EmptyQueueException.java` | Thrown when an operation needs an element but the queue is empty |

## Design

- Private nested `Node<T>` holding `value` and `next`.
- Two references are kept: `front` (element that will be removed next) and
  `end` (last element, so appending stays O(1)).
- No dummy node: `front == null` means the queue is empty.
- `size` is stored, so `size()` and `isEmpty()` are O(1).

## Public API

| Method | Description | Complexity |
|--------|-------------|------------|
| `void add(T obj)` | Appends an element at the back | O(1) |
| `T remove()` | Removes and returns the front element | O(1) |
| `T getFront()` | Returns the front element without removing it | O(1) |
| `boolean isEmpty()` | Whether the queue has no elements | O(1) |
| `int size()` | Number of elements | O(1) |
| `void clear()` | Removes every element | O(1) |
| `String toString()` | Prints as `[a, b, c]` (front to back) | O(n) |

`remove()` and `getFront()` throw `EmptyQueueException` when the queue is empty.

## Example

```java
import HirsyaLibrary.queue.HirsyaQueue;
import HirsyaLibrary.queue.EmptyQueueException;

HirsyaQueue<String> queue = new HirsyaQueue<>();
queue.add("A");
queue.add("B");
queue.add("C");

System.out.println(queue);           // [A, B, C]
System.out.println(queue.getFront()); // A
System.out.println(queue.remove());   // A
System.out.println(queue);           // [B, C]
System.out.println(queue.size());     // 2

queue.clear();
System.out.println(queue.isEmpty());  // true

try {
    queue.remove();
} catch (EmptyQueueException e) {
    System.out.println(e.getMessage()); // Queue is empty
}
```

## Implementation notes

- When the last element is removed, `end` is reset to `null`. Forgetting this is
  the classic linked-queue bug: the queue would still look non-empty.
- Adding to an empty queue sets both `front` and `end` to the new node.

## Demo

See `../demo/MainQueue.java`.
