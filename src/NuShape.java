package nuswing;
import java.awt.Graphics;
import javax.swing.JPanel;

abstract class NuShape extends NuComponent {
    protected NuColor color;
    protected NuColor outline;
    protected int lineWidth = 1;
    protected double angle = 0;
    protected NuPoint center;
    protected NuPoint position;

    NuShape() {
        super();
    }

    public void setOutlineColor (NuColor color){
        this.outline = color;
    }

    public void setColor (NuColor color){
        this.color = color;
    }

    public void setLineWidth(int pts){
        this.lineWidth = pts;
    }

    public void move(float x, float y){
        this.position.move(x, y);
    }

    // rotate should tage degrees to rotate and a point of rotation
    public void rotate(float degrees, NuPoint point){
        this.angle = Math.round(degrees);
        this.center = point;
    }
}
