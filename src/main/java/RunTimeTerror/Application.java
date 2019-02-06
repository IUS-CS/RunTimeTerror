package RunTimeTerror;

import RunTimeTerror.Viewer.Display;
import javax.swing.*;

/**
 * Hello world!
 *
 */
public class Application
{
    public static void main( String[] args )
    {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Display view = new Display();
                JFrame frame = new JFrame();
                frame.setSize(1024, 768);
                frame.setLocationRelativeTo(null);
                frame.setResizable(false);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().add(view);
                frame.setVisible(true);
                view.requestFocus();
                view.start();
            }
        });
    }
}
