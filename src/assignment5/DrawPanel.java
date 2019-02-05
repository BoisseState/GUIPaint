package assignment5;


import java.awt.Color;
import javax.swing.JLabel; 
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseListener;
import javax.swing.JPanel;


public class DrawPanel extends JPanel implements MouseListener, 
        MouseMotionListener
{
    
    private Point cP;
    private Color c1, c2;
    private boolean fill, gradient, dash, clear;
    private JLabel mLocation;
    private Shapes currentShape;
    private int count, type;
    private float width;
    private float [] dLength;
    private String mouseLocation;
    public ArrayList<Shapes> shapes;
    
    
    public DrawPanel(JLabel mLocation)
    {
        
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.mLocation = mLocation;
        this.setBackground(Color.WHITE);
        this.c1 = Color.BLACK;
        this.c2 = null;
        this.fill = false;
        this.shapes = new ArrayList<>();
        this.count = 0;
        this.width = 1;
        this.dLength = null;
        this.dash = false;
        this.clear = false;
       

    }

    @Override
    public void mousePressed(MouseEvent e) 
    {
        setShapeType(type);
        currentShape.setX(e.getX());
        currentShape.setY(e.getY());
        currentShape.setLen(e.getX());
        currentShape.setWid(e.getY());
        currentShape.setDash(dash);
        currentShape.setdLength(dLength);
        currentShape.setlWidth(width);
        currentShape.setC1(c1);
        currentShape.setC2(c2);
        cP = e.getPoint();
        mouseLocation = "("+cP.x+","+cP.y+")";    
        mLocation.setText(mouseLocation);        
    }

    @Override
    public void mouseReleased(MouseEvent e) 
    {
       currentShape.setLen(e.getX());
       currentShape.setWid(e.getY());
       addShape(currentShape);
       repaint();
       
    }

    @Override
    public void mouseDragged(MouseEvent e) 
    {
        cP = e.getPoint();
        mouseLocation = "("+cP.x+","+cP.y+")";    
        mLocation.setText(mouseLocation);
        currentShape.setC1(c1);
        currentShape.setC2(c2);
        currentShape.setLen(e.getX());
        currentShape.setWid(e.getY());
        if(gradient)
            currentShape.setGradient(true);
        if(fill)
            currentShape.setFill(true);
        currentShape.setlWidth(width);
        repaint();
        
        
    }

    @Override
    public void mouseMoved(MouseEvent e) 
    {
        cP = e.getPoint();
        mouseLocation = "("+cP.x+","+cP.y+")";    
        mLocation.setText(mouseLocation);
    }

    @Override
    public void mouseClicked(MouseEvent e) 
    {
       
    }

    @Override
    public void mouseEntered(MouseEvent e) 
    {
        
    }

    @Override
    public void mouseExited(MouseEvent e) 
    {
        
    }
   
   @Override
   public void paintComponent (Graphics g)
   {
       Graphics2D temp = (Graphics2D) g;
       super.paintComponent(g);
       shapes.forEach((shape) -> {
           shape.drawer(temp);
        });
       if(!(this.clear))
       {
           if(currentShape!=null)
               currentShape.drawer(temp);
       }
       this.clear = false;
   }
   
   public void setShapeType(int select){
        type = select;
        switch (select) 
        {
            case 0:
                currentShape = new Lines();
                break;
            case 1:
                currentShape = new Ovals();
                break;
            case 2:
                currentShape = new Rectangles();
                break;
            default:
                break;
        }
    }
   
   public void addShape(Shapes shape)
   {
        shapes.add(shape);                 
        count += 1;
    }
   public void clearDrawing(){          
        shapes.clear();
        count = 0;
        this.clear = true;
        repaint();
    }
   public void clearLastShape()
   {  
        currentShape = null;
        if (count > 0){
            Shapes toBeRemoved = shapes.get(count - 1);
            shapes.remove(toBeRemoved);
            count = count - 1;
            System.out.print(shapes);
            repaint();
        }
        if (count == 0)
            this.clearDrawing();
   }
   
   public void Filler(boolean f)
   {
       fill = f;
   }
   public void Gradient(boolean g)
   {
       gradient = g;
   }
   public void setC1(Color main)
   {
       this.c1 = main;
   }
   public void setC2(Color secondary)
   {
       this.c2 = secondary;
   }

    public void setdLength(float[] dLength) 
    {
        this.dLength = dLength;
    }

    public boolean isDash() {
        return dash;
    }
    
    public void setDash(boolean dash) 
    {
        this.dash = dash;
    }

    public float getlWidth() 
    {
        return width;
    }

    public void setlWidth(float width) 
    {
        this.width = width;
    }
    
   
}
