import javafx.util.Pair;

import java.util.ArrayList;

public class Snakes {
    ArrayList<Pair<Integer, Integer>> snakesPosition = new ArrayList <> ();

    public void initializeSnakePosition(){
        snakesPosition.add(new Pair <> (27, 5));
        snakesPosition.add(new Pair <> (40, 3));
        snakesPosition.add(new Pair <> (54, 31));
        snakesPosition.add(new Pair <> (66, 45));
        snakesPosition.add(new Pair <> (89, 53));
        snakesPosition.add(new Pair <> (99, 41));
    }
}
