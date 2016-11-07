package ua.abond.oop.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class LinkedList<T> implements List<T> {
    private int size;
    private Node<T> head;
    private Node<T> tail;

    public LinkedList() {
        size = 0;
        head = null;
        tail = null;
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        return node(index).value;
    }

    @Override
    public void remove(T value) {
        Objects.requireNonNull(value);
        Node<T> node = head;
        while (node != null) {
            if (node.value.equals(value)) {
                unlink(node);
                break;
            }
            node = node.next;
        }
    }

    @Override
    public void remove(int index) {
        checkIndex(index);
        unlink(node(index));
    }

    @Override
    public T getFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        return head.value;
    }

    @Override
    public T getLast() {
        if (tail == null) {
            throw new NoSuchElementException();
        }
        return tail.value;
    }

    @Override
    public void add(T value) {
        addLast(value);
    }

    @Override
    public void addFirst(T value) {
        Node<T> node = new Node<>(value);
        if (isEmpty()) {
            head = node;
            tail = head;
        } else {
            head.prev = node;
            node.next = head;
            head = node;
        }
        size++;
    }

    @Override
    public void addLast(T value) {
        Node<T> node = new Node<>(value);
        if (isEmpty()) {
            head = node;
            tail = head;
        }
        else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    private void checkIndex(int index) {
        if (index >= size || size < 0) {
            throw new ArrayIndexOutOfBoundsException("Index: " + index + ", list size: " + size);
        }
    }

    private void unlink(Node<T> node) {
        Node<T> prev = node.prev;
        Node<T> next = node.next;
        if (prev == null) {
            head = next;
        } else {
            prev.next = next;
            node.prev = null;
        }

        if (next == null) {
            tail = prev;
        } else {
            next.prev = prev;
            node.next = null;
        }
        node.value = null;
        size--;
    }

    private Node<T> node(int index) {
        Node<T> node;
        if (index < (size >> 1)) {
            node = head;
            for (int i = 0; i < index; i++)
                node = node.next;
        } else {
            node = tail;
            for (int i = size - 1; i > index; i--)
                node = node.prev;
        }
        return node;
    }

    private static class Node<T> {
        T value;
        Node<T> next;
        Node<T> prev;

        Node(T value) {
            this(value, null, null);
        }

        Node(T value, Node<T> next, Node<T> prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }

    public class LinkedListIterator implements Iterator<T> {
        private Node<T> node;

        LinkedListIterator() {
            this.node = head;
        }

        @Override
        public boolean hasNext() {
            return node == null || node.next != null;
        }

        @Override
        public T next() {
            if (node == null) {
                throw new NoSuchElementException();
            }
            T val = node.value;
            node = node.next;
            return val;
        }
    }
}
