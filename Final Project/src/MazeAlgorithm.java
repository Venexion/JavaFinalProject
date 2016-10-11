import java.util.Scanner;

/**
 * Created by Archy Rost on 10/6/2016.
 */
public class MazeAlgorithm {
    public static void main(String[] args) {
        int xAxis, yAxis, axisSize, y;
        Scanner input = new Scanner(System.in);

        System.out.print("X Axis: ");
        xAxis = input.nextInt() + 1;
        System.out.print("Y Axis: ");
        yAxis = input.nextInt() + 1;
        System.out.println("");
        axisSize = xAxis * yAxis;

        int[][] matrix = new int[2][axisSize];
        y = yAxis - 1;

        for (int i = 0; i < axisSize; i++) {
            matrix[0][i] = (i % xAxis);
            if (i > 0)
                if (matrix[0][i - 1] == (xAxis - 1))
                    y--;
            matrix[1][i] = y;
        }


        for (int i = 0; i < axisSize; i++) {
            System.out.print("{");
            System.out.print(matrix[0][i] + ", ");
            System.out.print(matrix[1][i] + "}, ");
            if (matrix[0][i] == (xAxis - 1))
                System.out.println("");
        }
    }
}