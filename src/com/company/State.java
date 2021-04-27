package com.company;

import java.util.HashMap;
import java.util.Map;

public class State {

    private int stateId;
    private Map<TransactionFunction, Integer> functionMap = new HashMap<>();

    public State(int stateId, Map<TransactionFunction, Integer> functionMap) {
        this.stateId = stateId;
        this.functionMap = functionMap;
    }

}
