package nuswing;

import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;


public class NuWindow{
    private ArrayList<NuComponent> elements;
    private JFrame frame;
    private NuColor color;

    private WindowRunner wr;
    private NuPanel panel;

    private int refreshRate = 25; //fps/Hz
    private Thread t;
    private int x, y;

    /**
    * Runs the thread that repaints the window
    */
    private class WindowRunner implements Runnable{

        public void run() {
            frame.setVisible(true);
            panel.setBackground(color);

            while(true){
                try{
                    Thread.sleep(1000/refreshRate); // Simulates refreshrate
                    panel.repaint();
                } catch(Exception e){
                    return;
                }
            }
        }
    } //end WindowRunner

    /**
    * lets the NuWindow draw NuComponents
    */
    private class NuPanel extends JPanel {
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            for (NuComponent gc : elements) {
                gc.draw(g);
            }
        }
    } //end NuPanel

    //Initiates the NuWindow object
    private void init(String title, int x, int y, NuColor color){
        //generating frame/window
        frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.x = x; this.y = y;
        frame.setSize(x, y);
        this.color = color;
        frame.setLayout(null);

        //generating panel to display contents
        panel = new NuPanel();
        panel.setSize(x, y);
        panel.setLayout(null);
        frame.add(panel);

        //array containing components
        elements = new ArrayList<NuComponent>();

        //WindowRunner thread startup
        this.wr = new WindowRunner();
        t = new Thread(wr);
        t.start();
    } //end init


    /**
    * Constructors
    *
    * NuWindow always have a size defined by the width x and the height y.
    * NuWindow may have a title.
    * NuWindow may have a color.
    *
    * @param  x  the size of the window along the x axis
    * @param  y  the size of the window along the y axis
    * @param  color  the background color of the window
    * @param  title  the title of the window
    */
    public NuWindow(int x, int y){
        init("", x, y, NuColor.WHITE);
    }

    public NuWindow(String title, int x, int y){
        init(title, x, y, NuColor.WHITE);
    }

    public NuWindow(int x, int y, NuColor color) {
        init("", x, y, color);
    }

    public NuWindow(String title, int x, int y, NuColor color) {
        init(title, x, y, color);
    }
    //end constructors

    /* Various help functions */
    /**
    * getY() and getX()
    * lets children get the x,y dimensions of the frame
    */
    protected int getY(){
        return this.y;
    }

    protected int getX(){
        return this.x;
    }

    /**
    * sets background color of NuWindow
    */
    public void setColor(NuColor color){
        this.color = color;
    }

    //LIST MANIPULATION METHODS
    /**
    * adds component to the element list
    */
    public void addComponent(NuComponent comp){
        elements.add(comp);
        comp.setWindow(this);

        if(comp instanceof NuButton || comp instanceof NuTextfield){
            comp.addToPanel(panel);
        }
    }

    /**
    * removes component to the element list
    */
    public boolean remove(NuComponent comp){
        if(comp instanceof NuButton || comp instanceof NuTextfield){
            comp.removeFromPanel(panel);
        }

        return this.elements.remove(comp);
    }

    /**
    * gets a copy of the element list
    */
    public ArrayList<NuComponent> getList(){
        return new ArrayList<NuComponent>(elements);
    }

    /**
    * sets element list to a copy of the given list
    */
    public void setList(ArrayList<NuComponent> list){
        elements = new ArrayList<NuComponent>(list);
        updatePanelElems();
    }

    // makes sure every element in the new list is drawable
    private void updatePanelElems(){
        panel.removeAll();
        for(NuComponent comp : elements){
            comp.setWindow(this);
            if(comp instanceof NuButton || comp instanceof NuTextfield){
                comp.addToPanel(panel);
            }
        }
    }
    //end list manipulation methods
}
