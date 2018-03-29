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

    /**
     * Note: Try to solve this task in-place (with O(1) additional memory), since this is what you'll be asked to do during an interview.

     You are given an n x n 2D matrix that represents an image. Rotate the image by 90 degrees (clockwise).

     Example

     For

     a = [[1, 2, 3],
     [4, 5, 6],
     [7, 8, 9]]
     the output should be

     rotateImage(a) =
     [[7, 4, 1],
     [8, 5, 2],
     [9, 6, 3]]
     Input/Output

     [execution time limit] 3 seconds (java)

     [input] array.array.integer a

     Guaranteed constraints:
     1 ≤ a.length ≤ 100,
     a[i].length = a.length,
     1 ≤ a[i][j] ≤ 104.

     [output] array.array.integer
     */

    public static int[][] rotateImage(int[][] a) {

        for (int i = 0; i < a.length / 2; i++) {
            for (int j = i; j < a.length-i-1; j++) {
                int rem = a[i][j];
                a[i][j] = a[a.length-j-1][i];
                a[a.length-j-1][i] = a[a.length-i-1][a.length-j-1];
                a[a.length-i-1][a.length-j-1] = a[j][a.length-i-1];
                a[j][a.length-i-1] = rem;
            }
        }
        return a;
    }

    /**
     * Sudoku is a number-placement puzzle. The objective is to fill a 9 × 9 grid with numbers in such a way that each column, each row, and each of the nine 3 × 3 sub-grids that compose the grid
     * all contain all of the numbers from 1 to 9 one time.

     Implement an algorithm that will check whether the given grid of numbers represents a valid Sudoku puzzle according to the layout rules described above.
     Note that the puzzle represented by grid does not have to be solvable.

     Example

     For

     grid = [
     ['.', '.', '.', '1', '4', '.', '.', '2', '.'],
     ['.', '.', '6', '.', '.', '.', '.', '.', '.'],
     ['.', '.', '.', '.', '.', '.', '.', '.', '.'],
     ['.', '.', '1', '.', '.', '.', '.', '.', '.'],
     ['.', '6', '7', '.', '.', '.', '.', '.', '9'],
     ['.', '.', '.', '.', '.', '.', '8', '1', '.'],
     ['.', '3', '.', '.', '.', '.', '.', '.', '6'],
     ['.', '.', '.', '.', '.', '7', '.', '.', '.'],
     ['.', '.', '.', '5', '.', '.', '.', '7', '.']]
     the output should be
     sudoku2(grid) = true;

     For

     grid = [
     ['.', '.', '.', '.', '2', '.', '.', '9', '.'],
     ['.', '.', '.', '.', '6', '.', '.', '.', '.'],
     ['7', '1', '.', '.', '7', '5', '.', '.', '.'],
     ['.', '7', '.', '.', '.', '.', '.', '.', '.'],
     ['.', '.', '.', '.', '8', '3', '.', '.', '.'],
     ['.', '.', '8', '.', '.', '7', '.', '6', '.'],
     ['.', '.', '.', '.', '.', '2', '.', '.', '.'],
     ['.', '1', '.', '2', '.', '.', '.', '.', '.'],
     ['.', '2', '.', '.', '3', '.', '.', '.', '.']]
     the output should be
     sudoku2(grid) = false.

     The given grid is not correct because there are two 1s in the second column. Each column, each row, and each 3 × 3 subgrid can only contain the numbers 1 through 9 one time.

     Input/Output

     [execution time limit] 3 seconds (java)

     [input] array.array.char grid

     A 9 × 9 array of characters, in which each character is either a digit from '1' to '9' or a period '.'.

     [output] boolean

     Return true if grid represents a valid Sudoku puzzle, otherwise return false.
     */

    public static boolean sudoku2(char[][] grid) {
        boolean isValid = false;

        if (grid.length == 9) {
            if (!gridPartition(grid)) {
                return false;
            }
        }

        for (char[] line : grid) {
            String str = new String(line).replaceAll("[^1-9]", "");
            isValid = str.chars().boxed().allMatch(c -> str.indexOf(c) == str.lastIndexOf(c));
            if(!isValid) {
                return false;
            }
        }

        for (int i = 0; i < grid.length / 2; i++) {
            for (int j = i; j < grid.length-i-1; j++) {
                char rem = grid[i][j];
                grid[i][j] = grid[grid.length-j-1][i];
                grid[grid.length-j-1][i] = grid[grid.length-i-1][grid.length-j-1];
                grid[grid.length-i-1][grid.length-j-1] = grid[j][grid.length-i-1];
                grid[j][grid.length-i-1] = rem;
            }
        }

        for (char[] line : grid) {
            String str = new String(line).replaceAll("[^1-9]", "");
            isValid = str.chars().boxed().allMatch(c -> str.indexOf(c) == str.lastIndexOf(c));
            if(!isValid) {
                return false;
            }
        }

        return isValid;
    }

    private static boolean gridPartition(char[][] grid) {
        int subI = 0;
        int subJ = 0;
        do {
            StringBuilder builder = new StringBuilder();
            for (int i = subI, row = 0; row < 3; i++, row++) {
                for (int j = subJ, col = 0; col < 3; j++, col++) {
                    builder.append(grid[i][j]);
                }
            }
            String str = builder.toString().replaceAll("[^1-9]", "");
            boolean isValid = str.chars().boxed().allMatch(c -> str.indexOf(c) == str.lastIndexOf(c));
            if (!isValid) {
                return false;
            }
            subI += subJ == 6 ? 3 : 0;
            subJ += subJ == 6 ? -6: 3;
        } while (subI <= 6);
        return true;
    }
}
