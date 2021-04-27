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

    private void state02() {
        Map<TransactionFunction, Integer> functionMap = new HashMap<>();
        functionMap.put(new TransactionFunction('0', ' ', RIGHT), 3);
        stateList.add(new State(2, functionMap));
    }

    private void state03() {
        Map<TransactionFunction, Integer> functionMap = new HashMap<>();
        functionMap.put(new TransactionFunction(' ', ' ', RIGHT), 4);
        stateList.add(new State(3, functionMap));
    }

    private void state04() {
        Map<TransactionFunction, Integer> functionMap = new HashMap<>();
        functionMap.put(new TransactionFunction('0', '0', RIGHT), 7);
        functionMap.put(new TransactionFunction(' ', '0', LEFT), 5);
        stateList.add(new State(4, functionMap));
    }

    private void state05() {
        Map<TransactionFunction, Integer> functionMap = new HashMap<>();
        functionMap.put(new TransactionFunction(' ', ' ', LEFT), 5);
        functionMap.put(new TransactionFunction('0', ' ', RIGHT), 6);
        stateList.add(new State(5, functionMap));
    }


    private void state06() {
        Map<TransactionFunction, Integer> functionMap = new HashMap<>();
        functionMap.put(new TransactionFunction(' ', ' ', RIGHT), 6);
        functionMap.put(new TransactionFunction('0', '0', RIGHT), 7);
        stateList.add(new State(6, functionMap));
    }

    private void state07() {
        Map<TransactionFunction, Integer> functionMap = new HashMap<>();
        functionMap.put(new TransactionFunction(' ', '0', LEFT), 8);
        functionMap.put(new TransactionFunction('0', '0', RIGHT), 7);
        stateList.add(new State(7, functionMap));
    }

    private void state8() {
        Map<TransactionFunction, Integer> functionMap = new HashMap<>();
        functionMap.put(new TransactionFunction('0', '0', LEFT), 8);
        functionMap.put(new TransactionFunction(' ', ' ', RIGHT), 9);
        stateList.add(new State(8, functionMap));
    }

    private void state09() {
        Map<TransactionFunction, Integer> functionMap = new HashMap<>();
        functionMap.put(new TransactionFunction('0', ' ', RIGHT), 6);
        functionMap.put(new TransactionFunction('1', '1', RIGHT), 10);
        functionMap.put(new TransactionFunction(' ', ' ', LEFT), 9);
        stateList.add(new State(9, functionMap));
    }

    private void state10() {
        Map<TransactionFunction, Integer> functionMap = new HashMap<>();
        functionMap.put(new TransactionFunction('0', '0', LEFT), 11);
        functionMap.put(new TransactionFunction(' ', '0', RIGHT), 10);
        stateList.add(new State(10, functionMap));
    }

    private void state11() {
        Map<TransactionFunction, Integer> functionMap = new HashMap<>();
        functionMap.put(new TransactionFunction('0', ' ', LEFT), 12);
        stateList.add(new State(11, functionMap));
    }

    private void state12() {
        Map<TransactionFunction, Integer> functionMap = new HashMap<>();
        functionMap.put(new TransactionFunction('0', '0', LEFT), 12);
        functionMap.put(new TransactionFunction('1', '1', LEFT), 12);
        functionMap.put(new TransactionFunction(' ', ' ', RIGHT), 0);
        stateList.add(new State(12, functionMap));
    }

    private void state13() {
        Map<TransactionFunction, Integer> functionMap = new HashMap<>();
        functionMap.put(new TransactionFunction('0', ' ', RIGHT), 13);
        functionMap.put(new TransactionFunction(' ', ' ', RIGHT), 14);
        stateList.add(new State(13, functionMap));
    }

    private void state14() {
        Map<TransactionFunction, Integer> functionMap = new HashMap<>();
        stateList.add(new State(14, functionMap));
    }
}
