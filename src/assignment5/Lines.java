
package assignment5;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Stroke;
import java.awt.Graphics2D;
import java.awt.GradientPaint;


public class Lines extends Shapes
{
    Color cl1, cl2;
    
    public Lines(int x, int y, int len, int wid, Stroke stroke, Color c1, Color c2) 
    {
        super(x, y, len, wid, stroke, c1, c2);
    }

    Lines() 
    {
        super(0, 0, 0, 0, new BasicStroke(), Color.BLACK, null);
    }
    
    @Override
    public void drawer(Graphics2D g)
    {
        
        if(super.getlWidth()==1)
        {
            if(super.isDash()==true)
            {
            g.setStroke(new BasicStroke(1.0f, java.awt.BasicStroke.CAP_BUTT, 
                    java.awt.BasicStroke.JOIN_MITER, 10.0f, 
                    super.getdLength(), 0.0f));
            }
            else
                g.setStroke(super.getStroke());
       
        }
        else
        {
            if(super.isDash()==true)
            {
                 g.setStroke(new BasicStroke(super.getlWidth(), 
                    java.awt.BasicStroke.CAP_BUTT, 
                    java.awt.BasicStroke.JOIN_MITER, 10.0f, 
                    super.getdLength(), 0.0f));
            }
            else
                g.setStroke(new BasicStroke(super.getlWidth()));
        }
                
        cl1 = super.getC1();
        cl2 = super.getC2();
        if(super.getC2()!=null)
        {
            g.setPaint(new GradientPaint(0,0, cl1, 50, 50, cl2, true));
        }
        else
            g.setPaint(cl1);
        
        
        int x = super.getX();
        int y = super.getY();
        int len = super.getLen();
        int wid = super.getWid();
        g.drawLine(x, y, len, wid);
    }
    
}
