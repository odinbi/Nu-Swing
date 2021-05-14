package nuswing;

import java.awt.Color;

public class NuColor extends Color{

    public static NuColor BLACK = new NuColor(32, 32, 32);
    public static NuColor WHITE = new NuColor(245, 245, 245);
    public static NuColor GRAY = new NuColor(160, 160, 160);
    public static NuColor BLUE = new NuColor(102, 102, 255);
    public static NuColor RED = new NuColor(255, 102, 102);
    public static NuColor YELLOW = new NuColor(255, 255, 102);
    public static NuColor GREEN = new NuColor(102, 255, 102);
    
    public NuColor (int red, int green, int blue){
        super(red, green, blue);
    }

    public NuColor (int hexRGB){
        super(hexRGB);
    }
}
