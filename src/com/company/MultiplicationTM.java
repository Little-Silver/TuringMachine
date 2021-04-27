package com.company;

import java.util.HashMap;
import java.util.Map;

import static com.company.Direction.LEFT;
import static com.company.Direction.RIGHT;

public class MultiplicationTM
{
    private final TuringMachine turingMachine;
    public static final char SPACE_CHAR = 'U';
    public static final char ZERO = '0';
    public static final char ONE = '1';

    public MultiplicationTM() {

        turingMachine = new TuringMachine();

        state00(turingMachine);
        state01(turingMachine);
        state02(turingMachine);
        state03(turingMachine);
        state04(turingMachine);
        state05(turingMachine);
        state06(turingMachine);
        state07(turingMachine);
        state08(turingMachine);
        state09(turingMachine);
        state10(turingMachine);
        state11(turingMachine);
        state12(turingMachine);
        state13(turingMachine);
        state14(turingMachine);
    }

    public int multiply(String input, int startPos, boolean stepMode) {
        Tape finalTape = turingMachine.runTM(input, startPos, stepMode);
        return countZero(finalTape);
    }

    private int countZero(Tape finalTape) {

        String someString = finalTape.getCompleteTape();
        char someChar = ZERO;
        int count = 0;

        for (int i = 0; i < someString.length(); i++) {
            if (someString.charAt(i) == someChar) {
                count++;
            }
        }
        System.out.println("*****************************************************************");
        System.out.println("Result: " + count);
        System.out.println("*****************************************************************");

        return count;
    }

    private void state00(TuringMachine turingMachine) {
        Map<TransactionFunction, Integer> functionMap = new HashMap<>();
        functionMap.put(new TransactionFunction(ZERO, SPACE_CHAR, RIGHT), 1);
        functionMap.put(new TransactionFunction(ONE, SPACE_CHAR, RIGHT), 13);
        turingMachine.addState(0, functionMap);
    }

    private void state01(TuringMachine turingMachine) {
        Map<TransactionFunction, Integer> functionMap = new HashMap<>();
        functionMap.put(new TransactionFunction(ZERO, ZERO, RIGHT), 1);
        functionMap.put(new TransactionFunction(ONE, ONE, RIGHT), 1);
        functionMap.put(new TransactionFunction(SPACE_CHAR, SPACE_CHAR, LEFT), 2);
        turingMachine.addState(1, functionMap);
    }

    private void state02(TuringMachine turingMachine) {
        Map<TransactionFunction, Integer> functionMap = new HashMap<>();
        functionMap.put(new TransactionFunction(ZERO, SPACE_CHAR, RIGHT), 3);
        turingMachine.addState(2, functionMap);
    }

    private void state03(TuringMachine turingMachine) {
        Map<TransactionFunction, Integer> functionMap = new HashMap<>();
        functionMap.put(new TransactionFunction(SPACE_CHAR, SPACE_CHAR, RIGHT), 4);
        turingMachine.addState(3, functionMap);
    }

    private void state04(TuringMachine turingMachine) {
        Map<TransactionFunction, Integer> functionMap = new HashMap<>();
        functionMap.put(new TransactionFunction(ZERO, ZERO, RIGHT), 7);
        functionMap.put(new TransactionFunction(SPACE_CHAR, ZERO, LEFT), 5);
        turingMachine.addState(4, functionMap);
    }

    private void state05(TuringMachine turingMachine) {
        Map<TransactionFunction, Integer> functionMap = new HashMap<>();
        functionMap.put(new TransactionFunction(SPACE_CHAR, SPACE_CHAR, LEFT), 5);
        functionMap.put(new TransactionFunction(ZERO, SPACE_CHAR, RIGHT), 6);
        turingMachine.addState(5, functionMap);
    }


    private void state06(TuringMachine turingMachine) {
        Map<TransactionFunction, Integer> functionMap = new HashMap<>();
        functionMap.put(new TransactionFunction(SPACE_CHAR, SPACE_CHAR, RIGHT), 6);
        functionMap.put(new TransactionFunction(ZERO, ZERO, RIGHT), 7);
        turingMachine.addState(6, functionMap);
    }

    private void state07(TuringMachine turingMachine) {
        Map<TransactionFunction, Integer> functionMap = new HashMap<>();
        functionMap.put(new TransactionFunction(SPACE_CHAR, ZERO, LEFT), 8);
        functionMap.put(new TransactionFunction(ZERO, ZERO, RIGHT), 7);
        turingMachine.addState(7, functionMap);
    }

    private void state08(TuringMachine turingMachine) {
        Map<TransactionFunction, Integer> functionMap = new HashMap<>();
        functionMap.put(new TransactionFunction(ZERO, ZERO, LEFT), 8);
        functionMap.put(new TransactionFunction(SPACE_CHAR, SPACE_CHAR, LEFT), 9);
        turingMachine.addState(8, functionMap);
    }

    private void state09(TuringMachine turingMachine) {
        Map<TransactionFunction, Integer> functionMap = new HashMap<>();
        functionMap.put(new TransactionFunction(ZERO, SPACE_CHAR, RIGHT), 6);
        functionMap.put(new TransactionFunction(ONE, ONE, RIGHT), 10);
        functionMap.put(new TransactionFunction(SPACE_CHAR, SPACE_CHAR, LEFT), 9);
        turingMachine.addState(9, functionMap);
    }

    private void state10(TuringMachine turingMachine) {
        Map<TransactionFunction, Integer> functionMap = new HashMap<>();
        functionMap.put(new TransactionFunction(ZERO, ZERO, LEFT), 11);
        functionMap.put(new TransactionFunction(SPACE_CHAR, ZERO, RIGHT), 10);
        turingMachine.addState(10, functionMap);
    }

    private void state11(TuringMachine turingMachine) {
        Map<TransactionFunction, Integer> functionMap = new HashMap<>();
        functionMap.put(new TransactionFunction(ZERO, SPACE_CHAR, LEFT), 12);
        turingMachine.addState(11, functionMap);
    }

    private void state12(TuringMachine turingMachine) {
        Map<TransactionFunction, Integer> functionMap = new HashMap<>();
        functionMap.put(new TransactionFunction(ZERO, ZERO, LEFT), 12);
        functionMap.put(new TransactionFunction(ONE, ONE, LEFT), 12);
        functionMap.put(new TransactionFunction(SPACE_CHAR, SPACE_CHAR, RIGHT), 0);
        turingMachine.addState(12, functionMap);
    }

    private void state13(TuringMachine turingMachine) {
        Map<TransactionFunction, Integer> functionMap = new HashMap<>();
        functionMap.put(new TransactionFunction(ZERO, SPACE_CHAR, RIGHT), 13);
        functionMap.put(new TransactionFunction(SPACE_CHAR, SPACE_CHAR, RIGHT), 14);
        turingMachine.addState(13, functionMap);
    }

    private void state14(TuringMachine turingMachine) {
        Map<TransactionFunction, Integer> functionMap = new HashMap<>();
        turingMachine.addStateAccepting(14, functionMap);
    }
}
