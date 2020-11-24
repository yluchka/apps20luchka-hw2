package ua.edu.ucu.collections;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StackTest {

    private Stack empty;
    private Stack unitary;
    private Stack standart;

    @Before
    public void init() {
        Object[] arrayEmpty = new Object[]{};
        Object[] arrayUnitary = new Object[]{1};
        Object[] arrayStandart = new Object[]{4, 2, 7, 8};
        empty = new Stack(arrayEmpty);
        unitary = new Stack(arrayUnitary);
        standart = new Stack(arrayStandart);
    }

    @Test
    public void testPush() {
        Object[] expectedEmptyPush = new Object[]{1};
        empty.push(1);
        assertArrayEquals(expectedEmptyPush, empty.toArray());

        Object[] expectedUnitaryPush = new Object[]{2,1 };
        unitary.push(2);
        assertArrayEquals(expectedUnitaryPush, unitary.toArray());

        Object[] expectedStandartPush = new Object[]{ 1,4, 2, 7, 8};
        standart.push(1);
        assertArrayEquals(expectedStandartPush, standart.toArray());
    }

    @Test
    public void testPop() {
        Object[] expectedUnitaryPop = new Object[]{1};
        unitary.pop();
        assertArrayEquals(expectedUnitaryPop, unitary.toArray());

        Object[] expectedStandartPop = new Object[]{4, 2, 7, 8};
        standart.pop();
        assertArrayEquals(expectedStandartPop, standart.toArray());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testEmptyPop(){
        empty.pop();
    }

    @Test
    public void testPeek() {
        Object expectedValue = 4;
        Object actualVale = standart.peek();
        assertEquals(expectedValue, actualVale);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testEmptyPeek(){
        empty.peek();
    }
}