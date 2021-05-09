package NuSwing;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BasicStroke;

public class NuLine extends NuShape {
    private NuPoint a;
    private NuPoint b;


    // constructors
    public NuLine(NuPoint a, NuPoint b){
        this.a = a; this.b = b;
        this.color = NuColor.BLACK;
        this.lineWidth = 2;
    }

    public NuLine(NuPoint a, NuPoint b, int lineWidth){
        this.a = a; this.b = b;
        this.lineWidth = lineWidth;
        this.color = NuColor.BLACK;
    }

    public NuLine(NuPoint a, NuPoint b, NuColor color){
        this.a = a; this.b = b;
        this.color = color;
        this.lineWidth = 2;
    }

    public NuLine(NuPoint a, NuPoint b, NuColor color, int lineWidth){
        this.a = a; this.b = b;
        this.color = color;
        this.lineWidth = lineWidth;
    }
    // end constructors

    @Override
    public void move(float x, float y){
        a.move(x, y); b.move(x,y);
    }

    @Override
    protected void draw(Graphics g){
        Graphics2D g2d = (Graphics2D) g;

        g2d.setPaintMode();

        if (this.angle > 0 && center != null)
            g2d.rotate(Math.toRadians(this.angle),
                Math.round(center.x()), Math.round(window.getY() - center.y()));

        g2d.setColor(this.color);
        g2d.setStroke(new BasicStroke(lineWidth));
        g2d.drawLine(Math.round(a.x()), Math.round(a.getPosY()),
            Math.round(b.x()), Math.round(b.getPosY()));
    }

    @Override
    protected void setWindow(NuWindow nw){
        this.window = nw;
        this.a.setWindow(nw);
        this.b.setWindow(nw);
    }
}
