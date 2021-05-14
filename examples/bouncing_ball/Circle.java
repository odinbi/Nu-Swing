import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Color;

public class Circle extends JComponent {
    int diameter, x, y;
    Color color;

    public Circle (int radius, int x, int y, Color color) {
        this.diameter = 2*radius; this.x = x; this.y = y;
        this.color = color;
    }

    //move
    public void mv(int x, int y){
        this.x += x; this.y += y;
    }

    public int y(){
        return y;
    }

    @Override
    public void paintComponent(Graphics g) {
        g.setPaintMode();
        g.setColor(this.color);
        g.fillArc(x, y, diameter, diameter, 0, 360);
        g.drawArc(x, y, diameter, diameter, 0, 360);
    }
}
