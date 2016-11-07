package ua.abond.oop.collections;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public abstract class AbstractLinkedListTest {

    protected abstract List<Integer> empty();

    private List<Integer> range(int start, int end) {
        List<Integer> list = empty();
        for (int i = start; i < end; i++) {
            list.add(i);
        }
        return list;
    }

    @Test
    public void testZeroSize() throws Exception {
        assertEquals(0, empty().size());
    }

    @Test
    public void testGet() {
        int start = 0;
        int end = 100;
        List<Integer> list = range(start, end);

        for (int i = start; i < end; i++) {
            assertEquals(new Integer(i), list.get(i));
        }
    }

    @Test
    public void testAdd() throws Exception {
        List<Integer> list = empty();

        Integer value = 10;
        list.add(value);
        assertEquals(1, list.size());
        assertEquals(value, list.get(0));

        Integer lastValue = 20;
        list.add(lastValue);
        assertEquals(value, list.get(0));
        assertEquals(lastValue, list.get(1));
        assertEquals(lastValue, list.getLast());
    }

    @Test
    public void testAddLast() throws Exception {
        List<Integer> list = empty();
        Integer value = 10;
        list.addLast(value);
        assertEquals(1, list.size());
        assertEquals(value, list.getLast());
        assertEquals(value, list.getFirst());

        Integer nextValue = 20;
        list.addLast(nextValue);
        assertEquals(nextValue, list.getLast());
        assertEquals(value, list.getFirst());
    }

    @Test
    public void testAddFirst() throws Exception {
        List<Integer> list = empty();
        Integer value = 10;
        list.addFirst(value);
        assertEquals(1, list.size());
        assertEquals(value, list.getLast());
        assertEquals(value, list.getFirst());

        Integer nextValue = 12312;
        list.addFirst(nextValue);
        assertEquals(2, list.size());
        assertEquals(nextValue, list.getFirst());
        assertEquals(value, list.getLast());
    }

    @Test
    public void testGetFirstOneElement() throws Exception {
        List<Integer> list = empty();
        list.add(1);
        assertEquals(1, list.size());
        assertEquals(new Integer(1), list.getFirst());
        assertEquals(new Integer(1), list.getLast());
    }

    @Test
    public void testGetLastOneElement() throws Exception {
        List<Integer> list = empty();
        list.add(1);
        assertEquals(1, list.size());
        assertEquals(new Integer(1), list.getLast());
    }

    @Test
    public void testIsEmpty() throws Exception {
        List<Integer> list = empty();
        assertTrue(list.isEmpty());
    }

    @Test
    public void testGetLastNonEmpty() throws Exception {
        List<Integer> list = range(0, 10);
        assertEquals(new Integer(9), list.getLast());
    }

    @Test
    public void testGetFirstNonEmpty() throws Exception {
        List<Integer> list = range(0, 10);
        assertEquals(new Integer(0), list.getFirst());
    }

    @Test
    public void testIteratorOnEmptyList() throws Exception {
        for (Integer l : range(0, 10)) {
        }
    }

    @Test
    public void testIterator() {
        int i = 0;
        for (Integer v : range(0, 10)) {
            assertEquals(new Integer(i++), v);
        }
    }

    @Test(expected = NoSuchElementException.class)
    public void testGetFirstExceptionWhenEmpty() {
        empty().getFirst();
    }

    @Test(expected = NoSuchElementException.class)
    public void testGetLastExceptionWhenEmpty() {
        empty().getLast();
    }

    @Test(expected = NoSuchElementException.class)
    public void testGetFirstException() {
        List<Integer> l = range(0, 1);
        l.remove(0);
        l.getFirst();
    }

    @Test(expected = NoSuchElementException.class)
    public void testGetLastException() {
        List<Integer> l = range(0, 1);
        l.remove(0);
        l.getLast();
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetWrongIndex() {
        range(0, 1).get(12);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveWrongIndex() {
        range(0, 1).remove(12);
    }

    @Test
    public void testRemoveFromEnd() {
        int start = 0;
        int end = 10;
        List<Integer> list = range(start, end);
        for (int i = start; i < end; i++) {
            assertEquals(new Integer(end - i - 1), list.getLast());
            list.remove(list.size() - 1);
        }
    }

    @Test
    public void testRemove() {
        int start = 0;
        int end = 10;
        List<Integer> list = range(start, end);
        for (int i = 0; i < end; i++) {
            assertEquals(new Integer(i), list.getFirst());
            list.remove(0);
        }
    }
}
