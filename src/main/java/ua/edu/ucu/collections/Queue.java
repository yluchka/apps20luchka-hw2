package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Queue {
    private ImmutableLinkedList elements;

    public Queue() {
        elements = new ImmutableLinkedList();
    }

    public Queue(Object e) {
        elements = new ImmutableLinkedList(new Object[]{e});
    }

    public Queue(Object[] data) {
        elements = new ImmutableLinkedList(data);
    }

    public Object peek() {
        if (elements.size() == 0) {
            throw new IndexOutOfBoundsException();
        }
        return elements.getFirst();
    }

    public Object dequeue() {
        Object result = peek();
        elements.removeLast();
        return result;
    }

    public void enqueue(Object e) {
        elements = elements.addFirst(e);
    }


    public Object[] toArray() {
        return elements.toArray();
    }
}