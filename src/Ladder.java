import java.util.HashMap;
import java.util.Scanner;

public class Ladder {
    private int start;
    private int end;
    private HashMap<Integer, Integer> ladder = new HashMap<Integer, Integer>();
    
    Scanner sc = new Scanner(System.in);
    
    public int getStart() {
        return start;
    }
    public void setStart(int start) {
        this.start = start;
    }
    public int getEnd() {
        return end;
    }
    public void setEnd(int end) {
        this.end = end;
    }
    public HashMap<Integer, Integer> getLadder() {
        return ladder;
    }

    

    public void createLadders(int boardSize){
        System.out.println("Enter the number of Ladders: ");
        int num = sc.nextInt();
        for(int i=0; i<num; i++){
            System.out.print("Enter Ladder" + (i+1) + " Bottom: ");
            start = sc.nextInt();
            System.out.print("Enter Ladder" + (i+1) + " Top: ");
            end = sc.nextInt();
            if(validLadder(start, end, boardSize)){
                ladder.put(start, end);
            }
            else{
                i--;
            }
        }
        printLadders();
    }


    public void printLadders(){
        System.out.println("Ladders in the table are: ");
        for(int i: ladder.keySet()){
            System.out.println(" < " + i + " , " + ladder.get(i) +" > ");
        }
    }

    public boolean validLadder(int start, int end, int boardSize){
        if(start< boardSize && start>1 && end<boardSize && end>1 && start<end ){
            return true;
        }
        else{
            System.out.println("This Ladder cannot be created!!! Enter new one: ");
            return false;
        }
    }

    public boolean checkLadder(int pos){
        boolean exists = false;
        for (int key : ladder.keySet()) {
            if (key == pos) {
                exists = true;
                break;
            }
        }
        return exists;
    }
    
    public int updatePosition(int pos){
        for(int key: ladder.keySet()){
            if(key == pos){
                pos = ladder.get(key);
                break;
            }
        }
        return pos;
    }
}
