package org.example;

import java.util.Stack;

public class TqsStack<T> {
    Stack<T> istack;
    int bound=-1;

    public boolean isEmpty(){
        if (istack.isEmpty())
            return true;
        return false;
    }

    public void push(T element){

    }
    public T pop(){
        return null;
    }

    public T peek(){
        return null;
    }

    public int size(){
        return -1;
    }

    public void setBound(int bound) {
        this.bound = bound;
    }

    public int getBound() {
        return bound;
    }
}
