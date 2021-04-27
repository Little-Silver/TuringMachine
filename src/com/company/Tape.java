package com.company;

public class Tape {

    private int currentPos = 0;
    private String tapeRight = "";
    private String tapeLeft = "";

    public Tape() {

    }

    public Tape(String initialTape, int currentPos) {

        if (currentPos <= 0 || currentPos >= initialTape.length()) {
            throw new IllegalArgumentException("Invalid Position");
        }

        this.tapeRight = initialTape;
        this.currentPos = currentPos;
    }

    public void step(TransactionFunction transactionFunction) {

        if (!isFunctionValid(transactionFunction)) {
            throw new IllegalArgumentException("Tape-Value doesn't match with value to be read");
        }

        replaceChar(transactionFunction.getWriteValue());

        switch (transactionFunction.getDirection()) {
            case RIGHT:
                moveRight();
                break;
            case LEFT:
                moveLeft();
                break;
            case STAY:
                standStill();
                break;
            default:
                throw new IllegalArgumentException("Invalid Direction");
        }

        replaceChar(transactionFunction.getWriteValue());
    }

    private boolean isFunctionValid(TransactionFunction transactionFunction) {
        char currentPosValue;
        if (currentPos >= 0) {
            currentPosValue = tapeRight.charAt(currentPos);
        } else {
            currentPosValue = tapeLeft.charAt(Math.abs(currentPos));
        }
        return (transactionFunction.getReadValue() == currentPosValue);
    }

    private void moveLeft() {
        currentPos--;
    }

    private void moveRight() {
        currentPos++;
    }

    private void standStill() {

    }

    private void replaceChar(char newChar) {

        if (currentPos >= 0) {
            tapeRight = replaceCharAtPos(tapeRight, newChar, currentPos);
        } else {
            int absPos = Math.abs(currentPos);
            tapeLeft = replaceCharAtPos(tapeLeft, newChar, absPos);
        }

    }

    private String replaceCharAtPos(String tape, char newChar, int pos) {
        return tape.substring(0, pos) + newChar + tape.substring(pos + 1);
    }

}