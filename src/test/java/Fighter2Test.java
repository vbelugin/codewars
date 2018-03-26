import kyu5.Fighter2;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Fighter2Test {

    String[][] fighters = new String[][]{
            new String[] {       "",    "Ryu",  "E.Honda",  "Blanka",   "Guile", ""      },
            new String[] { "Balrog",    "Ken",  "Chun Li", "Zangief", "Dhalsim", "Sagat" },
            new String[] {   "Vega", "T.Hawk", "Fei Long",  "Deejay",   "Cammy", "M.Bison"      },
    };

    @Test
    public void shouldWorkWithNoMoves() {
        String[] solution = new String[]{};
        assertEquals(solution, Fighter2.superStreetFighterize(fighters, new int[]{0,1}, new String[]{}));
    }

    @Test
    public void shouldWorkWithFewMoves(){
        String[] moves = new String[] { "up", "left", "right", "left", "left" };
        int[] position = new int[] {1,1};
        String[] solution = new String[] { "Ryu", "Guile", "Ryu", "Guile", "Blanka" };
        assertEquals(solution, Fighter2.superStreetFighterize(fighters, position, moves));
    }

    @Test
    public void shouldStopOnEmptySpacesVertically(){
        String[] moves = new String[] { "up" };
        int[] position = new int[] {1,0};
        String[] solution = new String[] { "Balrog" };
        assertEquals(solution, Fighter2.superStreetFighterize(fighters, position, moves));
    }

    @Test
    public void shouldStopOnEmptySpacesVertically2(){
        String[] moves = new String[] { "up", "up", "up", "up" };
        int[] position = new int[] {1,0};
        String[] solution = new String[] { "Balrog", "Balrog", "Balrog", "Balrog" };
        assertEquals(solution, Fighter2.superStreetFighterize(fighters, position, moves));
    }

    @Test
    public void shouldStopVertically(){
        String[] moves = new String[] { "down", "down", "down", "down" };
        int[] position = new int[] {1,0};
        String[] solution = new String[] { "Vega", "Vega", "Vega", "Vega" };
        assertEquals(solution, Fighter2.superStreetFighterize(fighters, position, moves));
    }

    @Test
    public void shouldStopOnEmptySpacesVertically3(){
        String[] moves = new String[] { "up", "up", "up", "up" };
        int[] position = new int[] {1,5};
        String[] solution = new String[] { "Sagat", "Sagat", "Sagat", "Sagat" };
        assertEquals(solution, Fighter2.superStreetFighterize(fighters, position, moves));
    }

    @Test
    public void shouldStopVertically4(){
        String[] moves = new String[] { "down", "down", "down", "down" };
        int[] position = new int[] {1,5};
        String[] solution = new String[] { "M.Bison", "M.Bison", "M.Bison", "M.Bison" };
        assertEquals(solution, Fighter2.superStreetFighterize(fighters, position, moves));
    }

    @Test
    public void shouldRotateHorizontallyWithEmptySpaces(){
        String[] moves = new String[] { "right", "right", "right", "right", "right", "right", "right", "right" };
        int[] position = new int[] {0,2};
        String[] solution = new String[] { "Blanka", "Guile", "Ryu", "E.Honda", "Blanka", "Guile", "Ryu", "E.Honda" };
        assertEquals(solution, Fighter2.superStreetFighterize(fighters, position, moves));
    }

    @Test
    public void shouldRotateHorizontally(){
        String[] moves = new String[] { "left", "left", "left", "left", "left", "left", "left", "left" };
        int[] position = new int[] {1,3};
        String[] solution = new String[] { "Chun Li", "Ken", "Balrog", "Sagat", "Dhalsim", "Zangief", "Chun Li", "Ken" };
        assertEquals(solution, Fighter2.superStreetFighterize(fighters, position, moves));
    }

    @Test
    public void shouldRotateOnAllRows(){
        String[] moves = new String[] { "right", "right", "right", "right", "right", "right", "down", "left", "left", "left", "left", "left", "left", "left", "left", "left", "left", "left", "left", "down", "right", "right", "right", "right", "right", "right", "right", "right", "right", "right", "right", "right" };
        int[] position = new int[] {0,2};
        String[] solution = new String[] {"Blanka", "Guile", "Ryu", "E.Honda", "Blanka", "Guile", "Dhalsim", "Zangief", "Chun Li", "Ken", "Balrog", "Sagat", "Dhalsim", "Zangief", "Chun Li", "Ken", "Balrog", "Sagat", "Dhalsim", "Cammy", "M.Bison", "Vega", "T.Hawk", "Fei Long", "Deejay", "Cammy", "M.Bison", "Vega", "T.Hawk", "Fei Long", "Deejay", "Cammy"};
        assertEquals(solution, Fighter2.superStreetFighterize(fighters, position, moves));
    }

    // DO NOT CHANGE THIS VARIABLE!
    // LIST WITH HOLES AND DUPLICATES
    String[][] fighters3 = new String[][]{
            new String[] {      "",    "Ryu",  "E.Honda",  "Cammy",  "Blanka",   "Guile",        "", "Chun Li" },
            new String[] {"Balrog",    "Ken",  "Chun Li",       "", "M.Bison", "Zangief", "Dhalsim", "Sagat"},
            new String[] {  "Vega",       "", "Fei Long", "Balrog",  "Deejay",   "Cammy",        "", "T.Hawk" },
    };

    @Test
    public void shouldRotateOnAllRows3(){
        String[] moves = new String[] { "right", "right", "right", "right", "right", "right", "down", "left", "left", "left", "left", "left", "left", "left", "left", "left", "left", "left", "left", "down", "right", "right", "right", "right", "right", "right", "right", "right", "right", "right", "right", "right" };
        int[] position = new int[] {0,2};
        String[] solution = new String[] {"Cammy", "Blanka", "Guile", "Chun Li", "Ryu", "E.Honda", "Chun Li", "Ken", "Balrog", "Sagat", "Dhalsim", "Zangief", "M.Bison", "Chun Li", "Ken", "Balrog", "Sagat", "Dhalsim", "Zangief", "Cammy", "T.Hawk", "Vega", "Fei Long", "Balrog", "Deejay", "Cammy", "T.Hawk", "Vega", "Fei Long", "Balrog", "Deejay", "Cammy"};
        assertEquals(solution, Fighter2.superStreetFighterize(fighters3, position, moves));
    }

    @Test
    public void shouldJustWork3(){
        String[] moves = new String[] {"down", "right", "right", "right", "down", "left", "left", "down", "right", "right", "right", "up" };
        int[] position = new int[] {0,3};
        String[] solution = new String[] {"Cammy", "Blanka", "Guile", "Chun Li", "Sagat", "Dhalsim", "Zangief", "Cammy", "T.Hawk", "Vega", "Fei Long", "Chun Li"};
        assertEquals(solution, Fighter2.superStreetFighterize(fighters3, position, moves));
    }

    String[][] fighters4 = new String[][]{
            new String[] {      "",     "Ryu",  "E.Honda",  "Cammy" },
            new String[] {"Balrog",     "Ken",  "Chun Li",       "" },
            new String[] {  "Vega",        "", "Fei Long", "Balrog" },
            new String[] {"Blanka",   "Guile",         "", "Chun Li"},
            new String[] {"M.Bison","Zangief",  "Dhalsim", "Sagat"  },
            new String[] {"Deejay",   "Cammy",         "", "T.Hawk" }
    };

    @Test
    public void shouldWorkWithLongerGrid4(){
        String[] moves = new String[] {"left", "left", "down", "right", "right", "right", "right", "down", "left", "left", "left", "left", "down", "right", "right", "down", "right", "right", "right", "down", "left", "left", "left", "down", "left", "left", "left"};
        int[] position = new int[] {0,3};
        String[] solution = new String[] {"E.Honda", "Ryu", "Ken", "Chun Li", "Balrog", "Ken", "Chun Li", "Fei Long", "Vega", "Balrog", "Fei Long", "Vega", "Blanka", "Guile", "Chun Li", "Sagat", "M.Bison", "Zangief", "Dhalsim", "Dhalsim", "Zangief", "M.Bison", "Sagat", "T.Hawk", "Cammy", "Deejay", "T.Hawk"};
        assertEquals(solution, Fighter2.superStreetFighterize(fighters4, position, moves));
    }

    @Test
    public void shouldWorkWithOddInitialPosition(){
        String[] moves = new String[] {"left", "left", "down", "right", "right", "right", "right", "down", "left", "left", "left", "left", "up", "right", "right", "up", "right", "right", "right"};
        int[] position = new int[] {3,3};
        String[] solution = new String[] {"Guile", "Blanka", "M.Bison", "Zangief", "Dhalsim", "Sagat", "M.Bison", "Deejay", "T.Hawk", "Cammy", "Deejay", "T.Hawk", "Sagat", "M.Bison", "Zangief", "Guile", "Chun Li", "Blanka", "Guile"};
        assertEquals(solution, Fighter2.superStreetFighterize(fighters4, position, moves));
    }
}
