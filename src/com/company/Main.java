package com.company;

public class Main {

    public static void main(String[] args) {
        MultiplicationTM turingMachine = new MultiplicationTM();

        turingMachine.multiply("00100", 0, true);
    }

}
