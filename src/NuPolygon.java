package NuSwing;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BasicStroke;

public class NuPolygon extends NuShape {
    private NuPoint[] points;
    private NuColor color;
    private int[] xPoints;
    private int[] yPoints;

    public NuPolygon(NuPoint[] points){
        this.points = points;
        color = NuColor.GRAY;
    }

    public NuPolygon(NuPoint[] points, NuColor color){
        this.points = points; this.color = color;
    }

    // separates x and y coordinates from NuPoint into int arrays
    private void convertPointsToArrays(){
        xPoints = new int[points.length];
        yPoints = new int[points.length];

        for(int i = 0; i < points.length; ++i){
            xPoints[i] = Math.round(points[i].x());
            yPoints[i] = Math.round(points[i].getPosY());
        }
    }

    @Override
    public void move(float x, float y){
        for (NuPoint p : points){
            p.move(x, y);
        }
        convertPointsToArrays();
    }

    @Override
    protected void draw(Graphics g){
        Graphics2D g2d = (Graphics2D) g;

        if(xPoints.length != points.length)
            convertPointsToArrays();

        g2d.setPaintMode();

        if(this.angle > 0 && center != null)
            g2d.rotate(Math.toRadians(this.angle), Math.round(center.x()),
                Math.round(window.getY() - center.y()));

        // fills polygon body
        g2d.setColor(this.color);
        g2d.fillPolygon(xPoints, yPoints, points.length);

        // draws outline of polygon
        g2d.setStroke(new BasicStroke(lineWidth));
        g2d.setColor(this.outline);
        g2d.drawPolygon(xPoints, yPoints, points.length);

        g2d.dispose();
    }

    @Override
    protected void setWindow(NuWindow nw){
        this.window = nw;

        for(NuPoint pt : points){
            pt.setWindow(nw);
        }
    }
}
