package day03;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import resource.Reader;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JoltAnalyserTest {

    private Reader reader = new Reader(JoltAnalyserTest.class);

    @ParameterizedTest
    @MethodSource("joltLines")
    void maximum_safe_jolt_for_a_line(Long expectedJolt, Integer scale, String line) {
        assertEquals(expectedJolt, new JoltAnalyser().analyseScaleJolt(scale, Stream.of(line)));
    }

    private static Stream<Arguments> joltLines() {
        return Stream.of(
                Arguments.of(0L, 0, "987654321111111"),
                Arguments.of(0L, 0, "811111111111119"),
                Arguments.of(0L, 0, "234234234234278"),
                Arguments.of(0L, 0, "818181911112111"),
                Arguments.of(9L, 1, "987654321111111"),
                Arguments.of(9L, 1, "811111111111119"),
                Arguments.of(8L, 1, "234234234234278"),
                Arguments.of(9L, 1, "818181911112111"),
                Arguments.of(98L, 2, "987654321111111"),
                Arguments.of(89L, 2, "811111111111119"),
                Arguments.of(78L, 2, "234234234234278"),
                Arguments.of(92L, 2, "818181911112111"),
                Arguments.of(987L, 3, "987654321111111"),
                Arguments.of(819L, 3, "811111111111119"),
                Arguments.of(478L, 3, "234234234234278"),
                Arguments.of(921L, 3, "818181911112111"));
    }

    @Test
    void maximum_safe_jolt_for_simple_input_is_357() {
        assertEquals(357, new JoltAnalyser().analyseSafeJolt(reader.getResource("simple_input.txt")));
    }

    @Test
    void maximum_scale_3_jolt_for_simple_input_is_3205() {
        assertEquals(3205, new JoltAnalyser().analyseScaleJolt(3, reader.getResource("simple_input.txt")));
    }

    @Test
    void maximum_safe_jolt_for_input_is_357() {
        assertEquals(17330, new JoltAnalyser().analyseSafeJolt(reader.getResource("input.txt")));
    }

    @Test
    void maximum_risky_jolt_for_input_is_171518260283767() {
        assertEquals(171518260283767L, new JoltAnalyser().analyseRiskyJolt(reader.getResource("input.txt")));
    }
}
