/**
 * Created by Venexion on 11/23/2016.
 */
public class Player {
    private int xCoord;     //The players X coordinate
    private int yCoord;     //The players Y coordinate
    private boolean isWall; //Whether the location is a wall
    private Maze maze;      //Maze object

    /**
     * Constructor for class
     * @param startX Starting X coordinate
     * @param startY Starting Y coordinate
     * @param maze Maze object
     */
    public Player (int startX, int startY, Maze maze) {
        xCoord = startX;
        yCoord = startY;
        this.maze = maze;
    }

    //The following are getters and setters for the class
    //Getters
    public int getxCoord () {return xCoord;}
    public int getyCoord () {return yCoord;}
    public Maze getMaze () {return maze;}

    //Setters
    public void setxCoord (int x) {xCoord = x;}
    public void setyCoord (int y) {yCoord = y;}
    public void setWall (boolean wall) {isWall = wall;}
    public void setMaze (Maze m) {maze = m;}

    /**
     * Method for moving the player based on a given
     * Direction
     * @param direction The direction which the
     *                  player should move (1 - 4)
     */
    public void movePlayer (int direction) {
        switch (direction) {

            case 1: //Move up
                if (!maze.isWall(xCoord, yCoord + 1))
                    yCoord++;
                break;

            case 2: //Move right
                if (!maze.isWall(xCoord + 1, yCoord))
                    xCoord++;
                break;

            case 3: //Move down
                if (!maze.isWall(xCoord, yCoord - 1))
                    yCoord--;
                break;

            case 4: //Move left
                if (!maze.isWall(xCoord - 1, yCoord))
                    xCoord--;
                break;

            default:
                System.out.println("Invalid direction received");
                break;
        }
    }
}
