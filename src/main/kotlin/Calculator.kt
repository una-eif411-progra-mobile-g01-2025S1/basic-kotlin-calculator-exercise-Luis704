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
