package ua.abond.oop.collections;

public interface List<T> extends Iterable<T> {
    void add(T value);
    T get(int index);

    void remove(T value);
    void remove(int index);

    int size();
    boolean isEmpty();

    T getFirst();
    T getLast();

    void addFirst(T value);
    void addLast(T value);
}
