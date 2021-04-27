package com.company;

public enum Direction {
    RIGHT('R'),
    LEFT('L'),
    STAY('S');

    private final char directionSymbol;

    Direction(char directionSymbol) {
        this.directionSymbol = directionSymbol;
    }

    public char getDirectionSymbol() {
        return directionSymbol;
    }
}
