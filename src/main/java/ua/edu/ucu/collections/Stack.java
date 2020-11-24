package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack {
    private ImmutableLinkedList elements;

    public Stack() {
        elements = new ImmutableLinkedList();
    }

    public Stack(Object e) {
        elements = new ImmutableLinkedList(new Object[]{e});
    }

    public Stack(Object[] data) {
        elements = new ImmutableLinkedList(data);
    }

    public Object peek() {
        if (elements.size() == 0) {
            throw new IndexOutOfBoundsException();
        }
        return elements.getFirst();
    }

    public Object pop() {
        Object result = peek();
        elements.removeFirst();
        return result;
    }

    public void push(Object e) {
        elements = elements.addFirst(e);
    }


    public Object[] toArray() {
        return elements.toArray();
    }
}