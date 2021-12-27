
public class Player {

    private String playerName;
    private int score;
    private boolean active;

    //Player info
    public Player(String playerName) {
        this.playerName = playerName;
        this.score = 0;
        this.active = false;
    }

    //Player 1 eller Player 2
    public String GetPLayerName() {
        return playerName;
    }
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
        }

    //Poängställning
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }

    //Aktiv eller Inaktiv
    public boolean getActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }


    public String getPlayerName() {
        return playerName;
    }

}