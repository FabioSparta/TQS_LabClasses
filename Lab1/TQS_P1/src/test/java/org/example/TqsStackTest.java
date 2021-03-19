package org.example;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import java.util.NoSuchElementException;
import java.util.Stack;

import static org.junit.Assert.*;

public class TqsStackTest {
    TqsStack stack3elems;

    @BeforeEach
    public void InitialSetup(){
        stack3elems  = new TqsStack();
        stack3elems.push("Dragon");
        stack3elems.push("Parrot");
        stack3elems.push("Phoenix");
    }

    @Test
    public void isEmpty() {
        TqsStack <String> emptyStack = new TqsStack();
        Assertions.assertTrue(emptyStack.isEmpty(), "Empty stack should be empty bruh.");
    }

    @Test
    public void push() {
        if(stack3elems.getBound()!=-1 && stack3elems.size()==stack3elems.getBound()){
            Assertions.assertThrows(IllegalStateException.class, ()-> stack3elems.push("new"));
        }
        else {
            stack3elems.push("new");
            Assertions.assertFalse(stack3elems.isEmpty(), "After 1 push, there should be atleast 1 element.");
            assertEquals(4, stack3elems.size());
        }
    }

    @Test
    public void pop() {
        assertEquals("Phoenix",stack3elems.pop());
    }

    @Test
    public void popEmpty(){
        TqsStack <String> emptyStack = new TqsStack();
        Assertions.assertThrows(NoSuchElementException.class, ()-> emptyStack.pop());
    }

    @Test
    public void peek() {
        assertEquals("Phoenix",stack3elems.peek());
        assertEquals(3,stack3elems.size());
    }

    @Test
    @DisplayName("Size tests")
    public void size() {
        TqsStack <String> newStack = new TqsStack();
        assertEquals(0,stack3elems.size());
        assertEquals(3,stack3elems.size());
    }
    @Test
    public void Npops_Nsize(){
        stack3elems.pop();
        stack3elems.pop();
        stack3elems.pop();
        assertEquals(0,stack3elems.size());
        Assertions.assertTrue(stack3elems.isEmpty(), "size 3 should be empty after 3 pops.");
    }



}