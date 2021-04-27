package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.company.Direction.LEFT;
import static com.company.Direction.RIGHT;

public class TuringMachine {

    private State currentState;
    List<State> stateList = new ArrayList<>();

    public TuringMachine() {
        state00();
        state01();
    }

    public void addState(int stateId, Map<TransactionFunction, Integer> functionMap){
        State state = new State(stateId, functionMap);
        if(stateId == 0){
            currentState = state;
        }
        stateList.add(state);
    }

    public void runTM(String input, int startPos){
        Tape tape = new Tape(input, startPos);

        while(!currentState.isAccepting()){

        }
    }

    private void state00() {
        Map<TransactionFunction, Integer> functionMap = new HashMap<>();
        functionMap.put(new TransactionFunction('0', ' ', RIGHT), 1);
        functionMap.put(new TransactionFunction('1', ' ', RIGHT), 13);
        stateList.add(new State(0, functionMap));
    }

    private void state01() {
        Map<TransactionFunction, Integer> functionMap = new HashMap<>();
        functionMap.put(new TransactionFunction('0', '0', RIGHT), 1);
        functionMap.put(new TransactionFunction('1', '1', RIGHT), 1);
        functionMap.put(new TransactionFunction(' ', ' ', LEFT), 2);
        stateList.add(new State(1, functionMap));
    }

}
