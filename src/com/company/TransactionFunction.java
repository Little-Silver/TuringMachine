package com.company;

/**
 * Transaction-Function: \u03B4
 */
public class TransactionFunction {

    private final char readValue;
    private final char writeValue;
    private final Direction direction;

    public TransactionFunction(char readValue, char writeValue, Direction direction) {
        this.readValue = readValue;
        this.writeValue = writeValue;
        this.direction = direction;
    }

    public void print(){
        System.out.println(readValue + " / " + writeValue + ", " + direction.getDirectionSymbol());
    }

    public char getReadValue() {
        return readValue;
    }

    public char getWriteValue() {
        return writeValue;
    }

    public Direction getDirection() {
        return direction;
    }

}
