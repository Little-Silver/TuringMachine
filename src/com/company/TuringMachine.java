package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TuringMachine {

    List<State> stateList = new ArrayList<>();
    private State currentState;

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

    public void runTM(String input, int startPos) {
        Tape tape = new Tape(input, startPos);

        char currentChar;
        int nextState;
        while (!currentState.isAccepting()) {
            currentChar = tape.getCurrentValue();
            TransactionFunction function = currentState.getFunctionMapByValue(currentChar);
            tape.step(function);
            if (currentState.isAccepting()) {
                nextState = currentState.getNextStateId(function);
                currentState = getStateById(nextState);
            }
        }
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
