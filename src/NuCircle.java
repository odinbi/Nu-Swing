package NuSwing;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.BasicStroke;

import javax.swing.JFrame;

import java.lang.Math;

public class NuCircle extends NuShape {
    private float radius;
    private int frame_x, frame_y;
    private int diameter;

    // constructors
    public NuCircle(float radius){
        //super();
        position = new NuPoint(0, 0);
        this.radius = radius;
        color = NuColor.GRAY;

        /**
        * Graphics operates with height and with of an arc/oval in relation to
        * the upper left corner of the figure, thus the radius needs to be
        * doubled into the diameter and converted into an integer.
        */
        diameter = Math.round(radius) * 2;
    }

    public NuCircle(float radius, NuPoint position){
        //super();
        this.radius = radius; this.position = position;
        color = NuColor.GRAY; this.outline = NuColor.GRAY;
        diameter = Math.round(radius) * 2;
    }

    public NuCircle(float radius, NuPoint position, NuColor color){
        //super();
        this.radius = radius; this.position = position;
        this.color = color; this.outline = color;
        diameter = Math.round(radius) * 2;
    }
    // end constructors

    @Override
    protected void draw(Graphics g){
        Graphics2D g2d = (Graphics2D) g;

        /**
        * Since Graphics positions always are the top left corner of the drawing
        * the circle coordinates needs to be translated to Graphics coordinates.
        *
        * For the x axis that means moving the circle to the left by the distance
        * of the radius.
        *
        * For the y axis that means moving the cirlce up by the distance of the
        * radius. In addition to fliping the y axis from a standard carthesian
        * to the inverted y axis used by Graphics.
        */
        frame_x = Math.round(position.x() - radius);
        frame_y = window.getY() - Math.round(position.y() + radius);

        g2d.setPaintMode();

        if(this.angle > 0 && center != null)
            g2d.rotate(Math.toRadians(this.angle), Math.round(center.x()),
                window.getY() - Math.round(center.y()));

        // fills circle body
        g2d.setColor(this.color);
        g2d.fillArc(frame_x, frame_y, diameter, diameter, 0, 360);

        // draws the outline of the circle
        g2d.setStroke(new BasicStroke(lineWidth));
        g2d.setColor(this.outline);
        g2d.drawArc(frame_x, frame_y, diameter, diameter, 0, 360);
    }
    // end draw

    @Override
    protected void setWindow(NuWindow nw){
        this.window = nw;
        this.position.setWindow(nw);
    }
    // end utility functions
}
