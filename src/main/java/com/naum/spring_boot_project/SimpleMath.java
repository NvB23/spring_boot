package com.naum.spring_boot_project;

public class SimpleMath {

    public Double sum(
            double numberOne,
            double numberTwo
    )
    {
        return numberOne + numberTwo;
    }

    public Double subtraction(
            double numberOne,
            double numberTwo
    )
    {
        return numberOne - numberTwo;
    }


    public Double division(
            double numberOne, double numberTwo
    )
    {

        return numberOne / numberTwo;
    }

    public Double multiplication(
            double numberOne,
            double numberTwo
    )
    {
        return numberOne * numberTwo;
    }


    public Double mean(
            double numberOne,
            double numberTwo
    )
    {
        return (numberOne + numberTwo) / 2;
    }


    public Double squareRoot(
            double numberOne,
            double numberTwo
    )
    {
        return Math.pow(numberOne, 1/numberTwo);
    }
}
