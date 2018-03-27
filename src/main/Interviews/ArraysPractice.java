package Interviews;

public class ArraysPractice {


    /**
     * Note: Write a solution with O(n) time complexity and O(1) additional space complexity, since this is what you would be asked to do during a real interview.

     Given an array a that contains only numbers in the range from 1 to a.length, find the first duplicate number for which the second occurrence has the minimal index.
     In other words, if there are more than 1 duplicated numbers, return the number for which the second occurrence has a smaller index than the second occurrence of the other number does.
     If there are no such elements, return -1.

     Example

     For a = [2, 3, 3, 1, 5, 2], the output should be
     firstDuplicate(a) = 3.

     There are 2 duplicates: numbers 2 and 3. The second occurrence of 3 has a smaller index than than second occurrence of 2 does, so the answer is 3.

     For a = [2, 4, 3, 5, 1], the output should be
     firstDuplicate(a) = -1.

     Input/Output

     [execution time limit] 3 seconds (java)

     [input] array.integer a

     Guaranteed constraints:
     1 ≤ a.length ≤ 105,
     1 ≤ a[i] ≤ a.length.

     [output] integer

     The element in a that occurs in the array more than once and has the minimal index for its second occurrence. If there are no such elements, return -1.
     */
    public static int firstDuplicate(int[] a) {
        for (int i : a) {
            int index = Math.abs(i)-1;
            if (a[index] > 0) {
                a[index] = -a[index];
            } else {
                return Math.abs(i);
            }
        }
        return -1;
    }

    /**
     * Note: Write a solution that only iterates over the string once and uses O(1) additional memory, since this is what you would be asked to do during a real interview.

     Given a string s, find and return the first instance of a non-repeating character in it. If there is no such character, return '_'.

     Example

     For s = "abacabad", the output should be
     firstNotRepeatingCharacter(s) = 'c'.

     There are 2 non-repeating characters in the string: 'c' and 'd'. Return c since it appears in the string first.

     For s = "abacabaabacaba", the output should be
     firstNotRepeatingCharacter(s) = '_'.

     There are no characters in this string that do not repeat.

     Input/Output

     [execution time limit] 3 seconds (java)

     [input] string s

     A string that contains only lowercase English letters.

     Guaranteed constraints:
     1 ≤ s.length ≤ 105.

     [output] char

     The first non-repeating character in s, or '_' if there are no characters that do not repeat.
     */

    public static char firstNotRepeatingCharacter(String s) {
        for (char c : s.toCharArray()) {
            if (s.indexOf(c) == s.lastIndexOf(c)) {
                return c;
            }
        }
        return '_';
    }
}
