package umg.edu.gt.data_structure.queue;

public class LinkedQueue<T> implements Queue<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    @Override
    public void enqueue(T item) {
        Node<T> n = new Node<>(item);

        if (isEmpty()) {
            head = n;
            tail = n;
        } else {
            tail.next = n;
            tail = n;
        }
        size++;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new EmptyQueueException("Cannot dequeue from empty queue.");
        }

        T value = head.value;
        head = head.next;
        size--;

        if (size == 0) {
            tail = null;
        }
        return value;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new EmptyQueueException("Cannot peek from empty queue.");
        }
        return head.value;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }
}