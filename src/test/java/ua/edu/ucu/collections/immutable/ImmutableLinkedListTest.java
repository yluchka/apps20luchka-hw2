package ua.edu.ucu.collections.immutable;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class ImmutableLinkedListTest {

    private static ImmutableLinkedList empty;
    private static ImmutableLinkedList unitary;
    private static ImmutableLinkedList stadart;


    @BeforeClass
    public static void setUp() {
        Object[] arrayEmpty = new Object[]{};
        Object[] arrayUnitary = new Object[]{1};
        Object[] arrayStandart = new Object[]{4, 2, 7, 8};
        empty = new ImmutableLinkedList(arrayEmpty);
        unitary = new ImmutableLinkedList(arrayUnitary);
        stadart = new ImmutableLinkedList(arrayStandart);
    }


    @Test
    public void testToArray() {
        Object[] expectedFirst = new Object[]{};
        assertArrayEquals(expectedFirst, empty.toArray());
        Object[] expectedTwo = new Object[]{1};
        assertArrayEquals(expectedTwo, unitary.toArray());
        Object[] expectedThree = new Object[]{4, 2, 7, 8};
        assertArrayEquals(expectedThree, stadart.toArray());
    }


    @Test
    public void testAddMethods() {
        Object[] expectedEmptyAdd = new Object[]{1};
        Object[] actualEmptyAdd = empty.add(1).toArray();
        assertArrayEquals(expectedEmptyAdd, actualEmptyAdd);

        Object[] expectedUnitaryAdd = new Object[]{1, 7};
        Object[] actualUnitaryAdd = unitary.add(7).toArray();
        assertArrayEquals(expectedUnitaryAdd, actualUnitaryAdd);

        Object[] expectedStandartAdd = new Object[]{4, 2, 7, 8, 5};
        Object[] actualStandartAdd = stadart.add(5).toArray();
        assertArrayEquals(expectedStandartAdd, actualStandartAdd);

        Object[] expectedStandartAddLast = new Object[]{4, 2, 7, 8, 5};
        Object[] actualStandartAddLast = stadart.addLast(5).toArray();
        assertArrayEquals(expectedStandartAddLast, actualStandartAddLast);

        Object[] expectedStandartAddIndex = new Object[]{5, 4, 2, 7, 8};
        Object[] actualStandartAddIndex = stadart.add(0, 5).toArray();
        assertArrayEquals(expectedStandartAddIndex, actualStandartAddIndex);

        Object[] expectedUnitaryAddAll = new Object[]{1, 4, 2, 7, 8};
        Object[] actualUnitaryAddAll = unitary.addAll(stadart.toArray()).toArray();
        assertArrayEquals(expectedUnitaryAddAll, actualUnitaryAddAll);


        Object[] expectedUnitaryAddAllIndex = new Object[]{4, 2, 7, 8, 1};
        Object[] actualUnitaryAddAllIndex = unitary.addAll(0, stadart.toArray()).toArray();
        assertArrayEquals(expectedUnitaryAddAllIndex, actualUnitaryAddAllIndex);
    }


    @Test
    public void testRemove() {
        Object[] expectedStandartRemoveFirstEl = new Object[]{2, 7, 8};
        Object[] actualStandartRemoveFirstEL = stadart.remove(0).toArray();
        assertArrayEquals(expectedStandartRemoveFirstEl, actualStandartRemoveFirstEL);

        Object[] expectedStandartRemove = new Object[]{4, 7, 8};
        Object[] actualStandartRemove = stadart.remove(1).toArray();
        assertArrayEquals(expectedStandartRemove, actualStandartRemove);

        Object[] expectedStandartClear = new Object[]{};
        Object[] actualStandartClear = stadart.clear().toArray();
        assertArrayEquals(expectedStandartClear, actualStandartClear);

        Object[] expectedStandartRemoveFirst = new Object[]{2, 7, 8};
        Object[] actualStandartRemoveFirst = stadart.removeFirst().toArray();
        assertArrayEquals(expectedStandartRemoveFirst, actualStandartRemoveFirst);

        Object[] expectedStandartRemoveLast = new Object[]{4, 2, 7};
        Object[] actualStandartRemoveLast = stadart.removeLast().toArray();
        assertArrayEquals(expectedStandartRemoveLast, actualStandartRemoveLast);
    }

    @Test
    public void testSetting() {
        Object[] expectedStandartSet = new Object[]{4, 2, 6, 8};
        Object[] actualStandartSet = stadart.set(2, 6).toArray();
        assertArrayEquals(expectedStandartSet, actualStandartSet);
    }

    @Test
    public void testGetting() {
        assertEquals(stadart.getFirst(), 4);
        assertEquals(stadart.getLast(), 8);
        assertEquals(stadart.size(), 4);
    }

    @Test
    public void testIndex() {
        assertEquals(stadart.indexOf(4), 0);
        assertEquals(stadart.indexOf(20), -1);

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testingAddError() {
        empty.add(5, 5);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testingAddErrorSecond() {
        empty.addAll(5, stadart.toArray());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testingAddErrorThird() {
        empty.addAll(-5, stadart.toArray());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testingGetError() {
        stadart.get(10);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testingGetErrorSecond() {
        stadart.get(-10);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testingRemoveError() {
        stadart.remove(10);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testingRemoveErrorSec() {
        stadart.remove(-10);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testingRemoveFirstEmptyError() {
        empty.removeFirst();
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testingRemoveLastEmptyError() {
        empty.removeLast();
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testingRemoveErrorSecond() {
        stadart.remove(-10);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testingSetError() {
        stadart.set(-1, 5);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testingSetErrorSecond() {
        stadart.set(10, 5);
    }

    @Test
    public void testIsEmpty() {
        boolean expectedEmpty = empty.isEmpty();
        boolean actualEmpty = true;
        assertEquals(expectedEmpty, actualEmpty);
    }
}

