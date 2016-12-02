/**
 * Made by Arshia Rostami on 11/4/2016
 */
import java.util.Scanner;

public class GameDemo {
    public static void main (String[] args) {
        //Declare variables for height and width
        //of maze
        int height, width;

        //Instantiate Scanner object
        Scanner input = new Scanner(System.in);

        //Find a height
        System.out.print("Maze height: ");
        height = input.nextInt();
        //Modify it so it is odd
        //Because the maze only works
        //Properly with odd numbers
        if (height % 2 == 0)
            height++;

        //Find a width for the maze
        System.out.print("Maze width: ");
        //Same as above
        width = input.nextInt();
        if (width % 2 == 0)
            width++;

        //Instantiate a Maze object using the
        //User given height and width
        Maze makeMaze = new Maze(height, width);

        //Instantiate Player object making the
        //Starting point using Maze startPoint
        Player player = new Player (0, makeMaze.getStartPoint(), makeMaze);

        //Assign the created maze to a 2D array
        int[][] maze = makeMaze.getMaze();

        //Draw the maze using stars and Os
        System.out.println("\n");
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (maze[i][j] == 1)
                    System.out.print("\u25A0"); //If the cell is a wall
                else
                    System.out.print("\u25A1"); //If the cell is open
            }
            System.out.println();
        }

        DrawMaze draw = new DrawMaze(makeMaze);
    }
}