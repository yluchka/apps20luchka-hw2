package ua.edu.ucu.collections.immutable;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class ImmutableArrayListTest {

    private static ImmutableArrayList empty;
    private static ImmutableArrayList unitary;
    private static ImmutableArrayList stadart;


    @BeforeClass
    public static void setUp() {
        Object[] arrayEmpty = new Object[]{};
        Object[] arrayUnitary = new Object[]{1};
        Object[] arrayStandart = new Object[]{4, 2, 7, 8};
        empty = new ImmutableArrayList(arrayEmpty);
        unitary = new ImmutableArrayList(arrayUnitary);
        stadart = new ImmutableArrayList(arrayStandart);
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

    @Test(expected = IndexOutOfBoundsException.class)
    public void testingAddError() {
        empty.add(5, 5);
        empty.addAll(5, stadart.toArray());
        empty.addAll(-4, stadart.toArray());
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

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testingRemoveError() {
        stadart.remove(10);
        stadart.remove(-10);
    }

    @Test
    public void testIsEmpty() {
        boolean expectedEmpty = empty.isEmpty();
        boolean actualEmpty = true;
        assertEquals(expectedEmpty, actualEmpty);
    }

    @Test
    public void testIndex() {
        assertEquals(stadart.indexOf(4), 0);
        assertEquals(stadart.indexOf(20), -1);

    }

    @Test
    public void testGetting() {
        assertEquals(stadart.get(0), 4);
        assertEquals(stadart.size(), 4);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testingGetError() {
        stadart.get(-10);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testingGetErrorSecond() {
        stadart.get(-10);
    }

    @Test
    public void testSetting() {
        Object[] expectedStandartSet = new Object[]{4, 2, 6, 8};
        Object[] actualStandartSet = stadart.set(2, 6).toArray();
        assertArrayEquals(expectedStandartSet, actualStandartSet);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testingSetError() {
        stadart.set(-1, 5);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testingSetErrorSecond() {
        stadart.set(10, 5);
    }
}