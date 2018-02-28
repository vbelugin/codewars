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
        // Your code goes here. Have fun!
        return f1StrikesCount <= f2StrikesCount ? fighter1.name.equals(firstAttacker) ? fighter1.name : fighter2.name : fighter1.name;
    }
}
