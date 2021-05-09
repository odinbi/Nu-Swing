import NuSwing.*;

public class ContentEquality{
    public static void main(String[] args){
        NuWindow nw = new NuWindow(400, 400);
        NuPoint pt1 = new NuPoint(250, 200);
        NuPoint pt2 = new NuPoint(250, 200);
        NuCircle nc1 = new NuCircle(100, pt1, NuColor.BLACK);
        NuCircle nc2 = new NuCircle(50, pt2, NuColor.GRAY);

        NuButton nb = new NuButton("Move Inner", new NuPoint(20, 100), 100, 50);
        nb.setAction(() -> pt2.moveTo(250, 300));

        nw.addComponent(nc1); nw.addComponent(nc2);
        nw.addComponent(nb);
    }
}
