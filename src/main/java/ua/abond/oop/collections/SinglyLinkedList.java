package ua.abond.oop.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SinglyLinkedList<T> implements List<T> {
    private int size;
    private Node<T> first;
    private Node<T> last;

    public SinglyLinkedList() {
        size = 0;
        first = null;
        last = null;
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        return node(index).value;
    }

    @Override
    public void remove(T value) {
        Objects.requireNonNull(value);
        if (first.value.equals(value)) {
            first = first.next;
        } else {
            unlinkNext(findPrevious(value));
        }
        size--;
        if (isEmpty()) {
            first = last = null;
        }
    }

    @Override
    public void remove(int index) {
        checkIndex(index);
        if (index == 0) {
            first = first.next;
        } else {
            unlinkNext(findPrevious(index));
        }
        size--;
        if (isEmpty()) {
            first = last = null;
        }
    }

    @Override
    public T getFirst() {
        if (first == null) {
            throw new NoSuchElementException();
        }
        return first.value;
    }

    @Override
    public T getLast() {
        if (last == null) {
            throw new NoSuchElementException();
        }
        return last.value;
    }

    @Override
    public void add(T value) {
        addLast(value);
    }

    @Override
    public void addFirst(T value) {
        Node<T> node = new Node<>(value);
        if (isEmpty()) {
            first = node;
            last = first;
        } else {
            node.next = first;
            first = node;
        }
        size++;
    }

    @Override
    public void addLast(T value) {
        Node<T> node = new Node<>(value);
        if (isEmpty()) {
            last = node;
            first = last;
        } else {
            last.next = node;
            last = node;
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
        return new SinglyLinkedListIterator();
    }

    private boolean unlinkNext(Node<T> prev) {
        if (prev == null) {
            return false;
        }
        Node<T> toRemove = prev.next;
        Node<T> next = prev.next.next;

        if (next == null) {
            last = prev;
        }
        prev.next = next;

        toRemove.next = null;
        toRemove.value = null;

        return true;
    }

    private Node<T> findPrevious(int index) {
        return node(index - 1);
    }

    private Node<T> findPrevious(T value) {
        if (first == null) {
            return null;
        }
        Node<T> result = first;
        while (result.next != null) {
            if (result.next.value.equals(value)) {
                return result;
            }
        }
        return null;
    }

    private Node<T> node(int index) {
        Node<T> result = first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result;
    }

    private void checkIndex(int index) {
        if (index >= size || size < 0) {
            throw new ArrayIndexOutOfBoundsException("Index was: " + index + ", list size: " + size);
        }
    }

    private class SinglyLinkedListIterator implements Iterator<T> {
        private Node<T> node;

        SinglyLinkedListIterator() {
            this.node = first;
        }

        @Override
        public boolean hasNext() {
            return node != null && node.next != null;
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

    private static class Node<T> {
        T value;
        Node<T> next;

        Node(T value) {
            this(value, null);
        }

        Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}
