import java.util.concurrent.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;

public class BBSwing {

    protected static CyclicBarrier sync;

    public static void main(String[] args){
        sync = new CyclicBarrier(2); //barrier to sync bouncer and main

        int bounces = 100;

        try {
            bounces = Integer.parseInt(args[0]);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            System.out.println("Will now bounce: " + bounces + " times");
        }

        Thread t = new Thread(new BallBouncer(bounces));
        t.start();

        try {
            sync.await(); //wait for bouncer
        } catch (Exception e){
            System.err.println(e.getMessage());
        }

        try {
            t.join(); //stop bouncer
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            System.exit(0);
        }
    }

    private static class BallBouncer implements Runnable {
        int bounces;

        BallBouncer(int bounces) {
            this.bounces = bounces;
        }

        @Override
        public void run() {
            Circle c = new Circle(50, 150, 150, Color.BLACK);

            JFrame jf = new JFrame("Swing bouncer");
            jf.setSize(400,400);
            jf.setBackground(Color.WHITE);
            jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            jf.add(c);
            jf.setVisible(true);

            boolean up = true;
            int speed = 0;

            while(bounces >= 0){
                if (speed <= 0){
                    up = false;
                } else if (c.y() >= 250){
                    up = true;
                    speed--;
                    bounces--;
                }

                if (up) {
                    c.mv(0, -speed);
                    speed--;
                } else {
                    c.mv(0, speed);
                    speed++;
                }

                jf.repaint();

                try {
                    Thread.sleep(40);
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
            }

            try {
                sync.await();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
