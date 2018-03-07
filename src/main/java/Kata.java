import java.util.stream.IntStream;

public class Kata {
    public static String declareWinner(Fighter fighter1, Fighter fighter2, String firstAttacker) {
        int f1StrikesCount = fighter2.health/fighter1.damagePerAttack;
        int f2StrikesCount = fighter1.health/fighter2.damagePerAttack;

        if (f1StrikesCount <= 1 && f2StrikesCount > 1) {
            return fighter1.name;
        } else if (f2StrikesCount <= 1 && f1StrikesCount > 1) {
            return fighter2.name;
        }

        System.out.println(firstAttacker + ": " + f1StrikesCount +"/"+ f2StrikesCount);

        System.out.println(f1StrikesCount <= f2StrikesCount ? fighter1.name.equals(firstAttacker) ? fighter1.name : fighter2.name : fighter1.name);
        return f1StrikesCount <= f2StrikesCount ? fighter1.name.equals(firstAttacker) ? fighter1.name : fighter2.name : fighter1.name;
    }

    public static String[] streetFighterSelection(String[][] fighters, int[] position, String[] moves){
        String[] solution = new String[moves.length];
        int x = position[0];
        int y = position[1];
        int i = 0;
        for (String move : moves) {
            switch (move){
                case "up": x = x == 0 ? 0 : x - 1; break;
                case "down": x = x == fighters.length - 1 ? x : x + 1; break;
                case "left": y = y == 0 ? fighters[x].length - 1 : y - 1; break;
                case "right": y = y == fighters[x].length - 1 ? 0 : y + 1; break;
            }
            solution[i++] = fighters[x][y];
        }
        return solution;
    }

    public static String isSortedAndHow(int[] array) {

        return IntStream.range(0, array.length-1).allMatch(i -> array[i] <= array[i+1])
                    ? "yes, ascending"
               : IntStream.range(0, array.length-1).allMatch(i -> array[i] >= array[i+1])
                    ? "yes, descending"
                    : "no";
    }
}
