package org.example;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.*;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class TqsStackTest {
    private TqsStack<String> stack3elems;

    @BeforeEach
    public void InitialSetup(){
        System.out.println("before eachhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
        stack3elems  = new TqsStack();
        stack3elems.push("Dragon");
        stack3elems.push("Parrot");
        stack3elems.push("Phoenix");
    }

    @Test
    public void isEmpty() {
        System.out.println("aaaaaaaaaaaa");
        // a)
        TqsStack <String> emptyStack = new TqsStack();
        Assertions.assertTrue(emptyStack.isEmpty(), "Empty stack should be empty bruh.");
    }

    @Test
    @DisplayName("Size tests")
    public void size() {
        stack3elems  = new TqsStack();
        stack3elems.push("Dragon");
        stack3elems.push("Parrot");
        stack3elems.push("Phoenix");
        //b)
        TqsStack <String> newStack = new TqsStack();
        assertEquals(0,newStack.size());
        //c)
        assertEquals(3,stack3elems.size());
    }
    @Test
    public void pop() {
        //d)
        stack3elems  = new TqsStack();
        stack3elems.push("Dragon");
        stack3elems.push("Parrot");
        stack3elems.push("Phoenix");
        assertEquals("Phoenix",stack3elems.pop());
    }

    @Test
    public void peek() {
        // e)
        stack3elems  = new TqsStack();
        stack3elems.push("Dragon");
        stack3elems.push("Parrot");
        stack3elems.push("Phoenix");
        assertEquals("Phoenix",stack3elems.peek());
        assertEquals(3,stack3elems.size());
    }

    @Test
    public void Npops_Nsize(){
        //f
        stack3elems  = new TqsStack();
        stack3elems.push("Dragon");
        stack3elems.push("Parrot");
        stack3elems.push("Phoenix");
        stack3elems.pop();
        stack3elems.pop();
        stack3elems.pop();
        assertEquals(0,stack3elems.size());
        Assertions.assertTrue(stack3elems.isEmpty(), "size 3 should be empty after 3 pops.");
    }

    @Test
    public void popEmpty(){
        //g
        TqsStack <String> emptyStack = new TqsStack();
        Assertions.assertThrows(NoSuchElementException.class, ()-> emptyStack.pop());
    }

    @Test
    public void peekEmpty() {
        // h)
        TqsStack <String> emptyStack = new TqsStack();
        Assertions.assertThrows(NoSuchElementException.class, ()-> emptyStack.peek());
    }

    @Test
    public void push() {
        stack3elems  = new TqsStack();
        stack3elems.push("Dragon");
        stack3elems.push("Parrot");
        stack3elems.push("Phoenix");
        //i)
        if(stack3elems.getBound()!=-1 && stack3elems.size()==stack3elems.getBound()){
            Assertions.assertThrows(IllegalStateException.class, ()-> stack3elems.push("new"));
        }
        else {
            stack3elems.push("new");
            Assertions.assertFalse(stack3elems.isEmpty(), "After 1 push, there should be atleast 1 element.");
            assertEquals(4, stack3elems.size());
        }
    }
}