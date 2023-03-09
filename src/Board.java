import java.util.*;

public class Board {
    private int rows;
    private int col;
    private int size;
    Scanner sc = new Scanner(System.in);
    

    public int getRows() {
        return rows;
    }
    public void setRows(int rows) {
        this.rows = rows;
    }
    public int getCol() {
        return col;
    }
    public void setCol(int col) {
        this.col = col;
    }
    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }
    

    public void createBoard(){        
        System.out.println("---------Creating Table---------");

        System.out.println("Enter the number of rows: ");
        rows = sc.nextInt();
        System.out.println("Enter the number of colummns");
        col = sc.nextInt();
        setSize(rows*col);
        System.out.println("Board Size: " + size); 
        System.out.println("---------Table Created----------");
    }    
}
