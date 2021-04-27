package com.company;

public class Main {

    public static void main(String[] args) {
        MultiplicationTM turingMachine = new MultiplicationTM();

        turingMachine.multiply("00010000", 0, true);
    }

}
