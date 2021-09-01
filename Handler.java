import java.util.LinkedList;
import java.awt.Graphics;


public class Handler {
    
    public LinkedList<GameObject> object = new LinkedList<GameObject>();

    public void tick() {
        for(GameObject tempObject : object) {
            tempObject.tick();
        }
    }

    public void render(Graphics graphics) {
        for(GameObject tempObject : object) {
            tempObject.render(graphics);
        }
    }

    public void addObject(GameObject tempObject) {
        object.add(tempObject);
    }

    public void removeObject(GameObject tempObject) {
        object.remove(tempObject);
    }
}
