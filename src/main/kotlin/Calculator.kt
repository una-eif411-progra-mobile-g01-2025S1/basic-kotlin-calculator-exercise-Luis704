package org.example

class Calculator {
    fun add(a: Double, b: Double): Double {
        val result = a + b
        if (result.isInfinite()) {
            println("Error: Addition result too large")
            return -1.0
        }
        return result
    }

    fun subtract(a: Double, b: Double): Double {
        val result = a - b
        if (result.isInfinite()) {
            println("Error: Subtraction result too large")
            return -1.0
        }
        return result
    }

    fun multiply(a: Double, b: Double): Double {
        if (a == 0.0 || b == 0.0) {
            println("Error: Multiplication by 0")
            return -1.0;
        }
        val result = a * b
        if (result.isInfinite()) {
            println("Error: Multiplication result too large")
            return -1.0
        }
        return result;
    }

    fun divide(a: Double, b: Double): Double {
        if (b == 0.0) {
            println("Error: Division by 0")
            return -1.0;
        }
        val result = a / b
        if (result.isNaN() || result.isInfinite()) {
            println("Error: Division result too large")
            return -1.0;
        }
        return result;
    }
}

fun main() {
    val calculator = Calculator()

    println(calculator.add(5.0, 3.0)) // Returns 8.0
    println(calculator.add(Double.MAX_VALUE, Double.MAX_VALUE)) // Returns Error: Addition result too large, -1.0

    println(calculator.subtract(10.0, 4.0)) // Returns 6.0
    println(calculator.subtract(Double.MAX_VALUE, -Double.MAX_VALUE)) // Returns Error: Subtraction result too large, -1.0

    println(calculator.multiply(2.0, 3.0)) // Returns 6.0
    println(calculator.multiply(4.0, 0.0)) // Returns Error: Multiplication by 0, -1.0
    println(calculator.multiply(Double.MAX_VALUE, 2.0)) // Returns Error: Multiplication result too large, -1.0

    println(calculator.divide(10.0, 2.0)) // Returns 5.0
    println(calculator.divide(10.0, 0.0)) // Returns Error: Division by 0, -1.0
    println(calculator.divide(0.0, 5.0)) // Returns 0.0
    println(calculator.divide(Double.MAX_VALUE, 0.00001)) // Returns Error: Division result too large, -1.0

}