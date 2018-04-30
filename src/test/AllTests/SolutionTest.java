package AllTests;

import Interviews.ArraysPractice;
import firstKatas.Fighter;
import firstKatas.Kata;
import firstKatas.Percentile;
import kyu6.Dinglemouse;
import kyu6.Solution;
import kyu7.Printer;
import kyu7.Progression;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void basicTests() {
        Assert.assertEquals("Lew", Kata.declareWinner(new Fighter("Lew", 10, 2),new Fighter("Harry", 5, 4), "Lew"));
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
        assertTrue(Solution.isAlt2("amazon"));
        assertFalse(Solution.isAlt2("apple"));
        assertTrue(Solution.isAlt2("banana"));
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

    @Test
    public void isCryptSolution2() {
        String[] crypt = new String[]{"WASD", "IJKL", "AOPAS"};
        char[][] solution = new char[][] {
                new char[]{'W','2'},
                new char[]{'A','0'},
                new char[]{'S','4'},
                new char[]{'D','1'},
                new char[]{'I','5'},
                new char[]{'J','8'},
                new char[]{'K','6'},
                new char[]{'L','3'},
                new char[]{'O','7'},
                new char[]{'P','9'}};
        assertFalse(ArraysPractice.isCryptSolution(crypt, solution));
    }

    @Test
    public void isCryptSolution3() {
        String[] crypt = new String[]{"AAAAAAAAAAAAAA", "BBBBBBBBBBBBBB", "CCCCCCCCCCCCCC"};
        char[][] solution = new char[][] {
                new char[]{'A','1'},
                new char[]{'B', '2'},
                new char[]{'C', '3'},
                };
        assertTrue(ArraysPractice.isCryptSolution(crypt, solution));
    }

    @Test
    public void removeEverySecondTest() {
        ArrayList<Integer> sd = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        ArrayList<Integer> solution = new ArrayList<>(Arrays.asList(1, 3, 5, 7, 9));
        assertEquals(solution, ArraysPractice.removeEverySecond(sd));
    }

    @Test
    public void percentileTest90() {
        ArrayList<Integer> entries = new ArrayList<>(Arrays.asList(69, 43, 54, 56, 61, 62, 66, 68, 69, 69, 70, 71, 72, 77, 78, 79, 85, 87, 88, 89, 93, 95, 96, 98, 99, 99));
        assertEquals(98, Percentile.getPercentile(entries, 90));
    }

    @Test
    public void percentileTest20() {
        ArrayList<Integer> entries = new ArrayList<>(Arrays.asList(43, 54, 56, 61, 62, 66, 68, 69, 69, 70, 71, 72, 77, 78, 79, 85, 87, 88, 89, 93, 95, 96, 98, 99, 99));
        assertEquals(64, Percentile.getPercentile(entries, 20));
    }

    @Test
    public void percentileTestChrome() {
        ArrayList<Double> firstLoad = new ArrayList<>(Arrays.asList(7.88, 7.05, 10.67, 8.6, 11.28, 5.1, 5.89, 5.92, 4.62, 10.8));
        ArrayList<Double> cachedLoad = new ArrayList<>(Arrays.asList(3.49, 2.3, 2.51, 1.92, 2.23, 2.44, 2.36, 2.22, 2.23, 2.11));

        System.out.println("First load: Chrome");
        System.out.println("90th Percentile: " + Percentile.getPercentile(90, firstLoad));
        System.out.println("95th Percentile: " + Percentile.getPercentile(95, firstLoad));

        System.out.println("Cached load: Chrome");
        System.out.println("90th Percentile: " + Percentile.getPercentile(90, cachedLoad));
        System.out.println("95th Percentile: " + Percentile.getPercentile(95, cachedLoad));
    }

    @Test
    public void percentileTestFirefox() {
        ArrayList<Double> firstLoad = new ArrayList<>(Arrays.asList(10.65, 5.26, 8.41, 5.58, 6.64, 5.17, 5.18, 6.42, 7.92, 5.8));
        ArrayList<Double> cachedLoad = new ArrayList<>(Arrays.asList(3.63, 3.19, 3.54, 3.3, 3.31, 3.43, 4.67, 3.05, 3.54, 3.24));

        System.out.println("First load: Firefox");
        System.out.println("90th Percentile: " + Percentile.getPercentile(90, firstLoad));
        System.out.println("95th Percentile: " + Percentile.getPercentile(95, firstLoad));

        System.out.println("Cached load: Firefox");
        System.out.println("90th Percentile: " + Percentile.getPercentile(90, cachedLoad));
        System.out.println("95th Percentile: " + Percentile.getPercentile(95, cachedLoad));
    }

}
