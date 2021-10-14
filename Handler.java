import java.util.LinkedList;
import java.awt.Graphics;

// This class handles the addition and removal of GameObjects
// and updates the movement of each GameObject
public class Handler {
    
    // Linked list to dynamically store GameObjects
    public LinkedList<GameObject> object = new LinkedList<GameObject>();

    // Updates postioning and movement for each GameObjects
    public void tick() {
        for(GameObject tempObject : object) {
            tempObject.tick();
        }
    }

    // Renders graphics for each GameObject in the linked list
    public void render(Graphics graphics) {
        for(GameObject tempObject : object) {
            tempObject.render(graphics);
        }
    }

    // Adds GameObjects to the linked list
    public void addObject(GameObject tempObject) {
        object.add(tempObject);
    }

    // Removes GameObjects from the linked list
    public void removeObject(GameObject tempObject) {
        object.remove(tempObject);
    }
}
