package nuswing;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Font;
import javax.swing.JLabel;

public class NuText extends NuShape {
    //TODO make methods for this class (TextField)
    private String text;
    private String font = "Helvetica";
    private int fontSize;
    protected JLabel label;

    // constructors
    public NuText(String text){
        this.position = new NuPoint(0,0);
        this.text = text;
        this.color = NuColor.BLACK;
        this.fontSize = 12;
    }

    public NuText(String text, NuPoint position){
        this.text = text;
        this.position = position;
        this.color = NuColor.BLACK;
        this.fontSize = 12;
    }

    public NuText(String text, int fontSize){
        this.position = new NuPoint(0,0);
        this.text = text; this.fontSize = fontSize;
        this.color = NuColor.BLACK;
    }

    public NuText(String text, int fontSize, NuPoint position){
        this.text = text;
        this.fontSize = fontSize;
        this.position = position;
        this.color = NuColor.BLACK;
    }
    // end constructors

    // draw function
    @Override
    protected void draw(Graphics g){
        Graphics2D g2d = (Graphics2D) g;

        g2d.setPaintMode();
        g2d.setFont(new Font(font, Font.PLAIN, fontSize));

        if(this.angle > 0 && center != null)
            g2d.rotate(Math.toRadians(this.angle), Math.round(position.x()),
                Math.round(window.getY() - center.y()));

        g2d.setColor(color);
        g2d.drawString(text, position.x(), position.getPosY());
    }
    // end draw

    // utility functions
    public void setFontSize(int pts){
        this.fontSize = pts;
    }

    public void setText(String text){
        this.text = text;
    }

    @Override
    protected void setWindow(NuWindow nw){
        this.window = nw;
        this.position.setWindow(nw);

    }
    // end utility functions
}
