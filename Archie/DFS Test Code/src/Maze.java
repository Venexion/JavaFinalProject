import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Matcher;

/**
 * Created by Arshia Rostami on 11/4/2016.
 */
public class Maze {
    private int[][] maze;
    private int height;
    private int width;
    private int startPoint;
    private int endPoint;

    public Maze (int height, int width) {
        this.width = width;
        this.height = height;
    }

    public int[][] generateMaze() {
        maze = new int[height][width];
        // Initialize
        for (int i = 0; i < height; i++)
            for (int j = 0; j < width; j++)
                maze[i][j] = 1;

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

        // Create starting and stopping location
        generateStartStop();

        return maze;
    }

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

    private void generateStartStop () {
        // Create random object
        Random random = new Random ();

        // Find starting point
        startPoint = random.nextInt(height - 1);
        while (startPoint == 0 || maze[startPoint][1] == 1)
            startPoint = random.nextInt(height - 1);

        // Find ending point
        endPoint = random.nextInt(height - 1);
        while (endPoint == 0 || maze[endPoint][width - 2] == 1)
            endPoint = random.nextInt(height - 1);

        // Assign chosen points as open cells
        maze[startPoint][0] = 0;
        maze[endPoint][width - 1] = 0;
    }
}
