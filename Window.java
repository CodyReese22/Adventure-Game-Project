import java.awt.Canvas;
import javax.swing.JFrame;
import java.awt.Dimension;


public class Window extends Canvas {
    
    private static final long serialVersionUID = 1L;

    // This parameterized constructor sets values for a display window
    // Then starts the game after it's been constructed
    public Window(int width, int height, String title, Game game) {
        JFrame frame = new JFrame(title);

        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));

        // Close operation after the window is exited out
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        frame.add(game);
        frame.setVisible(true);
        game.start();
    }
}
