import java.util.Random;

public class Player{
    Random random = new Random();
    boolean player1_turn = true;
    public  Player(){
    }

    public boolean isPlayer1_turn() {
        if (random.nextInt(2) == 0){
            player1_turn = true;
        }
        else {
            player1_turn = false;
        }
        return player1_turn;
    }

    public void setPlayer1_turn(boolean player1_turn) {
        this.player1_turn = player1_turn;
    }
}
