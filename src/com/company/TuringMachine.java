package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TuringMachine {

    List<State> stateList = new ArrayList<>();
    private boolean stepMode = false;
    private int stepCounter = 0;
    private State currentState;
    private BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in));

    public TuringMachine() {

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

    private void printTMInformation(Tape tape) {
        if(stepMode){
            /*try {
                String var = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }*/
        }
        System.out.println("State: q_" + currentState.getStateId());
        System.out.printf("Tape: %s %n", tape.getCompleteTape());
        System.out.println("Step-Counter: " + stepCounter);
    }

    public Tape runTM(String input, int startPos, boolean stepMode){
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
