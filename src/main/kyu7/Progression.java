package kyu7;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Progression {
    public static String arithmeticSequenceElements(int first, int step, long total) {
        return IntStream.iterate(first, i -> i + step)
                .limit(total)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", "));
    }
}
