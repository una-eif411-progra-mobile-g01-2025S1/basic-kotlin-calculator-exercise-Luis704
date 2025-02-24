import org.example.Calculator;
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import kotlin.test.assertEquals


class CalculatorTest {
    private lateinit var calculator: Calculator

    private val standardOut = System.out

    private val outputStreamCaptor = ByteArrayOutputStream()


    @BeforeEach
    fun setUp() {
        calculator = Calculator()
        System.setOut(PrintStream(outputStreamCaptor))
    }

    @AfterEach
    fun tearDown() {
        System.setOut(standardOut)
        outputStreamCaptor.reset()
    }

    @Nested
    inner class BasicOperations {
        @Test
        fun testAdditionPositiveNumbers() {
            assertEquals(5.0, calculator.add(2.0, 3.0))
        }

        @Test
        fun testSubtractionPositiveNumbers() {
            assertEquals(1.0, calculator.subtract(3.0, 2.0))
        }

        @Test
        fun testMultiplicationPositiveNumbers() {
            assertEquals(6.0, calculator.multiply(2.0, 3.0))
        }

        @Test
        fun testDivisionPositiveNumbers() {
            assertEquals(2.0, calculator.divide(6.0, 3.0))
        }

        @Test
        fun testAdditionNegativeNumbers() {
            assertEquals(-5.0, calculator.add(-2.0, -3.0))
        }
        @Test
        fun testSubtractionNegativeNumbers() {
            assertEquals(-1.0, calculator.subtract(-3.0, -2.0))
        }

        @Test
        fun testMultiplicationNegativeNumbers() {
            assertEquals(-6.0, calculator.multiply(-2.0, 3.0))
        }

        @Test
        fun testDivisionNegativeNumbers() {
            assertEquals(-2.0, calculator.divide(-6.0, 3.0))
        }
    }

    @Nested
    inner class ErrorCases {
        @Test
        fun testAdditionMaxLargeNumbers() {
            assertEquals(-1.0, calculator.add(Double.MAX_VALUE, Double.MAX_VALUE))
            assertEquals("Error: Addition result too large", outputStreamCaptor.toString().trim())
        }

        @Test
        fun testSubtractionMaxLargeNumbers() {
            assertEquals(-1.0, calculator.subtract(Double.MAX_VALUE, -Double.MAX_VALUE))
            assertEquals("Error: Subtraction result too large", outputStreamCaptor.toString().trim())
        }

        @Test
        fun testMultiplicationByZero() {
            assertEquals(-1.0, calculator.multiply(10.0, 0.0))
            assertEquals("Error: Multiplication by 0", outputStreamCaptor.toString().trim())
        }

        @Test
        fun testMultiplicationMaxLargeNumbers(){
            assertEquals(-1.0, calculator.multiply(Double.MAX_VALUE, 2.0))
            assertEquals("Error: Multiplication result too large", outputStreamCaptor.toString().trim())
        }

        @Test
        fun testDivisionByZero() {
            assertEquals(-1.0, calculator.divide(10.0, 0.0))
            assertEquals("Error: Division by 0", outputStreamCaptor.toString().trim())
        }

        @Test
        fun testDivisionMaxLargeNumbers(){
            assertEquals(-1.0, calculator.divide(Double.MAX_VALUE, 0.00001))
            assertEquals("Error: Division result too large", outputStreamCaptor.toString().trim())
        }
    }
}