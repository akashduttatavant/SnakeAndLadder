import javafx.util.Pair;

import java.util.ArrayList;

public class Ladders {

    ArrayList<Pair<Integer, Integer>> laddersPosition = new ArrayList<>();

    public void initializeLadderPosition(){
        laddersPosition.add(new Pair <> (4, 25));
        laddersPosition.add(new Pair <> (13, 46));
        laddersPosition.add(new Pair <> (33, 49));
        laddersPosition.add(new Pair <> (42, 63));
        laddersPosition.add(new Pair <> (50, 69));
        laddersPosition.add(new Pair <> (62, 81));
        laddersPosition.add(new Pair <> (74, 92));
    }
}
