package nuswing;

import java.awt.Graphics;

public class NuPoint extends NuShape {
    private float x;
    private float y;

    public NuPoint(float x, float y){
        this.x = x; this.y = y;
    }

    /**
    * X() and Y()
    * returns the x and y values of the point
    */
    public float x() {
        return x;
    }

    public float y() {
        return y;
    }

    /**
    * getPosX() and getPosY()
    * returns the positional coordinates in relation to the inverted y-axis
    * if no grid is referenced getPosY returns the y value without conversion.
    */
    protected float getPosX(){
        return x;
    }

    protected float getPosY(){
        if(window == null){return y;}

        return window.getY() - y;
    }

    /**
    * moveTo
    * moves the point to the given coordinates
    */
    public void moveTo(float x, float y){
        this.x = x; this.y = y;
    }

    //regular move function
    public void move(float x, float y){
        this.x += x; this.y += y;
    }

    //in case move is called on object with same point ref.
    protected NuPoint moveShape(float x, float y){
        return new NuPoint(this.x + x, this.y + y);
    }
}
