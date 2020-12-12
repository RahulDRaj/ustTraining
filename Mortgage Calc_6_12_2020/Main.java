package com.mortgage;

public class Main {

    public static void main(String[] args){
        int principal = (int) Console.readNumber("Principal: ", 1000, 10_00_000);
        float annualInterest = (float) Console.readNumber("Annual Interest Rate: ", 1, 30);
        byte years = (byte) Console.readNumber("Period (Years): ", 1, 30);

        var calulator = new MortgageCalculator(principal, annualInterest, years);

        NewPrint print = new NewPrint();
        print.mortgagePrint(new MortgageReport(calulator));
        print.printSchedule(new MortgageReport(calulator));


    }
}