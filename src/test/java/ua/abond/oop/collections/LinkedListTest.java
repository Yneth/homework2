package ua.abond.oop.collections;

public class LinkedListTest extends AbstractLinkedListTest {

    @Override
    protected List<Integer> empty() {
        return new LinkedList<>();
    }
}
