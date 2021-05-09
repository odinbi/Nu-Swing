package NuSwing;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BasicStroke;

public class NuRectangle extends NuShape {
    private float width;
    private float height;
    private float angle;

    // constructors
    public NuRectangle (float width, float height){
        this.width = width; this.height = height;
        this.position = new NuPoint(0,0);
        this.color = NuColor.GRAY;
    }

    public NuRectangle (float width, float height, NuPoint position){
        this.width = width; this.height = height; this.position = position;
        this.color = NuColor.GRAY;
    }

    public NuRectangle (float width, float height, NuPoint position, NuColor color){
        this.width = width; this.height = height; this.position = position;
        this.color = color;
    }
    // end constructors

    /**
    * Since y-axis is inverted the Y position of the rectangle have to be moved
    * along the Y axis in relation to the height of the rectangle.
    */
    @Override
    protected void draw(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaintMode();

        /**
        * If angle is greater than 0, then rotate figure around
        * the center of the figure.
        */
        if (this.angle > 0 && center != null)
            g2d.rotate(Math.toRadians(this.angle), Math.round(center.x()),
                Math.round(window.getY() - center.y()));

        g2d.setColor(this.color);
        g2d.fillRect(Math.round(position.x()),
            Math.round(position.getPosY() - height),
            Math.round(width), Math.round(height));

        g2d.setColor(this.outline);
        g2d.drawRect(Math.round(position.x()),
            Math.round(position.getPosY() - height),
            Math.round(width), Math.round(height));

        //g2d.dispose();
    }

    // utility functions
    @Override
    protected void setWindow(NuWindow nw){
        this.window = nw;
        this.position.setWindow(nw);
    }
    // end utility functions
}
