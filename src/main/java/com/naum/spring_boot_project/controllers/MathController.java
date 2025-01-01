package com.naum.spring_boot_project.controllers;


import com.naum.spring_boot_project.SimpleMath;
import com.naum.spring_boot_project.exceptions.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

import static com.naum.spring_boot_project.NumberConverte.convertToDouble;
import static com.naum.spring_boot_project.NumberConverte.isNumeric;

@RestController
public class MathController {

    private final AtomicLong counter = new AtomicLong();
    SimpleMath math = new SimpleMath();

    @RequestMapping(value = "/{operation}/{numberOne}/{numberTwo}")
    public Double operation(
            @PathVariable(value = "operation") String operation,
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
            ) {

        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }

        switch (operation) {
            case "sum" -> {
                return math.sum(convertToDouble(numberOne), convertToDouble(numberTwo));
            }
            case "division" -> {
                return math.division(convertToDouble(numberOne), convertToDouble(numberTwo));
            }
            case "subtraction" -> {
                return math.subtraction(convertToDouble(numberOne), convertToDouble(numberTwo));
            }
            case "multiplication" -> {
                return math.multiplication(convertToDouble(numberOne), convertToDouble(numberTwo));
            }
            case "mean" -> {
                return math.mean(convertToDouble(numberOne), convertToDouble(numberTwo));
            }
            case "squareRoot" -> {
                return math.squareRoot(convertToDouble(numberOne), convertToDouble(numberTwo));
            }
        }
        return 1D;
    }
}
