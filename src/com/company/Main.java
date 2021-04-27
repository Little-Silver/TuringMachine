package com.company;

import java.util.HashMap;
import java.util.Map;

import static com.company.Direction.LEFT;
import static com.company.Direction.RIGHT;

public class Main {

    public static void main(String[] args) {
        TuringMachine turingMachine = new TuringMachine();
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

        turingMachine.runTM("00010000", 0);
    }

    private static void state00(TuringMachine turingMachine) {
        Map<TransactionFunction, Integer> functionMap = new HashMap<>();
        functionMap.put(new TransactionFunction('0', ' ', RIGHT), 1);
        functionMap.put(new TransactionFunction('1', ' ', RIGHT), 13);
        turingMachine.addState(0, functionMap);
    }

    private static void state01(TuringMachine turingMachine) {
        Map<TransactionFunction, Integer> functionMap = new HashMap<>();
        functionMap.put(new TransactionFunction('0', '0', RIGHT), 1);
        functionMap.put(new TransactionFunction('1', '1', RIGHT), 1);
        functionMap.put(new TransactionFunction(' ', ' ', LEFT), 2);
        turingMachine.addState(1, functionMap);
    }

    private static void state02(TuringMachine turingMachine) {
        Map<TransactionFunction, Integer> functionMap = new HashMap<>();
        functionMap.put(new TransactionFunction('0', ' ', RIGHT), 3);
        turingMachine.addState(2, functionMap);
    }

    private static void state03(TuringMachine turingMachine) {
        Map<TransactionFunction, Integer> functionMap = new HashMap<>();
        functionMap.put(new TransactionFunction(' ', ' ', RIGHT), 4);
        turingMachine.addState(3, functionMap);
    }

    private static void state04(TuringMachine turingMachine) {
        Map<TransactionFunction, Integer> functionMap = new HashMap<>();
        functionMap.put(new TransactionFunction('0', '0', RIGHT), 7);
        functionMap.put(new TransactionFunction(' ', '0', LEFT), 5);
        turingMachine.addState(4, functionMap);
    }

    private static void state05(TuringMachine turingMachine) {
        Map<TransactionFunction, Integer> functionMap = new HashMap<>();
        functionMap.put(new TransactionFunction(' ', ' ', LEFT), 5);
        functionMap.put(new TransactionFunction('0', ' ', RIGHT), 6);
        turingMachine.addState(5, functionMap);
    }


    private static void state06(TuringMachine turingMachine) {
        Map<TransactionFunction, Integer> functionMap = new HashMap<>();
        functionMap.put(new TransactionFunction(' ', ' ', RIGHT), 6);
        functionMap.put(new TransactionFunction('0', '0', RIGHT), 7);
        turingMachine.addState(6, functionMap);
    }

    private static void state07(TuringMachine turingMachine) {
        Map<TransactionFunction, Integer> functionMap = new HashMap<>();
        functionMap.put(new TransactionFunction(' ', '0', LEFT), 8);
        functionMap.put(new TransactionFunction('0', '0', RIGHT), 7);
        turingMachine.addState(7, functionMap);
    }

    private static void state08(TuringMachine turingMachine) {
        Map<TransactionFunction, Integer> functionMap = new HashMap<>();
        functionMap.put(new TransactionFunction('0', '0', LEFT), 8);
        functionMap.put(new TransactionFunction(' ', ' ', LEFT), 9);
        turingMachine.addState(8, functionMap);
    }

    private static void state09(TuringMachine turingMachine) {
        Map<TransactionFunction, Integer> functionMap = new HashMap<>();
        functionMap.put(new TransactionFunction('0', ' ', RIGHT), 6);
        functionMap.put(new TransactionFunction('1', '1', RIGHT), 10);
        functionMap.put(new TransactionFunction(' ', ' ', LEFT), 9);
        turingMachine.addState(9, functionMap);
    }

    private static void state10(TuringMachine turingMachine) {
        Map<TransactionFunction, Integer> functionMap = new HashMap<>();
        functionMap.put(new TransactionFunction('0', '0', LEFT), 11);
        functionMap.put(new TransactionFunction(' ', '0', RIGHT), 10);
        turingMachine.addState(10, functionMap);
    }

    private static void state11(TuringMachine turingMachine) {
        Map<TransactionFunction, Integer> functionMap = new HashMap<>();
        functionMap.put(new TransactionFunction('0', ' ', LEFT), 12);
        turingMachine.addState(11, functionMap);
    }

    private static void state12(TuringMachine turingMachine) {
        Map<TransactionFunction, Integer> functionMap = new HashMap<>();
        functionMap.put(new TransactionFunction('0', '0', LEFT), 12);
        functionMap.put(new TransactionFunction('1', '1', LEFT), 12);
        functionMap.put(new TransactionFunction(' ', ' ', RIGHT), 0);
        turingMachine.addState(12, functionMap);
    }

    private static void state13(TuringMachine turingMachine) {
        Map<TransactionFunction, Integer> functionMap = new HashMap<>();
        functionMap.put(new TransactionFunction('0', ' ', RIGHT), 13);
        functionMap.put(new TransactionFunction(' ', ' ', RIGHT), 14);
        turingMachine.addState(13, functionMap);
    }

    private static void state14(TuringMachine turingMachine) {
        Map<TransactionFunction, Integer> functionMap = new HashMap<>();
        turingMachine.addStateAccepting(14, functionMap);
    }
}
