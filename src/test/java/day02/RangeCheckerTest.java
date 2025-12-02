package day02;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import resource.Reader;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RangeCheckerTest {

    Reader reader = new Reader(RangeCheckerTest.class);

    @ParameterizedTest
    @MethodSource("trivialRanges")
    void individual__trivial_range_test(String range, Long expectedValue) {
        assertEquals(expectedValue, new RangeChecker().sumTrivialSillyRanges(Stream.of(range)));
    }

    private static Stream<Arguments> trivialRanges() {
        return Stream.of(
                Arguments.of("11-22", 33L),
                Arguments.of("95-115", 99L),
                Arguments.of("998-1012", 1010L),
                Arguments.of("1188511880-1188511890", 1188511885L),
                Arguments.of("222220-222224", 222222L),
                Arguments.of("1698522-1698528", 0L),
                Arguments.of("446443-446449", 446446L),
                Arguments.of("38593856-38593862", 38593859L),
                Arguments.of("565653-565659", 0L),
                Arguments.of("824824821-824824827", 0L),
                Arguments.of("2121212118-2121212124", 0L));
    }

    @Test
    void simple_trivial_range_test() {
        assertEquals(1227775554L, new RangeChecker().sumTrivialSillyRanges(reader.getResourceAsCsv("simple_input.txt")));
    }

    @ParameterizedTest
    @MethodSource("repeatingRanges")
    void individual_repeating_range_test(String range, Long expectedValue) {
        assertEquals(expectedValue, new RangeChecker().sumRepeatableSillyRanges(Stream.of(range)));
    }

    private static Stream<Arguments> repeatingRanges() {
        return Stream.of(
                Arguments.of("11-22", 33L),
                Arguments.of("95-115", 99L + 111L),
                Arguments.of("998-1012", 999L + 1010L),
                Arguments.of("1188511880-1188511890", 1188511885L),
                Arguments.of("222220-222224", 222222L),
                Arguments.of("1698522-1698528", 0L),
                Arguments.of("446443-446449", 446446L),
                Arguments.of("38593856-38593862", 38593859L),
                Arguments.of("565653-565659", 565656L),
                Arguments.of("824824821-824824827", 824824824L),
                Arguments.of("2121212118-2121212124", 2121212121L));
    }

    @Test
    void simple_repeating_range_test() {
        assertEquals(19058204438L, new RangeChecker().sumRepeatableSillyRanges(reader.getResourceAsCsv("input.txt")));
    }
}
