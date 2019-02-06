package RunTimeTerror.Viewer;


import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Display extends Canvas {

    public static final int SCREEN_WIDTH = 1024;
    public static final int SCREEN_HEIGHT = 768;
    private BufferedImage backbuffer;
    private Graphics2D bg;
    private BufferStrategy bs;
    private boolean running;

    public Display() {
        int imageType = BufferedImage.TYPE_INT_RGB;
        backbuffer = new BufferedImage(SCREEN_WIDTH, SCREEN_HEIGHT, imageType);
        bg = (Graphics2D) backbuffer.getGraphics();
    }

    public void start() {
        createBufferStrategy(2);
        bs = getBufferStrategy();
        running = true;
        new Thread(new MainLoop()).start();
    }

    private class MainLoop implements Runnable {

        @Override
        public void run() {

            while (running) {

                bg.setBackground(Color.BLACK);
                bg.clearRect(0, 0, getWidth(), getHeight());
                Graphics2D g = (Graphics2D) bs.getDrawGraphics();
                g.drawImage(backbuffer, 0, 0, null);
                g.dispose();
                bs.show();

                try {
                    Thread.sleep(10);
                } catch (InterruptedException ex) {
                }
            }
        }

    }
}
