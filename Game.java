import java.awt.Canvas;

public class Game extends Canvas implements Runnable {
    
    private static final long serialVersionUID = 1L;

    public static final int WIDTH = 650, HEIGHT = WIDTH / 12 * 9;
    private Thread thread;
    private boolean running = false;

    public Game() {
        new Window(WIDTH, HEIGHT, "Catacombs", this);
    }

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
    }
    
    public synchronized void stop() {
        try {
        	thread.join();
        	running = false;
        }
        
        catch(Exception e) {
        	e.printStackTrace();
        }
    }

    public void run() {
    	long lastTime = System.nanoTime();
    	double amountOfTicks = 60.0;
    	double ns = 1000000000 / amountOfTicks;
    	double delta = 0;
    	long timer = System.currentTimeMillis();
    	int frames = 0;
    	while(running) {
    		long now = System.nanoTime();
    		delta += (now - lastTime) / ns;
    		lastTime = now;
    		while(delta >= 1) {
    			tick();
    			delta -= 1;
    		}
    		
    		if(running) {
    			render();
    		}
    		
    		frames += 1;
    		
    		if(System.currentTimeMillis() - timer > 1000) {
    			timer += 1000;
    			System.out.println("FPS: " + frames);
    			frames = 0;
    		}
    	}
    	
    	stop();
    }
    
    private void tick() {
    	
    }
    
    private void render() {
    	
    }

    public static void main(String args[]) {
        new Game();
    }
}