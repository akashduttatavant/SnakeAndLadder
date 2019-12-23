import javafx.util.Pair;
import java.util.Random;

import java.util.ArrayList;

public class Board {

    int BOARD_ROW = 11;
    int BOARD_COLUMN = 11;
    ArrayList<Integer> board = new ArrayList<Integer>(100);

    Board(){
        for(int i = 1; i<= board.size(); i++){
            board.set(i, -1);
        }
    }

    public void instruction(){
        System.out.println("Instruction - ");
        System.out.println();
        System.out.println("------------");
        System.out.println("| 91 S1 P1 |  -> 91 is Cell No | S1 is Snake No | P1 is Player No");
        System.out.println("------------");
        System.out.println();
        System.out.println("P1 -> Player 1");
        System.out.println("P2 -> Player 2");
        System.out.println("PP -> Both Player in same cell");
        System.out.println("S1, S2, S3.... -> Snakes");
        System.out.println("L1, L2, L3.... -> Ladders");
        System.out.println();
        System.out.println("Press enter to start the game-");
        System.out.println();
    }

    public void printLine(){
        System.out.println();
    }

    public int rollDice(){
        Random rand = new Random();
        return rand.nextInt(6) + 1;
    }

    public void drawBoard(Players players, Snakes snakes, Ladders ladders) {

        String objPosition = "  ";
        String playerPosition = "  ";
        String hundredthPlace = " ";

        for (int row = 1; row < BOARD_ROW; row++) {
            System.out.println("");
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------");

            for (int column = 1; column < BOARD_COLUMN; column++) {
                for (Pair<Integer,Integer> iterator : snakes.snakesPosition) {
                    if(players.findPosition(row, column) == iterator.getKey()){
                        objPosition = "S" + snakes.snakesPosition.indexOf(iterator);
                    }

                    if(players.findPosition(row, column) == iterator.getValue()){
                        objPosition = "S" + snakes.snakesPosition.indexOf(iterator);
                    }
                }

                for (Pair<Integer,Integer> iterator : ladders.laddersPosition) {
                    if(players.findPosition(row, column) == iterator.getKey()){
                        objPosition = "L" + ladders.laddersPosition.indexOf(iterator);
                    }

                    if(players.findPosition(row, column) == iterator.getValue()){
                        objPosition = "L" + ladders.laddersPosition.indexOf(iterator);
                    }
                }

                if(players.findPosition(row, column) == players.playerOnePosition) {
                    playerPosition = "P1";
                }

                if(players.findPosition(row, column) == players.playerTwoPosition) {
                    playerPosition = "P2";
                }

                if(players.findPosition(row, column) == players.playerOnePosition && players.playerOnePosition == players.playerTwoPosition){
                    playerPosition = "PP";
                }

                if(players.findPosition(row, column) == 100){
                    hundredthPlace = "";
                }

                String position = String.format("%02d", players.findPosition(row, column));
                System.out.print("| " + position + "  " + objPosition + "  " + playerPosition + hundredthPlace);
                objPosition = "  ";
                hundredthPlace = " ";
                playerPosition = "  ";
            }
            System.out.print("|");
        }
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------");

    }

    public String movePlayerOne(Players players, int move, Snakes snakes, Ladders ladders){

        int prevPosition = players.playerOnePosition;

        if(players.playerOnePosition + move > 100){
            return "player 1 cannot move " + move + " steps further";
        }
        for (Pair<Integer,Integer> iterator : snakes.snakesPosition) {
            if(players.playerOnePosition + move == iterator.getKey()){
                players.playerOnePosition = iterator.getValue();
                return "Player 1 got eaten by snake from " + iterator.getKey() + " to " + iterator.getValue();
            }
        }

        for (Pair<Integer,Integer> iterator : ladders.laddersPosition) {
            if(players.playerOnePosition + move == iterator.getKey()){
                players.playerOnePosition = iterator.getValue();
                return "Player 1 taken ladder from " + iterator.getKey() + " to " + iterator.getValue();
            }
        }

        players.playerOnePosition += move;
        return "Player 1 moved from " + prevPosition + " to " + players.playerOnePosition;
    }


    public String movePlayerTwo(Players players, int move, Snakes snakes, Ladders ladders){

        int prevPosition = players.playerTwoPosition;

        if(players.playerTwoPosition + move > 100){
            return "Player 2 cannot move " + move + " steps further";
        }
        for (Pair<Integer,Integer> iterator : snakes.snakesPosition) {
            if(players.playerTwoPosition + move == iterator.getKey()){
                players.playerTwoPosition = iterator.getValue();
                return "Player 2 got eaten by snake from " + iterator.getKey() + " to " + iterator.getValue();
            }
        }

        for (Pair<Integer,Integer> iterator : ladders.laddersPosition) {
            if(players.playerTwoPosition + move == iterator.getKey()){
                players.playerTwoPosition = iterator.getValue();
                return "player 2 taken ladder from " + iterator.getKey() + " to " + iterator.getValue();
            }
        }

        players.playerTwoPosition += move;
        return "Player 2 moved from " + prevPosition + " to " + players.playerTwoPosition;
    }
}
