package day01;

import lombok.Data;

@Data
public class SafeState {
    private int count = 0;
    private int position = 50;

    public SafeState apply(String instruction) {
        boolean startedFromZero = position == 0;
        char direction = instruction.charAt(0);
        int magnitude = Integer.parseInt(instruction.substring(1));
        if (magnitude == 0) {
            return this;
        }
        switch (direction) {
        case 'R', 'r':
            position += magnitude;
            while (position >= 100) {
                position -= 100;
                count++;
            }
            break;
        case 'L', 'l':
            if (startedFromZero) {
                position = 100;
            }
            position -= magnitude;
            while (position < 0) {
                position += 100;
                count++;
            }
            if (position == 0) {
                count++;
            }
            break;
        default:
        }
        return this;
    }
}
