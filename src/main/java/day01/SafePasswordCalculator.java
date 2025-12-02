package day01;

import java.util.Iterator;
import java.util.stream.Stream;

public class SafePasswordCalculator {

    public Integer calculateSimple(Stream<String> instructions) {
        int count = 0;
        int position = 50;
        Iterator<String> instructionIterator = instructions.iterator();
        while (instructionIterator.hasNext()) {
            String instruction = instructionIterator.next();
            position = applyInstruction(position, instruction);
            if (position % 100 == 0) {
                count++;
            }
        }
        return count;
    }

    private int applyInstruction(int position, String instruction) {
        char direction = instruction.charAt(0);
        Integer size = Integer.parseInt(instruction.substring(1));
        return position + (direction=='R' ? size : 0-size);
    }

    public Integer calculateComplex(Stream<String> instructions) {
        SafeState countAndPosition = new SafeState();
        Iterator<String> instructionIterator = instructions.iterator();
        while (instructionIterator.hasNext()) {
            String instruction = instructionIterator.next();
            countAndPosition = countAndPosition.apply(instruction);
        }
        return countAndPosition.getCount();
    }

}
