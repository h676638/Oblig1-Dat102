package no.hvl.data102.filmarkiv.impl;

public class LinearNode<T> {
    public T data;
    public LinearNode<T> next;

    public LinearNode(T data) {
        this.data = data;
        this.next = null;
    }
}
