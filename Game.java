import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {
    
    private static final long serialVersionUID = 1L;

	// Dimensions for the window size
    public static final int WIDTH = 1000, HEIGHT = WIDTH / 12 * 9;

	// Thread for handling back-end functions
    private Thread thread;

	// Game state
    private boolean running = false;

	// Builds the window
    public Game() {
        new Window(WIDTH, HEIGHT, "Catacombs", this);
    }

	// Synchronization prevents this function from being called more than once
	// Without being suspended first by the stop() function
	// This makes sure that threads aren't duplicated
    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
    }
    
	// This try block stops the running thread
	// The catch throws an exception if there isn't one
    public synchronized void stop() {
        try {
        	thread.join();
        	running = false;
        }catch(Exception e) {
        	e.printStackTrace();
        }
    }

	// This function is supposed to calculate fps and display it in the console
	// Although I'm having trouble getting it to display
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
    		
    		if(running)
    			render();
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
    
	// Renders visual content
    private void render() {
    	BufferStrategy bufferStrat = this.getBufferStrategy();
		if(bufferStrat == null) {
			this.createBufferStrategy(3);
			return;
		}

		Graphics graphics = bufferStrat.getDrawGraphics();

		graphics.setColor(Color.black);
		graphics.fillRect(0, 0, WIDTH, HEIGHT);

		graphics.dispose();
		bufferStrat.show();
    }

	// Creates and runs a Game object
    public static void main(String args[]) {
		System.out.println("Test");
        new Game();
    }
}