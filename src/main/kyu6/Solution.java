package kyu6;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    public static boolean isAlt(String word) {
        List<Character> vowels = "aeiou".chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        List<Character> charList = word.chars().mapToObj(c -> (char) c).collect(Collectors.toList());

        return IntStream.range(0, charList.size() - 1).allMatch(i -> (vowels.contains(charList.get(i)) && !vowels.contains(charList.get(i+1))) || (!vowels.contains(charList.get(i)) && vowels.contains(charList.get(i+1))));
    }

    public static boolean isAlt2(String word) {
        return  word.matches("[aeiou]?([^aeiou][aeiou])*[^aeiou]?");
    }
}
