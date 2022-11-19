package com.bkravets.structures;

import com.bkravets.exceptions.EmptyStackException;
import com.bkravets.exceptions.FullStackException;

import java.util.Optional;

public class MyStack implements Stackable {
    private final Integer[] stack;
    private Integer top;

    public MyStack(int capacity) {
        stack = new Integer[capacity];
        top = -1;
    }

    public MyStack() {
        this(8);
    }


    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public boolean isFull() {
        return top == stack.length - 1;
    }

    @Override
    public void push(int element) {
        if (isFull()) throw new FullStackException();
        stack[++top] = element;
    }

    @Override
    public Integer pop() {
        if (isEmpty()) throw new EmptyStackException();
        return stack[top--];
    }

    @Override
    public Optional<Integer> peek() {
        if (isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(stack[top]);
    }
}
