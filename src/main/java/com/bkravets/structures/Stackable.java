package com.bkravets.structures;

import java.util.Optional;

public interface Stackable {

    boolean isEmpty();

    boolean isFull();

    void push(int element);

    Integer pop();

    Optional<Integer> peek();
}
