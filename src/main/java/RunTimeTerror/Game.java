package RunTimeTerror;



import RunTimeTerror.Entities.*;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

/**
 * Hello world!
 *
 */
public class Game extends Canvas implements Runnable
{
    public static final long serialVersionUID = 4602267202262990821L;

    public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
    private Thread thread;
    public boolean running = false;
    public static int tickcount;
    public static Handler handler;
    public static Handler floors;

    public Game(){
        handler = new Handler();
        floors = new Handler();
        this.addKeyListener(new KeyInput());

        new Display(WIDTH, HEIGHT, "Jumpman Plumber", this);

        handler.addObject(new Player(WIDTH/2-32, HEIGHT-80, 24, 32, ID.Player));
        handler.addObject(new Goomba(WIDTH-32, 40, 16, 19, ID.Goomba));
        handler.addObject(new Koopa(WIDTH/40, 40, 16, 19, ID.Koopa));//Add the collision numbers if needed
        floors.addObject(new Floor(0, HEIGHT-40, 640, 10, ID.Floor));
        floors.addObject(new Floor(0, HEIGHT-110, 160, 30, ID.Floor));
        floors.addObject(new Floor(WIDTH-160, HEIGHT-110, 160, 30, ID.Floor));
        floors.addObject(new Floor(180, HEIGHT-175, 265, 30, ID.Floor));
        floors.addObject(new Floor(WIDTH-160, HEIGHT-250, 160, 30, ID.Floor));
        floors.addObject(new Floor(0, HEIGHT-250, 160, 30, ID.Floor));
        floors.addObject(new Floor(180, HEIGHT-330, 265, 30, ID.Floor));
        floors.addObject(new Floor(WIDTH-160, HEIGHT-400, 160, 30, ID.Floor));
        floors.addObject(new Floor(0, HEIGHT-400, 160, 30, ID.Floor));

        Collision.floor=floors;
        Collision.handle=handler;

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
                randomenemy();
                setRunning();
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

    private void randomenemy(){
        tickcount++;
        if(tickcount == 600) {
            double random = Math.random();
            if (random > 0.50) {
                handler.addObject(new Goomba(WIDTH - 32, 40, 16, 19, ID.Goomba));
                handler.addObject(new Goomba(WIDTH / 40, 40, 16, 19, ID.Goomba));
            }
            if (random < 0.50) {
                handler.addObject(new Koopa(WIDTH - 32, 40, 16, 19, ID.Koopa));
                handler.addObject(new Koopa(WIDTH / 40, 40, 16, 19, ID.Koopa));
            }
            tickcount = 0;
        }

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
        g.setColor(Color.blue);
        g.fillRect(0,50,60,30);
        g.fillRect(WIDTH-60,50,60,30);
        g.fillRect(0,HEIGHT-70,60,30);
        g.fillRect(WIDTH-60,HEIGHT-70,60,30);
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

    public void setRunning(){
        running = handler.running;
    }

    public static void main( String[] args )
    {
        new Game();

    }

}
