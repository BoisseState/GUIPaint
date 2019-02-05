package assignment5;

import java.awt.Stroke;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;


public abstract class Shapes 
{
    private int x, y, len, wid;
    private final Stroke stroke;
    private boolean dash, gradient, fill;
    private float lWidth;
    private Color c1, c2;
    private float [] dLength;
    
    
    public Shapes()
    {
        this.x=0;
        this.y=0;
        this.len=0;
        this.wid=0;
        this.stroke= new BasicStroke();
        this.c1=Color.BLACK;
        this.c2=null;
        this.lWidth = 1;
        
    }

    public Shapes(int x, int y, int len, int wid, Stroke stroke, 
            Color c1, Color c2) 
    {
        this.x = x;
        this.y = y;
        this.len = len;
        this.wid = wid;
        this.stroke = stroke;
        this.c1 = c1;
        this.c2 = c2;
        this.lWidth = 1;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getLen() {
        return len;
    }

    public int getWid() {
        return wid;
    }

    public Stroke getStroke() {
        return stroke;
    }

    public boolean isDash() {
        return dash;
    }

    public float getlWidth() {
        return lWidth;
    }

    public Color getC1() {
        return c1;
    }

    public Color getC2() {
        return c2;
    }
    

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setLen(int len) {
        this.len = len;
    }

    public void setWid(int wid) {
        this.wid = wid;
    }

    public void setDash(boolean dash) {
        this.dash = dash;
    }

    public void setlWidth(float lWidth) {
        this.lWidth = lWidth;
    }

    public void setC1(Color c1) {
        this.c1 = c1;
    }

    public void setC2(Color c2) {
        this.c2 = c2;
    } 
    
    public abstract void drawer(Graphics2D g);

    public float[] getdLength() {
        return dLength;
    }

    public void setdLength(float[] dLength) {
        this.dLength = dLength;
    }

    public boolean isGradient() {
        return gradient;
    }

    public void setGradient(boolean gradient) {
        this.gradient = gradient;
    }

    public void setFill(boolean fill) 
    {
        this.fill = fill;
    }

    public boolean isFill() 
    {
        return fill;
    }

}
