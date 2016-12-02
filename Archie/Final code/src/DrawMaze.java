import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * Created by Venexion on 12/1/2016.
 */
public class DrawMaze extends JPanel {
    //Declare variables
    private int[][] maze;                   //Info for maze
    private JFrame frame;                   //JFrame object
    private int column;                     //Column location
    private int row;                        //Row location
    private Maze mazeObject;                //Object for maze
    private final int FRAME_HEIGHT = 600;   //Frame height
    private final int FRAME_WIDTH = 600;    //Frame width
    private final int SIZE = 15;            //Size of cells

    /**
     * Constructor for the GUI. Starts off by initializing
     * maze array, then setups up the content pane
     * @param mazeObject The maze object
     */
    public DrawMaze (Maze mazeObject) {
        //Initialize maze object
        this.mazeObject = mazeObject;

        //Initializes the maze
        maze = mazeObject.getMaze();

        //Initialize JFrame object
        frame = new JFrame();

        //Sets size of the window
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);

        //Add graphics to content pane
        frame.add(this);

        //Set default close operation
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Makes the window visible
        frame.setVisible(true);
    }

    public void paint (Graphics graphic) {
        //Variables for tracking position in GUI
        row = 0;
        column = 0;

        //Nested for loop for array traversal
        for (int y = 0; y < maze.length; y++) {
            for (int x = 0; x < maze[y].length; x++) {
                //If wall, black. If hallway, white
                if (maze[y][x] == 1) {
                    graphic.setColor(Color.black);
                    graphic.fillRect(column, row, SIZE, SIZE);
                    column += SIZE;
                } else if (maze[y][x] == 0) {
                    graphic.setColor(Color.white);
                    graphic.fillRect(column, row, SIZE, SIZE);
                    column += SIZE;
                }
            }
            //Traverse down gui
            row += SIZE;

            //Go back to beginning of column
            column = 0;
        }

        //Quick test
        graphic.setColor(Color.green);
        graphic.fillRect(0, (mazeObject.getStartPoint() * SIZE), SIZE, SIZE);
    }
}
