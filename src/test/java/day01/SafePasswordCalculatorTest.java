package day01;

import org.junit.jupiter.api.Test;
import resource.Reader;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SafePasswordCalculatorTest {

    Reader resourceReader = new Reader(SafePasswordCalculatorTest.class);

    @Test
    void short_simple_password_is_3() {
        assertEquals(3, new SafePasswordCalculator().calculateSimple(resourceReader.getResource("simple_input.txt")));
    }

    @Test
    void long_simple_password_is_1105() {
        assertEquals(1105, new SafePasswordCalculator().calculateSimple(resourceReader.getResource("input.txt")));
    }

    @Test
    void short_complex_password_is_6() {
        assertEquals(6, new SafePasswordCalculator().calculateComplex(resourceReader.getResource("simple_input.txt")));
    }

    @Test
    void long_complex_password_is_6599() {
        assertEquals(6599, new SafePasswordCalculator().calculateComplex(resourceReader.getResource("input.txt")));
    }
}
