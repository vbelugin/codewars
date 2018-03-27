package kyu4;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * https://www.codewars.com/kata/58d06bfbc43d20767e000074/train/java
 * Task
 Your task in the kata is to determine how many boats are sunk damaged and untouched from a set amount of attacks. You will need to create a function that takes two arguments, the playing board and the attacks.

 Boats are placed either horizontally, vertically or diagonally on the board. 0 represents a space not occupied by a boat. Digits 1-3 represent boats which vary in length 1-4 spaces long. There will always be at least 1 boat up to a maximum of 3 in any one game. Boat sizes and board dimentions will vary from game to game.

 Attacks
 Attacks are calculated from the bottom left, first the X coordinate then the Y. There will be at least one attack per game, and the array will not contain duplicates.

 { {2, 1}, {1, 3}, {4, 2} };
 First attack      [2, 1] = 3
 Second attack [1, 3] = 0
 Third attack     [4, 2] = 1
 Function Initialization
 int[][] board   = new int[][] {new int[] {0,0,1,0},
 new int[] {0,0,1,0},
 new int[] {0,0,1,0}};
 int[][] attacks = new int[][] {new int[] {3,1},new int[] {3,2},new int[] {3,3}};
 BattleShips.damagedOrSunk(board, attacks);
 Scoring
 1 point for every whole boat sank.
 0.5 points for each boat hit at least once (not including boats that are sunk).
 -1 point for each whole boat that was not hit at least once.
 Sunk or Damaged
 sunk = all boats that are sunk
 damaged = all boats that have been hit at least once but not sunk
 notTouched/not_touched = all boats that have not been hit at least once
 Output
 You should return a hash with the following data

 Example Game Output
 In our above example..

 First attack: boat 3 was damaged, which increases the points by 0.5
 Second attack: miss nothing happens
 Third attack: boat 1 was damaged, which increases the points by 0.5
 boat 2 was untouched so points -1 and notTouched +1 in Javascript/Java/C# and not_touched +1 in Python/Ruby.
 No whole boats sank
 Return Hash
 *
 */

public class BattleShips {

    public static Map<String,Double> damagedOrSunk(final int[][] board, final int[][] attacks) {
        Map<String, Double> results = new HashMap<>();
        results.put("sunk", 0.0);
        results.put("damaged", 0.0);
        results.put("notTouched", 0.0);
        results.put("points", 0.0);

        //mark all hits with *10
        int x, y;
        for (int[] attack : attacks) {
            x = board.length - attack[1];
            y = attack[0] - 1;
            board[x][y] = board[x][y] != 0 ? board[x][y] *= 10 : 0;
        }

        //remove all empty spaces from board and collect results into a list of integers
        List<Integer> ships = new ArrayList<>();
        for (int[] line : board) {
            IntStream.of(line).boxed().filter(cell -> cell > 0).distinct().forEach(ships::add);
        }

        //remove all duplicates from the list
        ships = ships.stream().distinct().collect(Collectors.toList());

        //count ships that was hit, sunken ships and not touched ones
        for(Integer ship : ships) {
            if (ship%10 != 0) {
                if (!ships.contains(ship * 10)) {
                    results.put("notTouched", results.get("notTouched") + 1);
                    results.put("points", results.get("points") - 1);
                }
                if (ships.contains(ship * 10)) {
                    results.put("damaged", results.get("damaged") + 1);
                    results.put("points", results.get("points") + 0.5);
                }
            } else {
                if (!ships.contains(ship/10)) {
                    results.put("sunk", results.get("sunk") + 1);
                    results.put("points", results.get("points") + 1);
                }
            }
        }
        return results;
    }
}
