package nuswing;

import javax.swing.JPanel;
import java.awt.Graphics;

public abstract class NuComponent{
    protected NuWindow window;
    protected boolean visible;

    public NuComponent(){
    }

    /**
    * Empty methods.
    * draw is overwritten by NuShape classes.
    * draw should do nothing in NuButton and NuTextfield.
    *
    * addToPanel and removeFromPanel are overwritten by
    * NuTextfield and NuButton.
    * addToPanel should do nothing in NuShapes.
    */
    protected void draw(Graphics g){}
    protected void addToPanel(JPanel jp){}
    protected void removeFromPanel(JPanel jp){}

    protected void setWindow(NuWindow window){
        this.window = window;
    }

    public boolean remove(){
        return this.window.remove(this);
    }

    public void setVisible(boolean visible){
        this.visible = visible;
    }
}
