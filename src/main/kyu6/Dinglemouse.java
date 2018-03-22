package kyu6;

import java.util.stream.Stream;

public class Dinglemouse {

    /**
     * Back-Story
     Every day I travel on the freeway.

     When I am more bored than usual I sometimes like to play the following counting game I made up:

     As I join the freeway my count is 0
     Add 1 for every car that I overtake
     Subtract 1 for every car that overtakes me
     Stop counting when I reach my exit
     What an easy game! What fun!

     Kata Task
     You will be given

     The distance to my exit (km)
     How fast I am going (kph)
     Information about a lot of other cars
     Their time (relative to me) as I join the freeway. For example,
        - -1.5 means they already passed my starting point 1.5 minutes ago
        - 2.2 means they will pass my starting point 2.2 minutes from now
     How fast they are going (kph)
     Find what is my "score" as I exit the freeway!

     Notes
     # Assume all cars travel at a constant speeds
     */

    public static int freewayGame(final double distKmToExit, final double mySpeedKph, final double[][] otherCars) {
        double myTimeToExit = (distKmToExit % mySpeedKph) * 60 / mySpeedKph;

        long behind = Stream.of(otherCars).filter(car -> car[0] > 0).mapToDouble(car -> ((distKmToExit % car[1]) * 60 / car[1]) + car[0]).filter(timeToExit -> timeToExit < myTimeToExit).count();
        long ahead = Stream.of(otherCars).filter(car -> car[0] < 0).mapToDouble(car -> ((distKmToExit % car[1]) * 60 / car[1]) + car[0]).filter(timeToExit -> timeToExit > myTimeToExit).count();

        return (int) (ahead - behind);
    }

}
