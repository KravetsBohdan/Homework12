package com.bkravets.structures;

import com.bkravets.exceptions.EmptyStackException;
import com.bkravets.exceptions.FullStackException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;


class MyStackTest {

    MyStack emptyStack;
    MyStack fullStack;

    @BeforeEach
    void setUp() {
        emptyStack = new MyStack();

        fullStack = new MyStack(1);
        fullStack.push(10);
    }

    @Test
    void push_shouldTrowExceptionWhenStackIsFull() {

        Assertions.assertThatThrownBy(() -> fullStack.push(9))
                .isInstanceOf(FullStackException.class)
                .hasMessage("Stack is already full");
    }

    @Test
    void pop_shouldTrowExceptionWhenStackIsEmpty() {

        Assertions.assertThatThrownBy(() -> emptyStack.pop())
                .isInstanceOf(EmptyStackException.class)
                .hasMessage("Stack is empty");
    }

    @Test
    void peek_returnEmptyOptionalWhenStackIsEmpty() {
        Optional<Integer> empty = emptyStack.peek();

        Assertions.assertThat(empty).isEmpty();
    }

    @Test
    void peek_returnOptionalValueWhenStackIsNotEmpty() {

        Optional<Integer> peek = fullStack.peek();

        Assertions.assertThat(peek)
                .isPresent()
                .contains(10);
    }
}