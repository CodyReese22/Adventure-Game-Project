import java.awt.Graphics;
import java.awt.Color;

public class Player extends GameObject {
    
    public Player(float x, float y, ID id) {
        super(x, y, id);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics graphics) {
        graphics.setColor(Color.blue);
        graphics.fillRect((int)x, (int)y, 30, 30);
    }
}
