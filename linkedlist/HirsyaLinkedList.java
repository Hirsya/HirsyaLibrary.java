package HirsyaLibrary.linkedlist;

public class HirsyaLinkedList<T> {

    private static class Node<T> {
        private final T data;
        private Node<T> next;

        private Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public HirsyaLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void add(T data) {
        Node<T> newNode = new Node<>(data, null);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }

    public void addFirst(T data) {
        head = new Node<>(data, head);
        if (tail == null) {
            tail = head;
        }
        size++;
    }

    public void insertAt(int index, T data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        }
        if (index == 0) {
            addFirst(data);
        } else if (index == size) {
            add(data);
        } else {
            Node<T> prev = head;
            for (int i = 0; i < index - 1; i++) {
                prev = prev.next;
            }
            prev.next = new Node<>(data, prev.next);
            size++;
        }
    }

    public T getAt(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    public T getFirst() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("List is empty");
        }
        return head.data;
    }

    public T getLast() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("List is empty");
        }
        return tail.data;
    }

    public boolean delete(T data) {
        if (isEmpty()) {
            return false;
        }
        if (equalsData(head.data, data)) {
            head = head.next;
            if (head == null) {
                tail = null;
            }
            size--;
            return true;
        }
        Node<T> prev = head;
        Node<T> current = head.next;
        while (current != null) {
            if (equalsData(current.data, data)) {
                prev.next = current.next;
                if (current == tail) {
                    tail = prev;
                }
                size--;
                return true;
            }
            prev = current;
            current = current.next;
        }
        return false;
    }

    public boolean contains(T data) {
        for (Node<T> current = head; current != null; current = current.next) {
            if (equalsData(current.data, data)) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(T data) {
        int index = 0;
        for (Node<T> current = head; current != null; current = current.next) {
            if (equalsData(current.data, data)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    private boolean equalsData(T a, T b) {
        if (a == null) {
            return b == null;
        }
        return a.equals(b);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (Node<T> current = head; current != null; current = current.next) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(", ");
            }
        }
        return sb.append("]").toString();
    }
}
