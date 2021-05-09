package NuSwing;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.*;

public class NuButton extends NuComponent {
    protected JButton button;
    private Runnable action;

    private String name;
    private NuPoint position;
    private int width;
    private int height;

    public NuButton(String name, NuPoint position, int width, int height){
        this.name = name; this.width = width; this.height = height;
        this.position = position;
        button = new JButton(name);
        setAction(null);
    }

    public NuButton(String name, NuPoint position, int width, int height, Runnable action){
        this.name = name; this.width = width; this.height = height;
        this.position = position;
        button = new JButton(name);
        setAction(action);
    }

    public void setAction(Runnable action){
        if (action != null) {
            this.action = action;
            button.addActionListener(new ButtonListener());
            button.setEnabled(true);
        } else {
            button.setEnabled(false);
        }
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            action.run();
        }
    }

    @Override
    protected void setWindow(NuWindow nw){
        this.window = nw;
        position.setWindow(nw);
        button.setBounds(Math.round(position.x()), nw.getY() - (Math.round(position.y() + height)), width, height);
    }

    @Override
    protected void addToPanel(JPanel jpnl){
        button.setVisible(true);
        jpnl.add(button);
    }

    @Override
    protected void removeFromPanel(JPanel jpnl){
        jpnl.remove(button);
    }

    @Override
    public void setVisible(boolean visible){
        button.setVisible(visible);
    }
}
