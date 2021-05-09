import NuSwing.*;

public class ButtonExample {
    public static void main(String[] args){
        NuWindow nw = new NuWindow("Button Example", 200, 200);

        NuButton nb = new NuButton("Button", new NuPoint(50, 75), 100, 50);
        nb.setAction(() -> System.out.println("Hello World!"));
        nw.addComponent(nb);
    }
}
