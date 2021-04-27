package com.company;

/**
 * Transaction-Function: \u03B4
 */
public class TransactionFunction {

    private char readValue;
    private char writeValue;
    private Direction direction;

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

    public void setReadValue(char readValue) {
        this.readValue = readValue;
    }

    public char getWriteValue() {
        return writeValue;
    }

    public void setWriteValue(char writeValue) {
        this.writeValue = writeValue;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
