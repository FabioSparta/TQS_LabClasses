package org.example;

import java.util.NoSuchElementException;
import java.util.Stack;

public class TqsStack<T> {
    Stack<T> istack;
    int bound=-1;

    public TqsStack() {
        this.istack = new Stack<>();
    }

    public boolean isEmpty(){
        if (istack.isEmpty())
            return true;
        return false;
    }

    public void push(T element){
        istack.push(element);
    }
    public T pop(){
        if(istack.isEmpty()){
            throw new NoSuchElementException();
        }
        return istack.pop();
    }

    public T peek(){
        if(istack.isEmpty()){
            throw new NoSuchElementException();
        }
        return istack.peek();
    }

    public int size(){
        return istack.size();
    }

    public void setBound(int bound) {
        this.bound = bound;
    }

    public int getBound() {
        return bound;
    }
}
