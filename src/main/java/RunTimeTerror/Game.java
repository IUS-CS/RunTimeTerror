package RunTimeTerror;

import RunTimeTerror.Entities.Character;

import java.awt.*;
import java.awt.image.BufferStrategy;

/**
 * Hello world!
 *
 */
public class Game extends Canvas implements Runnable
{
    public static final long serialVersionUID = 4602267202262990821L;

    public static final int Width = 800, Height = Width / 4 * 3;
    private Thread thread;
    private boolean running = false;
    Character mario = new Character();

    public Game(){
        new Display(Width, Height, "Jumpman Plumber", this);

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
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();

    }

    private void tick(){

    }

    private void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();
        mario.move();

        g.setColor(Color.black);
        g.fillRect(0, 0, Width, Height);

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
