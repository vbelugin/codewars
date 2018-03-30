import Interviews.ArraysPractice;
import kyu6.Dinglemouse;
import kyu6.Solution;
import kyu7.Printer;
import kyu7.Progression;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void basicTests() {
        assertEquals("Lew", Kata.declareWinner(new Fighter("Lew", 10, 2),new Fighter("Harry", 5, 4), "Lew"));
        System.out.println();
        assertEquals("Harry", Kata.declareWinner(new Fighter("Lew", 10, 2),new Fighter("Harry", 5, 4), "Harry"));
        System.out.println();
        assertEquals("Harald", Kata.declareWinner(new Fighter("Harald", 20, 5), new Fighter("Harry", 5, 4), "Harry"));
        System.out.println();
        assertEquals("Harald", Kata.declareWinner(new Fighter("Harald", 20, 5), new Fighter("Harry", 5, 4), "Harald"));
        System.out.println();
        assertEquals("Harald", Kata.declareWinner(new Fighter("Jerry", 30, 3), new Fighter("Harald", 20, 5), "Jerry"));
        System.out.println();
        assertEquals("Harald", Kata.declareWinner(new Fighter("Jerry", 30, 3), new Fighter("Harald", 20, 5), "Harald"));
    }

    private String[][] fighters = new String[][]{
            new String[] { "Ryu", "E.Honda", "Blanka", "Guile", "Balrog", "Vega" },
            new String[] { "Ken", "Chun Li", "Zangief", "Dhalsim", "Sagat", "M.Bison" },
    };

    @Test
    public void shouldWorkWithNoMoves() {
        String[] solution = new String[]{};
        assertArrayEquals(solution, Kata.streetFighterSelection(fighters, new int[]{0,0}, new String[]{}));
    }

    @Test
    public void shouldWorkWithFewMoves(){
        String[] moves = new String[] { "up", "left", "right", "left", "left" };
        String[] solution = new String[] { "Ryu", "Vega", "Ryu", "Vega", "Balrog" };
        assertArrayEquals(solution, Kata.streetFighterSelection(fighters, new int[] {0,0}, moves));
    }

    @Test
    public void shouldWorkWhenAlwaysMovingLeft(){
        String[] moves = new String[] { "left", "left", "left", "left", "left", "left", "left", "left" };
        String[] solution = new String[] { "Vega", "Balrog", "Guile", "Blanka", "E.Honda", "Ryu", "Vega", "Balrog" };
        assertArrayEquals(solution, Kata.streetFighterSelection(fighters, new int[] {0,0}, moves));
    }

    @Test
    public void shouldWorkWhenAlwaysMovingRight(){
        String[] moves = new String[] { "right", "right", "right", "right", "right", "right", "right", "right" };
        String[] solution = new String[] { "E.Honda", "Blanka", "Guile", "Balrog", "Vega", "Ryu", "E.Honda", "Blanka" };
        assertArrayEquals(solution, Kata.streetFighterSelection(fighters, new int[] {0,0}, moves));
    }

    @Test
    public void shouldUseAll4DirectionsClockwiseTwice(){
        String[] moves = new String[] { "up", "left", "down", "right", "up", "left", "down", "right" };
        String[] solution = new String[] { "Ryu", "Vega", "M.Bison", "Ken", "Ryu", "Vega", "M.Bison", "Ken" };
        assertArrayEquals(solution, Kata.streetFighterSelection(fighters, new int[] {0,0}, moves));
    }

    @Test
    public void shouldWorkWhenAlwaysMovingDown(){
        String[] moves = new String[] { "down", "down", "down", "down" };
        String[] solution = new String[] { "Ken", "Ken", "Ken", "Ken" };
        assertArrayEquals(solution, Kata.streetFighterSelection(fighters, new int[] {0,0}, moves));
    }

    @Test
    public void shouldWorkWhenAlwaysMovingUp(){
        String[] moves = new String[] { "up", "up", "up", "up" };
        String[] solution = new String[] { "Ryu", "Ryu", "Ryu", "Ryu" };
        assertArrayEquals(solution, Kata.streetFighterSelection(fighters, new int[] {0,0}, moves));
    }

    @Test
    public void exampleTests() {
        assertEquals(true, Solution.isAlt2("amazon"));
        assertEquals(false, Solution.isAlt2("apple"));
        assertEquals(true, Solution.isAlt2("banana"));
    }

    @Test
    public void shouldPassFixedTests() {
        assertEquals("1, 2, 3, 4, 5, 6, 7, 8, 9, 10", Progression.arithmeticSequenceElements(1, 1, 10));
        assertEquals("1, 3, 5, 7, 9", Progression.arithmeticSequenceElements(1, 2, 5));
        assertEquals("1, -2, -5, -8, -11, -14, -17, -20, -23, -26", Progression.arithmeticSequenceElements(1, -3, 10));
        assertEquals("100, 90, 80, 70, 60, 50, 40, 30, 20, 10", Progression.arithmeticSequenceElements(100, -10, 10));
    }

    /**
     * Tests for The Freeway Game
     */
    @Test
    public void overtaker() {
        // I overtake some cars
        final int count = Dinglemouse.freewayGame(50.0, 130.0, new double[][]{{-1.0, 120.0}, {-1.5, 120.0}});
        assertEquals(2, count);
    }

    @Test
    public void overtaken() {
        // Some cars overtake me
        final int count = Dinglemouse.freewayGame(50.0, 110.0, new double[][]{{1.0, 120.0}, {1.5, 125.0}});
        assertEquals(-2, count);
    }

    @Test
    public void overtakeAndOvertaken() {
        // I overtake some cars and some cars overtake me. Overall count = 0
        final int count = Dinglemouse.freewayGame(50.0, 120.0, new double[][]{{-1.0, 115.0}, {-1.5, 110.0},{1.0, 130.0}, {1.5, 130.0}});
        assertEquals(0, count);
    }

    @Test
    public void cantOvertakeFasterCars() {
        // All cars ahead of me are going faster
        final int count = Dinglemouse.freewayGame(30.0, 100.0, new double[][]{{-1.0, 110.0}, {-0.7, 102.0}, {-1.5, 108.0}});
//        assertEquals(0, count);
    }

    @Test
    public void cantBeOvertakenBySlowerCars() {
        // All cars behind me are going slower
        final int count = Dinglemouse.freewayGame(30.0, 130.0, new double[][]{{1.0, 120.0}, {0.7, 125.0}, {1.5, 110.0}});
        assertEquals(0, count);
    }
    //==========End of The Freeway Game test block=========//

    @Test
    public void printerTest() {
        System.out.println("printerError Fixed Tests");
        String s="aaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbmmmmmmmmmmmmmmmmmmmxyz";
        assertEquals("3/56", Printer.printerError(s));
    }

    @Test
    public void firstDuplicate1() {
        int[] arr = new int[]{2, 3, 3, 1, 5, 2};
        assertEquals(3, ArraysPractice.firstDuplicate(arr));
    }

    @Test
    public void firstDuplicate2() {
        int[] arr = new int[]{2, 4, 3, 5, 1};
        assertEquals(-1, ArraysPractice.firstDuplicate(arr));
    }

    @Test
    public void firstDuplicate3() {
        int[] arr = new int[]{8, 4, 6, 2, 6, 4, 7, 9, 5, 8};
        assertEquals(6, ArraysPractice.firstDuplicate(arr));
    }

    @Test
    public void firstNotRepeat1() {
        String s = "abacabad";
        assertEquals('c', ArraysPractice.firstNotRepeatingCharacter(s));
    }

    @Test
    public void rotateImage1() {
        int[][] board   = new int[][] {
                new int[] {1, 2, 3},
                new int[] {4, 5, 6},
                new int[] {7, 8, 9}};
        int[][] solution = new int[][] {
                new int[] {7, 4, 1},
                new int[] {8, 5, 2},
                new int[] {9, 6, 3}};
        assertArrayEquals(solution, ArraysPractice.rotateImage(board));
    }

    @Test
    public void sudoku2Test() {
        char[][] grid = new char[][]{
                new char[]{'.', '.', '.', '.', '2', '.', '.', '9', '.'},
                new char[]{'.', '.', '.', '.', '6', '.', '.', '.', '.'},
                new char[]{'7', '1', '.', '.', '7', '5', '.', '.', '.'},
                new char[]{'.', '7', '.', '.', '.', '.', '.', '.', '.'},
                new char[]{'.', '.', '.', '.', '8', '3', '.', '.', '.'},
                new char[]{'.', '.', '8', '.', '.', '7', '.', '6', '.'},
                new char[]{'.', '.', '.', '.', '.', '2', '.', '.', '.'},
                new char[]{'.', '1', '.', '2', '.', '.', '.', '.', '.'},
                new char[]{'.', '2', '.', '.', '3', '.', '.', '.', '.'}};
        assertFalse(ArraysPractice.sudoku2(grid));
    }

    @Test
    public void sudoku2Test2() {
        char[][] grid = new char[][]{
                new char[]{'.', '.', '.', '1', '4', '.', '.', '2', '.'},
                new char[]{'.', '.', '6', '.', '.', '.', '.', '.', '.'},
                new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                new char[]{'.', '.', '1', '.', '.', '.', '.', '.', '.'},
                new char[]{'.', '6', '7', '.', '.', '.', '.', '.', '9'},
                new char[]{'.', '.', '.', '.', '.', '.', '8', '1', '.'},
                new char[]{'.', '3', '.', '.', '.', '.', '.', '.', '6'},
                new char[]{'.', '.', '.', '.', '.', '7', '.', '.', '.'},
                new char[]{'.', '.', '.', '5', '.', '.', '.', '7', '.'}};
        assertTrue(ArraysPractice.sudoku2(grid));
    }


    @Test
    public void sudoku2Test3() {
        char[][] grid = new char[][]{
                new char[]{'.', '.', '.', '.', '.', '.', '5', '.', '.'},
                new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                new char[]{'9', '3', '.', '.', '2', '.', '4', '.', '.'},
                new char[]{'.', '.', '7', '.', '.', '.', '3', '.', '.'},
                new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                new char[]{'.', '.', '.', '3', '4', '.', '.', '.', '.'},
                new char[]{'.', '.', '.', '.', '.', '3', '.', '.', '.'},
                new char[]{'.', '.', '.', '.', '.', '5', '2', '.', '.'}};
        assertFalse(ArraysPractice.sudoku2(grid));
    }

    @Test
    public void isCryptSolution1() {
        String[] crypt = new String[]{"SEND", "MORE", "MONEY"};
        char[][] solution = new char[][] {
                new char[]{'O', '0'},
                new char[]{'M', '1'},
                new char[]{'Y', '2'},
                new char[]{'E', '5'},
                new char[]{'N', '6'},
                new char[]{'D', '7'},
                new char[]{'R', '8'},
                new char[]{'S', '9'}};
        assertTrue(ArraysPractice.isCryptSolution(crypt, solution));
    }

}
