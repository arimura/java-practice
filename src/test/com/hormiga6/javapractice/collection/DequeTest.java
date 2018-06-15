package com.hormiga6.javapractice.collection;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class DequeTest {
    @Test
    public void stack(){
        Deque<String> deque = new ArrayDeque<>();
        deque.push("10");
        deque.push("500");
        deque.push("1000");

        assertThat(deque.peek(),is("1000"));
        assertThat(deque.pop(), is("1000"));
        assertThat(deque.pop(), is("500"));
    }

    @Test
    public void queue(){
        Deque<String> deque = new ArrayDeque<>();
        deque.offer("first");
        deque.offer("second");
        assertThat(deque.pop(),is("first"));
    }
}
