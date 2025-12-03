package day03;

import java.util.function.Function;
import java.util.stream.Stream;

public class JoltAnalyser {

    public Long analyseSafeJolt(Stream<String> line) {
        return line.map(lineJolt(2)).reduce(0L, Long::sum);
    }

    public Long analyseScaleJolt(int scale, Stream<String> line) {
        return line.map(lineJolt(scale)).reduce(0L, Long::sum);
    }

    public Long analyseRiskyJolt(Stream<String> line) {
        return line.map(lineJolt(12)).reduce(0L, Long::sum);
    }

    private Function<String, Long> lineJolt(int size) {
        return line -> largest(size, line);
    }

    private long largest(int size, String line) {
        long largest = 0;
        int indexOfLargest = 0;
        long rest = 0;
        if (size == 0) {
            return 0;
        }
        for (int i = 0; i <= line.length() - size; i++) {
            int candidate = line.charAt(i) - '0';
            if (candidate > largest) {
                largest = candidate;
                indexOfLargest = i;
            }
        }
        rest = largest(size - 1, line.substring(indexOfLargest + 1));
        return largest * ((long)Math.pow(10, size - 1)) + rest;
    }
}
