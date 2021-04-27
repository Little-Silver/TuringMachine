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
    void multiplyBasic7x4() {
        int result = turingMachine.multiply("000000010000", 0, false);
        assertEquals(28, result);
    }

    @Test
    void multiplyBasic3x4() {
        int result = turingMachine.multiply("00010000", 0, false);
        assertEquals(12, result);
    }

    @Test
    void multiplyBasic2x5() {
        int result = turingMachine.multiply("00100000", 0, false);
        assertEquals(10, result);
    }

    @Test
    void multiplyStartWithZero() {
        int result = turingMachine.multiply("1000", 0, false);
        assertEquals(0, result);
    }

    @Test
    void multiplyEndWithZero() {
        int result = turingMachine.multiply("0001", 0, false);
        assertEquals(0, result);
    }

    @Test
    void multiplyZeroWithZero() {
        int result = turingMachine.multiply("1", 0, false);
        assertEquals(0, result);
    }
}