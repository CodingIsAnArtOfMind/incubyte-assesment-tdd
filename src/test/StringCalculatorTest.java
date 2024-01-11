package test;

import main.StringCalculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorTest {
    @Test
    public void shouldReturnZeroForEmptyString() {
        assertEquals(0, StringCalculator.add(""));
    }
}
