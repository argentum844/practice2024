package org.example;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CalculatorApp {
    public CalculatorAlgorithm algorithm = new CalculatorAlgorithm();
    Logger logger = LogManager.getLogger();

    public int calculate(int n1, int n2, String operator) {
        try {
            return switch (operator) {
                case "+" -> algorithm.plus(n1, n2);
                case "-" -> algorithm.minus(n1, n2);
                case "*" -> algorithm.mul(n1, n2);
                case "/" -> algorithm.div(n1, n2);
                default -> throw new ArithmeticException("No such operator");
            };
        } catch (ArithmeticException ex) {
            logger.error("Error " + ex);
            return 0;
        }
    }

    public void run() {
        try {
            int a, b;
            String operator;
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите первое число: ");
            a = scanner.nextInt();
            System.out.println("Введите второе число: ");
            b = scanner.nextInt();
            System.out.println("Введите оператор +-*/: ");
            operator = scanner.next();
            int res = calculate(a, b, operator);
            System.out.println("Result: " + res);
        } catch (NoSuchElementException | IllegalStateException ex){
            logger.error("Error " + ex);
        }
    }

}
