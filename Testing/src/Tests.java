import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * Created by Venexion on 12/1/2016.
 */
public class Tests extends JPanel {
    public static void main (String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(416, 100);
        frame.add(this);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void paint (Graphics graphic) {
        for (int column = 0; column < 400; column += 10) {
            if ((column / 10) % 2 == 0) {
                graphic.setColor(Color.black);
                graphic.fillRect(column, 0, 10, 10);
            } else {
                graphic.setColor(Color.blue);
                graphic.fillRect(column, 0, 10, 10);
            }
        }
    }
}
