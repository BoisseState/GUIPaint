package assignment5;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Stroke;
import java.awt.Graphics2D;
import java.awt.GradientPaint;
import java.awt.geom.Ellipse2D;
/**
 *
 * @author JoeBoisse
 */
public class Ovals extends Shapes_2D
{
    public Ovals()
    {
        super(0,0,0,0, new BasicStroke(), Color.BLACK, null, false);
    }
    
    public Ovals(int x, int y, int len, int wid, Stroke stroke, Color c1,
            Color c2, boolean fill)
    {
        super(x, y, len, wid, stroke, c1, c2, fill);
    }
    
    @Override
    public void drawer(Graphics2D g)
    {
        if (super.isFill())
        {
            Ellipse2D elip = new Ellipse2D.Double(super.getUpperLeftX(), 
                super.getUpperLeftY(), super.getWidth(), super.getHeight());
            g.fill(elip);
        }
        
       if (super.getC2() == null)
            g.setPaint(super.getC1());
        
        else
        {
            if(super.isGradient())
            {
                GradientPaint gradient = new GradientPaint(super.getX(), 
                        super.getY(), super.getC1(), super.getLen(), 
                        super.getWid(), super.getC2());
                g.setPaint(gradient);
            }
            //else
               //g.setPaint(super.getC1());
        }        
       
        if (super.getlWidth() != 1)
        {
            if (super.isDash())
            {
                g.setStroke(new BasicStroke(super.getlWidth(), 
                    BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, 
                    super.getdLength(), 0.0f));
            }
            else{
                BasicStroke stroke = new BasicStroke(super.getlWidth());
                g.setStroke(stroke);
            }
        }
        else
           if (super.isDash()){
                g.setStroke(new BasicStroke(1.0f, BasicStroke.CAP_BUTT, 
                    BasicStroke.JOIN_MITER, 10.0f, super.getdLength(), 
                    0.0f));
            }
            else
                g.setStroke(super.getStroke());
        
        g.drawOval(super.getUpperLeftX(), super.getUpperLeftY(), 
                super.getWidth(), super.getHeight());
    }
    

    
}
