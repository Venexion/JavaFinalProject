/**
 * Made by Arshia Rostami on 11/4/2016
 */
import java.util.Scanner;

public class MazeDemo {
    public static void main (String[] args) {
        int height, width;
        Scanner input = new Scanner(System.in);

        System.out.print("Maze height: ");
        height = input.nextInt();
        if (height % 2 == 0)
            height++;
        System.out.print("Maze width: ");
        width = input.nextInt();
        if (width % 2 == 0)
            width++;

        Maze makeMaze = new Maze(height, width);
        int[][] maze = makeMaze.generateMaze();

        System.out.println("\n");
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (maze[i][j] == 1)
                    System.out.print("*");
                else
                    System.out.print("O");
            }
            System.out.println();
        }
    }
}