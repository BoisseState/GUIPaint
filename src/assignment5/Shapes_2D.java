package assignment5;


import java.awt.Color;
import java.awt.Stroke;
import java.awt.Graphics2D;


public abstract class Shapes_2D extends Shapes
{
    private boolean fill;
    
    public Shapes_2D(int x, int y, int len, int wid, Stroke stroke, Color c1,
            Color c2, boolean fill)
    {
        super(x, y, len, wid, stroke, c1, c2);
        this.fill = fill;
    }

    @Override
    public void setFill(boolean fill) {
        this.fill = fill;
    }

    @Override
    public boolean isFill() 
    {
        return fill;
    }
    
    @Override
    public abstract void drawer(Graphics2D g);
  
    
    public int getUpperLeftX(){
        return (super.getX() < super.getLen()) ? super.getX() : super.getLen();
    }
    
    public int getUpperLeftY(){
        return (super.getY() < super.getWid()) ? super.getY() : super.getWid();
    }
    
    public int getWidth(){
        return Math.abs(super.getX() - super.getLen());
    }
    
    public int getHeight(){
        return Math.abs(super.getY() - super.getWid());
    }
}
