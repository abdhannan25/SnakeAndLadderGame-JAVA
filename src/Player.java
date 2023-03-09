import java.util.*;

public class Player {
    private String name;    
    private int position = 1;
    Scanner sc = new Scanner(System.in);

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getPosition() {
        return position;
    }
    public void setPosition(int position) {
        this.position = position;
    }

    public void createPlayer(){
        System.out.print("Enter player name: ");
        name = sc.nextLine();
    }

    public int rollDice() {
        Random random = new Random();
        int diceValue = random.nextInt(6) + 1;
        System.out.print(name + " rolled " + diceValue);
        return diceValue;
    }
}
