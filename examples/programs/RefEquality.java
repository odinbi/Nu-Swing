import NuSwing.*;

public class RefEquality{
    public static void main(String[] args){
        NuWindow nw = new NuWindow(400, 400);
        NuPoint pt = new NuPoint(250, 200);
        NuCircle nc1 = new NuCircle(100, pt, NuColor.BLACK);
        NuCircle nc2 = new NuCircle(50, pt, NuColor.GRAY);

        NuButton nb = new NuButton("Move Inner", new NuPoint(20, 100), 100, 50);
        nb.setAction(() -> nc2.move(0, 100));

        nw.addComponent(nc1); nw.addComponent(nc2);
        nw.addComponent(nb);
    }
}
