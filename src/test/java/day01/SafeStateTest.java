package day01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class SafeStateTest {

    @Test
    void ends_at_0() {
        SafeState expected = new SafeState();
        expected.setCount(1);
        expected.setPosition(0);
        assertEquals(expected, new SafeState().apply("L50"));
    }

    @Test
    void ends_at_1() {
        SafeState expected = new SafeState();
        expected.setCount(0);
        expected.setPosition(1);
        assertEquals(expected, new SafeState().apply("L49"));
    }

    @Test
    void ends_at_99() {
        SafeState expected = new SafeState();
        expected.setCount(1);
        expected.setPosition(99);
        assertEquals(expected, new SafeState().apply("L51"));
    }

    @Test
    void ends_at_100() {
        SafeState expected = new SafeState();
        expected.setCount(1);
        expected.setPosition(0);
        assertEquals(expected, new SafeState().apply("R50"));
    }

    @Test
    void ends_at_R99() {
        SafeState expected = new SafeState();
        expected.setCount(0);
        expected.setPosition(99);
        assertEquals(expected, new SafeState().apply("R49"));
    }

    @Test
    void ends_at_101() {
        SafeState expected = new SafeState();
        expected.setCount(1);
        expected.setPosition(1);
        assertEquals(expected, new SafeState().apply("R51"));
    }
}
