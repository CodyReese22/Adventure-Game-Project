import java.awt.*;
import java.awt.event.*;

public class Player extends GameObject implements ActionListener {
    String playerName;
    
    // The UML calls for health, damage and defense in this class
    // but I think this class just needs a Status object

    public Player(float x, float y, ID id) {
        super(x, y, id);
        addActionListener
    }

    @Override
    public void tick() {
        inputMovement(velX, velY);
    }

    @Override
    public void render(Graphics graphics) {
        graphics.setColor(Color.blue);
        graphics.fillRect((int)x, (int)y, 30, 30);
    }

}
