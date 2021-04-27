package com.company;

import java.util.*;

public class TuringMachine {


    private final char[] alphabet;
    List<State> stateList = new ArrayList<>();
    private boolean stepMode = false;
    private int stepCounter = 0;
    private State currentState;
    private Scanner scanner = new Scanner(System.in);

    public TuringMachine(char[] alphabet) {
        this.alphabet = alphabet;
    }

    public void addState(int stateId, Map<TransactionFunction, Integer> functionMap) {
        State state = new State(stateId, functionMap);
        if (stateId == 0) {
            currentState = state;
        }
        stateList.add(state);
    }

    public void addStateAccepting(int stateId, Map<TransactionFunction, Integer> functionMap) {
        State state = new State(stateId, functionMap, true);
        if (stateId == 0) {
            currentState = state;
        }
        stateList.add(state);
    }

    public Tape runTM(String input, int startPos) {
        Tape tape = new Tape(input, startPos);

        char currentChar;
        int nextState;
        printTMInformation(tape);
        while (!currentState.isAccepting()) {
            currentChar = tape.getCurrentValue();
            if (!isInAlphabet(currentChar)) {
                throw new IllegalArgumentException("Input: <" + currentChar + "> doesn't exist in the given alphabet");
            }
            TransactionFunction function = currentState.getFunctionMapByValue(currentChar);
            tape.step(function);
            if (!currentState.isAccepting()) {
                nextState = currentState.getNextStateId(function);
                currentState = getStateById(nextState);
            }
            stepCounter++;
            printTMInformation(tape);
        }
        return tape;
    }

    private boolean isInAlphabet(char value) {
        for (char c : alphabet) {
            if (c == value) {
                return true;
            }
        }
        return false;
    }

    private void printTMInformation(Tape tape) {
        if (stepMode) {
            try {
                System.out.println("\nEingabe drücken, um den nächsten Step anzuzeigen.");
                String var = scanner.nextLine();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("State: q_" + currentState.getStateId());
        System.out.printf("Tape: %s %n", tape.getCompleteTape());
        tape.printCurrentPos();
        System.out.println("Step-Counter: " + stepCounter);
    }

    public Tape runTM(String input, int startPos, boolean stepMode) {
        this.stepMode = stepMode;
        return runTM(input, startPos);
    }

    private State getStateById(int stateId) {
        for (State state : stateList) {
            if (state.getStateId() == stateId) {
                return state;
            }
        }
        throw new IllegalArgumentException("Couldn't find state");
    }

}
