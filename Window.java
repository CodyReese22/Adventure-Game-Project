import java.awt.Canvas;
import javax.swing.JFrame;
import java.awt.Dimension;


public class Window extends Canvas {
    
    private static final long serialVersionUID = 1L;

    // This parameterized constructor sets values for a display window
    // Then starts the game after it's been constructed
    public Window(int width, int height, String title, Game game) {
        JFrame window = new JFrame(title);

        window.setPreferredSize(new Dimension(width, height));
        window.setMaximumSize(new Dimension(width, height));
        window.setMinimumSize(new Dimension(width, height));

        // Close operation after the window is exited out
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(true);
        window.pack();
        window.setLocationRelativeTo(null);
        window.add(game);
        window.setVisible(true);
        game.start();
    }
}
