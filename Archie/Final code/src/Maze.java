import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Matcher;

/**
 * Created by Arshia Rostami on 11/4/2016.
 */
public class Maze {
    //Declare variables
    private int[][] maze;
    private int height;
    private int width;
    private int startPoint;
    private int endPoint;

    /**
     * Constructor for class
     * @param height Height of maze
     * @param width Width of maze
     */
    public Maze (int height, int width) {
        this.width = width;
        this.height = height;

        //Make the maze
        generateMaze();

        // Create starting and stopping location
        generateStartStop();
    }

    //The following are the getters and setters for this class
    //Getters
    public int getHeight () {return height;}
    public int getWidth () {return width;}
    public int getStartPoint () {return startPoint;}
    public int getEndPoint () {return endPoint;}
    public int[][] getMaze () {return maze;}

    //Setters
    public void setHeight (int h) {height = h;}
    public void setWidth (int w) {width = w;}
    public void setStartPoint (int sP) {startPoint = sP;}
    public void setEndPoint (int eP) {endPoint = eP;}
    public void setMaze (int[][] m) {maze = m;}

    /**
     * Method to find out if the given point is a wall
     * @param x X coordinate of cell
     * @param y Y coordinate of cell
     * @return True if the given point is a wall,
     *         False if it is not
     */
    public boolean isWall (int x, int y) {
        boolean flag = true;

        if (maze[y][x] == 0)
            flag = false;
        else
            flag = true;

        return flag;
    }

    /**
     * Method that generates a 2D array
     * containing all the points of a
     * maze.
     * @return A 2D array containing the
     *         info for the maze
     */
    private int[][] generateMaze() {
        maze = new int[height][width];
        // Initialize
        for (int i = 0; i < height; i++)
            for (int j = 0; j < width; j++)
                maze[i][j] = 1; //All walls are 1s and
                                //open cells are 0s

        Random rand = new Random();
        // r for row、c for column
        // Generate random r
        int r = rand.nextInt(height);
        while (r % 2 == 0) {
            r = rand.nextInt(height);
        }
        // Generate random c
        int c = rand.nextInt(width);
        while (c % 2 == 0) {
            c = rand.nextInt(width);
        }
        // Starting cell
        maze[r][c] = 0;

        //　Allocate the maze with recursive method
        recursion(r, c);

        return maze;
    }

    /**
     * Recursive method to create the maze
     * Using depth first search
     * @param r Row coordinate
     * @param c Column coordinate
     */
    private void recursion(int r, int c) {
        // 4 random directions
        int[] randDirs = generateRandomDirections();
        // Examine each direction
        for (int i = 0; i < randDirs.length; i++) {

            switch(randDirs[i]){
                case 1: // Up
                    //　Whether 2 cells up is out or not
                    if (r - 2 <= 0)
                        continue;
                    if (maze[r - 2][c] != 0) {
                        maze[r-2][c] = 0;
                        maze[r-1][c] = 0;
                        recursion(r - 2, c);
                    }
                    break;
                case 2: // Right
                    // Whether 2 cells to the right is out or not
                    if (c + 2 >= width - 1)
                        continue;
                    if (maze[r][c + 2] != 0) {
                        maze[r][c + 2] = 0;
                        maze[r][c + 1] = 0;
                        recursion(r, c + 2);
                    }
                    break;
                case 3: // Down
                    // Whether 2 cells down is out or not
                    if (r + 2 >= height - 1)
                        continue;
                    if (maze[r + 2][c] != 0) {
                        maze[r+2][c] = 0;
                        maze[r+1][c] = 0;
                        recursion(r + 2, c);
                    }
                    break;
                case 4: // Left
                    // Whether 2 cells to the left is out or not
                    if (c - 2 <= 0)
                        continue;
                    if (maze[r][c - 2] != 0) {
                        maze[r][c - 2] = 0;
                        maze[r][c - 1] = 0;
                        recursion(r, c - 2);
                    }
                    break;
            }
        }

    }

    /**
     * Generate an array with random directions 1-4
     * @return Array containing 4 directions in random order
     */
    private int[] generateRandomDirections() {
        ArrayList<Integer> randoms = new ArrayList<Integer>();
        for (int i = 0; i < 4; i++)
            randoms.add(i + 1);
        Collections.shuffle(randoms);

        int[] randomDir = new int[4];
        for (int i = 0; i < 4; i++)
            randomDir[i] =randoms.get(i);

        return randomDir;
    }

    /**
     * Creates a random starting and stopping point
     * along the left and right side of the maze
     */
    private void generateStartStop () {
        // Create random object
        Random random = new Random ();

        // Find starting point
        startPoint = random.nextInt(height - 1);
        //Ensure the start point isn't at the bottom of
        //the maze and that the point to the right of it
        //is not a wall
        while (startPoint == 0 || maze[startPoint][1] == 1)
            startPoint = random.nextInt(height - 1);

        // Find ending point
        endPoint = random.nextInt(height - 1);
        //Same as above but with the end point
        while (endPoint == 0 || maze[endPoint][width - 2] == 1)
            endPoint = random.nextInt(height - 1);

        // Assign chosen points as open cells
        maze[startPoint][0] = 0;
        maze[endPoint][width - 1] = 0;
    }
}
