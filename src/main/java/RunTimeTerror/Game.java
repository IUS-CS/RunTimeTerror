package RunTimeTerror;



import RunTimeTerror.Entities.*;

import java.awt.*;
import java.awt.image.BufferStrategy;

/**
 * Hello world!
 *
 */
public class Game extends Canvas implements Runnable
{
    public static final long serialVersionUID = 4602267202262990821L;

    public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
    private Thread thread;
    private boolean running = false;
    private Handler handler;

    public Game(){
        handler = new Handler();
        this.addKeyListener(new KeyInput(handler));

        new Display(WIDTH, HEIGHT, "Jumpman Plumber", this);

        handler.addObject(new Player(WIDTH/2-32, HEIGHT/2-32, ID.Player));
    }

    public void run(){
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(running){
            long now = System.nanoTime();
            delta += (now-lastTime)/ ns;
            lastTime = now;
            while(delta >= 1){
                tick();
                delta--;
            }
            if(running)
                render();
            frames++;

            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                //System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();

    }

    private void tick(){
        handler.tick();

    }

    private void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        handler.render(g);

        g.dispose();
        bs.show();
    }

    public synchronized void start(){
        thread = new Thread(this);
        thread.start();
        running = true;
    }
    public synchronized void stop(){
        try{
            thread.join();
            running = false;
        } catch(Exception e){
            e.printStackTrace();
        }

    }

    public static void main( String[] args )
    {
        new Game();

    }

}