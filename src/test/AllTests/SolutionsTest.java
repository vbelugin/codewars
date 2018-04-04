package AllTests;

import org.junit.Assert;
import org.junit.Test;

import firstKatas.Fighter;
import firstKatas.Kata;
import firstKatas.Solutions;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;


public class SolutionsTest {
    @Test
    public void findShort() {
        Assert.assertEquals(3, Solutions.findShort("bitcoin take over the world maybe who knows perhaps"));
        assertEquals(3, Solutions.findShort("turns out random test cases are easier than writing out basic ones"));
    }

    @Test
    public void testRemoval() {
        assertEquals("loquen", Solutions.remove("eloquent"));
        assertEquals("ountr", Solutions.remove("country"));
        assertEquals("erso", Solutions.remove("person"));
        assertEquals("lac", Solutions.remove("place"));
    }

    @Test
    public void testSomething() {
        assertEquals("HELLO", Solutions.MakeUpperCase("hello"));
    }

    @Test
    public void testSimpleString1() {
        assertEquals("Hello World", Solutions.removeExclamationMarks("Hello World!"));
    }


    @Test
    public void testNormalCondition() {
        assertEquals(9, Solutions.solveSuperMarketQueue(new int[] { 2, 2, 3, 3, 4, 4 }, 2));
    }

    @Test
    public void testEmptyArray() {
        assertEquals(0, Solutions.solveSuperMarketQueue(new int[] {}, 1));
    }

    @Test
    public void testSingleTillManyCustomers() {
        assertEquals(15, Solutions.solveSuperMarketQueue(new int[] { 1, 2, 3, 4, 5 }, 1));
    }

    @Test
    public void testSingleCustomer() {
        assertEquals(2, Solutions.solveSuperMarketQueue(new int[] {2}, 1));
    }

    @Test
    public void testRandomValues() {
        assertEquals(30, Solutions.solveSuperMarketQueue(new int[] { 6,1,6,1,1,6,6,7,6,3,6,4,5,6,7,4,3,2,6,4,3,3,7 }, 4));
//        assertEquals(13, Kata.solveSuperMarketQueue(new int[] { 7,4,6,4,7,6 }, 3));
    }

    @Test
    public void testFinals() {
        Solutions.finalTests();
    }

    @Test
    public void testMxdiflg() {
        System.out.println("mxdiflg Fixed Tests");
        String[] s1 = new String[]{"hoqq", "bbllkw", "oox", "ejjuyyy", "plmiis", "xxxzgpsssa", "xxwwkktt", "znnnnfqknaz", "qqquuhii", "dvvvwz"};
        String[] s2 = new String[]{"cccooommaaqqoxii", "gggqaffhhh", "tttoowwwmmww"};
        assertEquals(13, Solutions.mxdiflg(s1, s2)); // 13
    }

    @Test
    public void testTortoiseRace() {
        System.out.println("Basic Tests");
        assertArrayEquals(new int[]{0, 32, 18}, Solutions.race(720, 850, 70));
        assertArrayEquals(new int[]{3, 21, 49}, Solutions.race(80, 91, 37));
        assertArrayEquals(new int[]{2, 0, 0}, Solutions.race(80, 100, 40));
    }


    @Test
    public void testFindNextSquare1() {
        assertEquals(144, Solutions.findNextSquare(121));
    }

    @Test
    public void testFindNextSquare2() {
        assertEquals(676, Solutions.findNextSquare(625));
    }

    @Test
    public void testFindNextSquare3() {
        assertEquals(-1, Solutions.findNextSquare(114));
    }

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

    @Test
    public void test1() {
        int[] array = new int[] {1, 2};
        assertEquals("yes, ascending", Kata.isSortedAndHow(array));
    }

    @Test
    public void test2() {
        int[] array = new int[] {15, 7, 3, -8};
        assertEquals("yes, descending", Kata.isSortedAndHow(array));
    }

    @Test
    public void test3() {
        int[] array = new int[] {4, 2, 30};
        assertEquals("no", Kata.isSortedAndHow(array));
    }

    @Test
    public void testSum() {
        long n = 236236;
        assertEquals(22, Kata.sumInts(n));
    }

}