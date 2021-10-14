import java.awt.Graphics;

// This class maintains data related to coordinate positions and movement speeds
public abstract class GameObject {
    protected float xCoord, yCoord;
    protected float xVel, yVel;
    protected ID id;

    // Used for instantiating Players and Enemies with a standard velocity
    public GameObject(float x, float y, ID id) {
        xCoord = x;
        yCoord = y;
        xVel = 1;
        yVel = 1;
        this.id = id;
    }

    // Can be used for instantiating faster Players/Enemies
    public GameObject(float x, float y, float velX, float velY, ID id) {
        xCoord = x;
        yCoord = y;
        xVel = velX;
        yVel = velY;
        this.id = id;
    }

    // These methods are defined by Player and Character/Enemy objects
    public abstract void tick();
    public abstract void render(Graphics graphics);

    public void setX(float x) {
        xCoord = x;
    }

    public float getX() {
        return xCoord;
    }

    public void setY(float y) {
        yCoord = y;
    }

    public float getY() {
        return yCoord;
    }

    public void setVelX(float velX) {
        xVel = velX;
    }

    public float getVelX() {
        return xVel;
    }

    public void setVelY(float velY) {
        yVel = velY;
    }

    public float getVelY() {
        return yVel;
    }

    public void setID(ID id) {
        this.id = id;
    }

    public ID getID() {
        return id;
    }
}
