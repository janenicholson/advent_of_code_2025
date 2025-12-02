package day02;

import java.util.Iterator;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class RangeChecker {

    Pattern trivialRepeatingPattern = Pattern.compile("^(.+)\\1$");
    Pattern multiplyRepeatingPattern = Pattern.compile("^(.+)(\\1)+$");

    public Long sumTrivialSillyRanges(Stream<String> ranges) {
        return sumSillyRanges(ranges, trivialRepeatingPattern);
    }

    public Long sumRepeatableSillyRanges(Stream<String> ranges) {
        return sumSillyRanges(ranges, multiplyRepeatingPattern);
    }

    private Long sumSillyRanges(Stream<String> ranges, Pattern repeatingPattern) {
        long sum = 0;
        Iterator<String> rangeIterator = ranges.iterator();
        while (rangeIterator.hasNext()) {
            String range = rangeIterator.next();
            String[] rangeEnds = range.split("-");
            long startRange = Long.parseLong(rangeEnds[0]);
            long endRange = Long.parseLong(rangeEnds[1]);
            for (long i = startRange; i <= endRange; i++) {
                String productId = String.format("%d", i);
                if (repeatingPattern.matcher(productId).matches()) {
                    sum += i;
                }
            }
        }
        return sum;
    }

}
