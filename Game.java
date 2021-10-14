import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {
    
    private static final long serialVersionUID = 1L;

	// Dimensions for the window size
    public static final int WIDTH = 1000, HEIGHT = WIDTH / 12 * 9;

	String TITLE = "Catacombs";

	// Thread for handling back-end functions
    private Thread thread;

	// Game state
    private boolean isRunning = false;

	private Handler handler;

	// Default game constructor builds the window
    public Game() {
        new Window(WIDTH, HEIGHT, TITLE, this);
		init();
		handler.addObject(new Player(300, 300, ID.Player));
    }

	private void init() {
		handler = new Handler();
	}

	// Synchronization prevents this function from being called more than once
	// Without being suspended first by the stop() function
	// This makes sure that threads aren't duplicated and vice versa
    public synchronized void start() {
		if(isRunning) {
			return;
		}

        thread = new Thread(this);
        thread.start();
		isRunning = true;
    }
    
	// This try block stops the running thread
	// The catch throws an exception if there isn't one
    public synchronized void stop() {
		if(!isRunning) {
			return;
		}

        try {
        	thread.join();
        	isRunning = false;
        }catch(Exception e) {
        	e.printStackTrace();
        }

		isRunning = false;
    }

	// Game loop
    public void run() {
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;

		while(isRunning) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;

			while(delta >= 1) {
				tick();
				delta--;
			}

			render();
			frames++;

			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				frames = 0;
			}
		}
		
		stop();
    }
    
	// Updates the game
    private void tick() {
    	handler.tick();
    }
    
	// Renders visual content
    private void render() {
    	BufferStrategy bufferStrat = this.getBufferStrategy();

		if(bufferStrat == null) {
			this.createBufferStrategy(3);
			return;
		}

		// Draws graphics onto the screen
		Graphics graphics = bufferStrat.getDrawGraphics();

		graphics.setColor(Color.black);
		graphics.fillRect(0, 0, WIDTH, HEIGHT);

		handler.render(graphics);

		bufferStrat.show();
		graphics.dispose();
    }

	// Creates and runs a Game object
    public static void main(String args[]) {
        new Game();
    }
}