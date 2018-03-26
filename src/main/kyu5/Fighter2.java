package kyu5;

public class Fighter2 {
    private static String[][] fightBoard;

    public static String[] superStreetFighterize(String[][] fighters, int[] position, String[] moves) {
        String[] solution = new String[moves.length];
        fightBoard = fighters;
        int i = 0;
        for (String move : moves) {
            switch (move){
                case "up": position = pos(position[0]-1, position[1], -1, 0); break;
                case "down": position = pos(position[0]+1, position[1], 1, 0); break;
                case "left": position = pos(position[0], position[1]-1, 0, -1); break;
                case "right":position = pos(position[0], position[1]+1, 0, 1); break;
            }
            solution[i++] = fightBoard[position[0]][position[1]];
        }
        return solution;
    }

    private static int[] pos(int x, int y, int xMove, int yMove) {
        x = x < 0 ? 0 : x >= fightBoard.length - 1 ? fightBoard.length - 1 : x;
        y = y < 0 ? fightBoard[x].length - 1 : y > fightBoard[x].length - 1 ? 0 : y;
        return fightBoard[x][y].equals("") ? xMove != 0 ? new int[]{x - xMove, y} : pos(x + xMove, y + yMove, xMove, yMove) : new int[]{x, y};
    }
}
