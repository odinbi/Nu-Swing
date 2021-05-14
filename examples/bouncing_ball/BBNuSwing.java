import java.util.concurrent.*;
import nuswing.*;

public class BBNuSwing {
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

        BallBouncer(int bounces){
            this.bounces = bounces;
        }

        @Override
        public void run() {
            NuWindow nw = new NuWindow("NuSwing bouncer", 400, 400);
            NuPoint p = new NuPoint(200, 200);
            NuCircle c = new NuCircle(50, p, NuColor.BLACK);
            nw.addComponent(c);

            boolean up = true;
            int speed = 0;

            while(bounces >= 0){
                if (speed <= 0){
                    up = false;
                } else if (p.y() <= 100){
                    up = true;
                    speed--;
                    bounces--;
                }

                if (up) {
                    p.move(0, speed);
                    speed--;
                } else {
                    p.move(0, -speed);
                    speed++;
                }

                NuUtils.sleep();
            }

            try {
                sync.await();
            } catch (Exception e){
                System.err.println(e.getMessage());
            }
        }
    }
}
