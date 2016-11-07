package ua.abond.oop.collections;

public class SinglyLinkedListTest extends AbstractLinkedListTest {

    @Override
    protected SinglyLinkedList<Integer> empty() {
        return new SinglyLinkedList<>();
    }
}