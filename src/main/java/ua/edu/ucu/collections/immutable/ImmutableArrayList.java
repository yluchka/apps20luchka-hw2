package ua.edu.ucu.collections.immutable;

import java.util.Arrays;

public class ImmutableArrayList implements ImmutableList {
    private Object[] elements;
    private int length;

    public ImmutableArrayList() {
        elements = new Object[0];
        length = 0;
    }

    public ImmutableArrayList(Object[] news) {
        elements = news.clone();
        length = news.length;
    }

    @Override
    public ImmutableArrayList add(Object e) {
        return add(elements.length, e);
    }

    @Override
    public ImmutableArrayList add(int index, Object e) {
        return addAll(index, new Object[]{e});
    }

    @Override
    public ImmutableArrayList addAll(Object[] c) {
        return addAll(elements.length, c);
    }

    @Override
    public ImmutableArrayList addAll(int index, Object[] c) {
        if (index < 0 || index > length) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        Object[] result = new Object[length + c.length];
        int i = length + c.length - 1;
        int iLen = length - 1;
        while (i != index + c.length - 1) {
            result[i] = elements[iLen];
            i--;
            iLen--;
        }
        int newSize = 0;
        while (newSize != c.length) {
            result[index + newSize] = c[newSize];
            newSize++;
        }
        int current = 0;
        while (current != index) {
            result[current] = elements[current];
            current++;
        }
        return new ImmutableArrayList(result);
    }

    @Override
    public Object get(int index) {
        if (index < 0 || index > length) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        return elements[index];
    }

    @Override
    public ImmutableArrayList remove(int index) {
        if (index < 0 || index > length) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        Object[] result = new Object[length - 1];
        System.arraycopy(elements, 0, result, 0, index);
        System.arraycopy(elements, index + 1, result, index,
                length - index - 1);

        return new ImmutableArrayList(result);
    }

    @Override
    public ImmutableArrayList set(int index, Object e) {
        if (index < 0 || index > length) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        Object[] result = elements.clone();
        result[index] = e;

        return new ImmutableArrayList(result);

    }

    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < length; i++) {
            if (elements[i] == e) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public ImmutableArrayList clear() {
        return new ImmutableArrayList();
    }

    @Override
    public boolean isEmpty() {
        return length == 0;
    }

    @Override
    public Object[] toArray() {
        return elements.clone();
    }
}
