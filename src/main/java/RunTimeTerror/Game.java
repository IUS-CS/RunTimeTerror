package RunTimeTerror;



import RunTimeTerror.Entities.*;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.LinkedList;

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
    public static Handler handler;
    public static Handler floors;

    public Game(){
        handler = new Handler();
        floors = new Handler();
        this.addKeyListener(new KeyInput());

        new Display(WIDTH, HEIGHT, "Jumpman Plumber", this);

        handler.addObject(new Player(WIDTH/2-32, HEIGHT-80, 24, 32, ID.Player));
        handler.addObject(new Goomba(WIDTH-32, 0, 16, 19, ID.Goomba));
        handler.addObject(new Koopa(WIDTH/40, 0, 16, 19, ID.Koopa));//Add the collision numbers if needed
        floors.addObject(new Floor(0, HEIGHT-40, 640, 10, ID.Floor));
        floors.addObject(new Floor(0, HEIGHT-100, 160, 30, ID.Floor));
        floors.addObject(new Floor(WIDTH-160, HEIGHT-150, 160, 30, ID.Floor));
        floors.addObject(new Floor(160, HEIGHT-200, 275, 30, ID.Floor));
        floors.addObject(new Floor(WIDTH-160, HEIGHT-250, 160, 30, ID.Floor));
        floors.addObject(new Floor(0, HEIGHT-300, 160, 30, ID.Floor));
        floors.addObject(new Floor(160, HEIGHT-400, 275, 30, ID.Floor));
        floors.addObject(new Floor(WIDTH-160, HEIGHT-350, 160, 30, ID.Floor));
        floors.addObject(new Floor(0, HEIGHT-450, 160, 30, ID.Floor));
    }

    public void run(){
        this.requestFocus();
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
        floors.tick();

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
        floors.render(g);

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
