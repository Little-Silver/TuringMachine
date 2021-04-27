package com.company;

import java.util.HashMap;
import java.util.Map;

public class State {

    private int stateId;
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
}
