package ua.edu.ucu.collections;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class QueueTest {

    private Queue empty;
    private Queue unitary;
    private Queue standart;

    @Before
    public void init() {
        Object[] arrayEmpty = new Object[]{};
        Object[] arrayUnitary = new Object[]{1};
        Object[] arrayStandart = new Object[]{4, 2, 7, 8};
        empty = new Queue(arrayEmpty);
        unitary = new Queue(arrayUnitary);
        standart = new Queue(arrayStandart);
    }

    @Test
    public void testPeek() {
        Object expectedValue = 4;
        Object actualVale = standart.peek();
        assertEquals(expectedValue, actualVale);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testEmptyPeek() {
        empty.peek();
    }

    @Test
    public void testDequeue() {
        unitary.dequeue();
        Object[] expectedUnitary = new Object[]{1};
        assertArrayEquals(expectedUnitary, unitary.toArray());

        standart.dequeue();
        Object[] expectedStandart = new Object[]{4, 2, 7, 8};
        assertArrayEquals(expectedStandart, standart.toArray());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testEmptyDequeue() {
        empty.dequeue();
    }

    @Test
    public void testEnqueue() {
        Object[] expectedEmpty = new Object[]{1};
        empty.enqueue(1);
        assertArrayEquals(expectedEmpty, empty.toArray());

        Object[] expectedUnitary = new Object[]{5, 1};
        unitary.enqueue(5);
        assertArrayEquals(expectedUnitary, unitary.toArray());

        Object[] expectedStandart = new Object[]{5, 4, 2, 7, 8};
        standart.enqueue(5);
        assertArrayEquals(expectedStandart, standart.toArray());
    }


}

