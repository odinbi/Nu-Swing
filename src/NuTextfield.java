package nuswing;

import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.*;
import java.awt.Dimension;

public class NuTextfield extends NuComponent{
    protected JTextField textField;

    private NuPoint position;
    private int width;
    private int height;

    public NuTextfield(String text, NuPoint position){
        this.position = position;
        textField = new JTextField(text);

        //assign deffault width and height
        width = 100; height = 20;
    }

    public NuTextfield(String text, NuPoint position, int width, int height){
        this.position = position; this.width = width; this.height = height;
        textField = new JTextField(text);
    }

    public String getText(){
        return textField.getText();
    }

    public void setText(String text){
        textField.setText(text);
    }


    @Override
    protected void setWindow(NuWindow nw){
        this.window = nw;
        position.setWindow(nw);

        textField.setBounds(Math.round(position.x()), nw.getY() - (Math.round(position.y() + height)), width, height);
    }

    @Override
    protected void addToPanel(JPanel jpnl){
        textField.setVisible(true);
        jpnl.add(textField);
    }

    @Override
    protected void removeFromPanel(JPanel jpnl){
        jpnl.remove(textField);
    }

    @Override
    public void setVisible(boolean visible){
        textField.setVisible(visible);
    }
}
