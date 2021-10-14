import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.Graphics;
import java.awt.Color;

// This class stores Player related data and detects mouse & keyboard input for movement
public class Player extends GameObject implements KeyListener, MouseListener {
    String playerName;
    float xOffset, yOffset;
    boolean wPressed = false;
    boolean aPressed = false;
    boolean sPressed = false;
    boolean dPressed = false;
    boolean escPressed = false;
    boolean m1Clicked = false;

    @Override
    public void mouseExited(MouseEvent e) {}
    @Override
    public void mouseClicked(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void keyTyped(KeyEvent e) {}

    // The extended GameObject class is the super object and stores the location and movement data
    public Player(float x, float y, ID id) {
        super(x, y, id);
    }

    // Invoked when a key is pressed
    // Currently detects wasd and esc
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyChar() == 'w' || e.getKeyChar() == 'W') {
            wPressed = true;
            System.out.println("W was pressed");
        }

        if(e.getKeyChar() == 'a' || e.getKeyChar() == 'A') {
            aPressed = true;
        }

        if(e.getKeyChar() == 's' || e.getKeyChar() == 'S') {
            sPressed = true;
        }

        if(e.getKeyChar() == 'd' || e.getKeyChar() == 'D') {
            dPressed = true;
        }

        if(e.getKeyChar() == 27) {
            escPressed = true;
        }
    }

    // Invoked when a key is released
    // esc not included
    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyChar() == 'w' || e.getKeyChar() == 'W') {
            wPressed = false;
        }

        if(e.getKeyChar() == 'a' || e.getKeyChar() == 'A') {
            aPressed = false;
        }

        if(e.getKeyChar() == 's' || e.getKeyChar() == 'S') {
            sPressed = false;
        }

        if(e.getKeyChar() == 'd' || e.getKeyChar() == 'D') {
            dPressed = false;
        }
    }

    // Invoked when a mouse button has been pressed
    // Currently only detects m1
    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getButton() == 1) {
            m1Clicked = true;
        }
    }

    // Invoked when a mouse button has been released
    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.getButton() == 1) {
            m1Clicked = false;
        }
    }

    public void move() {
        if(wPressed == true) {
            yCoord += 1;
        }

        if(aPressed == true) {
            xCoord -= 1;
        }

        if(sPressed == true) {
            yCoord -= 1;
        }

        if(dPressed == true) {
            xCoord += 1;
        }
    }

    // Updates the Players coordinates
    @Override
    public void tick() {
        move();
    }

    // Renders the Player in the updated location
    @Override
    public void render(Graphics graphics) {
        graphics.setColor(Color.blue);
        graphics.fillRect((int)super.xCoord, (int)super.yCoord, 30, 30);
    }

}
