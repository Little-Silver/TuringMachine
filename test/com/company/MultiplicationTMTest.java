package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MultiplicationTMTest {

    MultiplicationTM turingMachine;

    @BeforeEach
    void setUp(){
        turingMachine = new MultiplicationTM();
    }

    @Test
    void multiply() {
        int result = turingMachine.multiply("00010000", 0, true);
        assertEquals(12, result);
    }
}