package test;

import main.StringCalculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorTest {
    @Test
    public void shouldReturnZeroForEmptyString() {
        assertEquals(0, StringCalculator.add(""));
    }
    @Test
    public void shouldReturnNumberOnNumber() {
        assertEquals(1, StringCalculator.add("1"));
    }
    @Test
    public void shouldReturnSumOnTwoNumberDelimiterByComma() {
        assertEquals(3, StringCalculator.add("1,2"));
    }
    @Test
    public void shouldReturnSumForMultipleNumbers() {
        assertEquals(10, StringCalculator.add("1,2,3,4"));
    }
    @Test
    public void shouldAcceptNewLineAsDelimiter() {
        assertEquals(6, StringCalculator.add("1,2\n3"));
    }
    @Test
    public void shouldAcceptCustomDelimiterInput() {
        assertEquals(3, StringCalculator.add("//;\n1;2"));
    }
    @Test
    public void shouldAcceptCustomDelimiterAlsoRegExpSpecialChar() {
        assertEquals(3, StringCalculator.add("//.\n1.2"));
    }

}
