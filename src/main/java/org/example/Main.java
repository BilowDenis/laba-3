package org.example;

public class Main {
    static int n = 5;
    static int a = 432;
    static int b = 213;
    static int sum = a + b;

    public static void main(String[] args) {
        long recursionResult = Factorial.recursion(n);
        long cycleResult = Factorial.cycle(n);

        assert recursionResult == cycleResult : "Factorial - Different values";
        System.out.println("Factorial of " + n + ": " + recursionResult);

        recursionResult = Fibonacci.recursion(n);
        cycleResult = Fibonacci.cycle(n);

        assert recursionResult == cycleResult : "Fibonacci - Different values";
        System.out.println("Fibonacci of " + n + ": " + cycleResult);

        int sumOfDigitsResult = SumOfDigits.execute(sum);
        System.out.println("SumOfDigits " +  sum + " = " + sumOfDigitsResult);

        int sumWithoutOperatorResult = SumWithoutOperator.execute(a, b);
        assert sumWithoutOperatorResult == sum : "Different values sum";
        System.out.println(a + " + "+ b + " = " + sum);
    }
}

class Factorial {
    public static long cycle(int n) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static long recursion(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * recursion(n - 1);
    }
}

class Fibonacci {
    public static long cycle(int n) {
        if (n <= 1) {
            return n;
        }
        long a = 0, b = 1, result = 0;
        for (int i = 2; i <= n; i++) {
            result = a + b;
            a = b;
            b = result;
        }
        return result;
    }

    public static long recursion(int n) {
        if (n <= 1) {
            return n;
        }
        return recursion(n - 1) + recursion(n - 2);
    }
}

class SumOfDigits {
    public static int execute(int n) {
        if (n < 10) {
            return n;
        }
        return n % 10 + execute(n / 10);
    }
}

class SumWithoutOperator {
    public static int execute(int a, int b) {
        if (b == 0) {
            return a;
        }
        int sum = a ^ b;
        int carry = (a & b) << 1;
        return execute(sum, carry);
    }
}