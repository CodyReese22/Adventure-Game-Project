import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public abstract class Movement implements KeyListener, MouseListener{
    float xcoord = 0;
    float ycoord = 0;
    boolean wPressed = false;
    boolean aPressed = false;
    boolean sPressed = false;
    boolean dPressed = false;
    boolean escPressed = false;
    boolean m1Clicked = false;

    // Invoked when a key is pressed
    // Currently detects wasd and esc
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyChar() == 'w' || e.getKeyChar() == 'W') {
            wPressed = true;
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
            ycoord += 1;
        }

        if(aPressed == true) {
            xcoord -= 1;
        }

        if(sPressed == true) {
            ycoord -= 1;
        }

        if(dPressed == true) {
            xcoord += 1;
        }
    }
}
    