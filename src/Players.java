public class Players {
    int playerOnePosition;
    int playerTwoPosition;

    public void initializePlayerOne(){
        this.playerOnePosition = 1;
    }

    public void initializePlayerTwo(){
        this.playerTwoPosition = 1;
    }

    public int calculatePlayerRow(int position) {
        position = 100 - position;
        position = position / 10;
        return position;
    }

    public int calculatePlayerColumn(int position) {
        if(position % 10 == 0)
            return 10;
        position = position % 10;
        return position;
    }

    public int findPosition(int row, int column){

        int position = ((row - 1) * 10) + (column - 1);
        return 100 - position;
    }
}
