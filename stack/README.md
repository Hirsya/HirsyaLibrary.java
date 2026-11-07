# stack

LIFO (last in, first out) stack backed by a singly linked list.

## Files

| File | Purpose |
|------|---------|
| `HirsyaStack.java` | Generic stack implementation |
| `EmptyStackException.java` | Thrown when an operation needs an element but the stack is empty |

## Design

- Private nested `Node<T>` holding `value` and `next`.
- A single reference `topNode` points at the most recently pushed element.
- Pushing prepends a node, which keeps it O(1) and needs no tail reference.
- `size` is stored, so `size()` and `isEmpty()` are O(1).

## Public API

| Method | Description | Complexity |
|--------|-------------|------------|
| `void push(T obj)` | Pushes an element on top | O(1) |
| `T pop()` | Removes and returns the top element | O(1) |
| `T peek()` | Returns the top element without removing it | O(1) |
| `boolean isEmpty()` | Whether the stack has no elements | O(1) |
| `int size()` | Number of elements | O(1) |
| `void clear()` | Removes every element | O(1) |
| `String toString()` | Prints as `bottom [a, b] top` | O(n) |

`pop()` and `peek()` throw `EmptyStackException` when the stack is empty.

## Example

```java
import HirsyaLibrary.stack.HirsyaStack;
import HirsyaLibrary.stack.EmptyStackException;

HirsyaStack<Integer> stack = new HirsyaStack<>();
stack.push(1);
stack.push(2);
stack.push(3);

System.out.println(stack);        // bottom [1, 2, 3] top
System.out.println(stack.peek()); // 3
System.out.println(stack.pop());  // 3
System.out.println(stack.size()); // 2

stack.clear();
System.out.println(stack.isEmpty()); // true

try {
    stack.pop();
} catch (EmptyStackException e) {
    System.out.println(e.getMessage()); // pop() on an empty stack
}
```

## Implementation notes

- `toString()` prints bottom-to-top, which is how people read a stack written on
  paper. It is built recursively without any helper collection, so the library
  does not depend on `java.util`.
- Because nodes are prepended, the stack holds the elements in reverse order of
  insertion internally; `toString()` compensates by appending while unwinding
  the recursion.

## Demo

See `../demo/MainStack.java`.
