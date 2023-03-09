import java.util.HashMap;
import java.util.Scanner;

public class Snake {
    private int snakeHead;    
    private int snakeTail;
    private HashMap <Integer, Integer> snake = new HashMap<Integer, Integer>();
    private HashMap<Integer, Integer> ladderMap = new HashMap<Integer, Integer>();
    
    public Snake(){}
    public Snake(HashMap<Integer, Integer> ladderMap){
        this.ladderMap = ladderMap;
    }

    Scanner sc = new Scanner(System.in);
    
    public int getSnakeHead() {
        return snakeHead;
    }
    public void setSnakeHead(int snakeHead) {
        this.snakeHead = snakeHead;
    }
    public int getSnakeTail() {
        return snakeTail;
    }
    public void setSnakeTail(int snakeTail) {
        this.snakeTail = snakeTail;
    }
    public HashMap<Integer, Integer> getSnake() {
        return snake;
    }
    public HashMap<Integer, Integer> getLadderMap() {
        return ladderMap;
    }

    public void createSnakes(int boardSize){
        System.out.println("Enter the number of Snakes: ");
        int num = sc.nextInt();
        for(int i=0; i<num; i++){
            System.out.print("Enter snake" + (i+1) + " head: ");
            snakeHead = sc.nextInt();
            System.out.print("Enter snake" + (i+1) + " Tail: ");
            snakeTail = sc.nextInt();
            if(validSnake(snakeHead, snakeTail, boardSize)){
                snake.put(snakeHead, snakeTail);
            }
            else{
                i--;
            }
        }
        printSnakes();
    }

    public void printSnakes(){
        System.out.println("Snakes in the table are: ");
        for(int i: snake.keySet()){
            System.out.println(" < " + i + " , " + snake.get(i) +" > ");
        }
    }

    public boolean validSnake(int head, int tail, int boardSize){
        if(head< boardSize && head>1 && tail<boardSize && tail>0 &&  
           head>tail && (!ladderMap.containsKey(head)) && (!ladderMap.containsValue(head)) && 
           !snake.containsKey(tail) && !snake.containsValue(head)){
            return true;
        }
        else{
            System.out.println("This snake cannot be created!!! Enter new one:");
            return false;
        }
    }

    public boolean checkSnake(int pos){
        boolean exists = false;
        for (int key : snake.keySet()) {
            if (key == pos) {
                exists = true;
                break;
            }
        }
        return exists;
    }
    
    public int updatePosition(int pos){
        for(int key: snake.keySet()){
            if(key == pos){
                pos = snake.get(key);
                break;
            }
        }
        return pos;
    }
}
