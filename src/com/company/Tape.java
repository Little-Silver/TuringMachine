package com.company;

import static com.company.MultiplicationTM.SPACE_CHAR;

public class Tape {

    private int currentPos = 0;
    private String tapeRight = "";
    private String tapeLeft = "";

    public Tape() {

    }

    public Tape(String initialTape, int currentPos) {

        if (currentPos < 0 || currentPos >= initialTape.length()) {
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

    public char getCurrentValue(){
        try{
            if (currentPos >= 0) {
                return tapeRight.charAt(currentPos);
            } else {
                return tapeLeft.charAt(Math.abs(currentPos));
            }
        } catch (StringIndexOutOfBoundsException e){
            tapeRight += SPACE_CHAR;
            tapeLeft += SPACE_CHAR;
            return SPACE_CHAR;
        }

    }

    public String getCompleteTape(){
        return tapeLeft + tapeRight;
    }

    private char getCharAtPos(int pos) {
        char c = SPACE_CHAR;
        if (pos > 0) {
            if (pos>=tapeRight.length()) return c;
            c = tapeRight.charAt(pos);
        }
        return c;
    }

    public String getTapeToPrint(){
        int from = currentPos - 15;
        int to = currentPos + 15;
        String leftFromCurrentPos = "UUUUUUUUUUUUUUU"; //15x das leere Zeichen
        String rightFromCurrentPos = "UUUUUUUUUUUUUUU"; //15x das leere Zeichen

        for (int i = from; i < currentPos; i++) {
            if (i>=0) {
                leftFromCurrentPos = replaceCharAtPos(leftFromCurrentPos, getCharAtPos(i), (i-from));
            }
        }

        for (int i = currentPos+1; i <= to; i++) {
            rightFromCurrentPos = replaceCharAtPos(rightFromCurrentPos, getCharAtPos(i), (i-currentPos-1));
        }

        return leftFromCurrentPos + "[" + getCurrentValue() + "]" + rightFromCurrentPos;

    }

    public void printCurrentPos(){
        System.out.println("Current position: " + currentPos);
    }
}







