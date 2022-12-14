package org.jamesvongampai.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AppController {
    @GetMapping("/")
    public String[] getIndex() {
        String[] result = {"hello", "world"};
        return result;
    }

    @PostMapping("/calculate")
    public String calculate(int operand1, String operator, int operand2) throws IllegalAccessException {
        int result = 0;
        switch(operator) {
            case "+":
                result =  operand1 + operand2;
                break;
                case "-":
                    result =  operand1 - operand2;
                break;
                case "*":
                    result =  operand1 * operand2;
                break;
                case "/":
                    result =  operand1 / operand2;
                break;
            default:
                String message = String.format("operator '%s' is invalid", operator);
                throw new IllegalArgumentException(message);
        }
        return String.format("%s %s %s = %s", operand1, operator, operand2, result);
    }

    @DeleteMapping("/resource/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {

    }
}
