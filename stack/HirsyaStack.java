package HirsyaLibrary.stack;

public class HirsyaStack<T> {

    private static class Node<T> {
        private final T value;
        private final Node<T> next;

        private Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }

    private Node<T> topNode;
    private int size;

    public HirsyaStack() {
        this.topNode = null;
        this.size = 0;
    }

    public void push(T obj) {
        topNode = new Node<>(obj, topNode);
        size++;
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException("pop() on an empty stack");
        }
        T value = topNode.value;
        topNode = topNode.next;
        size--;
        return value;
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException("peek() on an empty stack");
        }
        return topNode.value;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void clear() {
        topNode = null;
        size = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("bottom [");
        appendFrom(sb, topNode);
        return sb.append("] top").toString();
    }

    private void appendFrom(StringBuilder sb, Node<T> node) {
        if (node == null) {
            return;
        }
        appendFrom(sb, node.next);
        sb.append(node.value);
        if (node != topNode) {
            sb.append(", ");
        }
    }
}
