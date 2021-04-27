package com.company;

import java.util.HashMap;
import java.util.Map;

public class State {

    private final int stateId;
    private Map<TransactionFunction, Integer> functionMap = new HashMap<>();
    private boolean isAccepting = false;

    public State(int stateId, Map<TransactionFunction, Integer> functionMap) {
        this.stateId = stateId;
        this.functionMap = functionMap;
    }

    public State(int stateId, Map<TransactionFunction, Integer> functionMap, boolean isAccepting) {
        this.stateId = stateId;
        this.functionMap = functionMap;
        this.isAccepting = isAccepting;
    }

    public boolean isAccepting() {
        return isAccepting;
    }

    public TransactionFunction getFunctionMapByValue(char currentChar) {
        for (TransactionFunction key : functionMap.keySet()) {
            if (currentChar == key.getReadValue()) {
                return key;
            }
        }
        throw new IllegalArgumentException("Not accepting value: <" + currentChar + "> in State <" + stateId + "> ");
    }


}
