package assignment5;

import javax.swing.JFrame; 
import javax.swing.JLabel; 
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JColorChooser;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.GridLayout;

public class Interface extends JFrame
{
    
    private final JButton undo, clear, c1, c2;
    private final JLabel l1, l2, l3;
    private final JComboBox<String> shapeList;
    private final JCheckBox fill;
    private JCheckBox gradient, dash;
    private final JTextField w, l;
    private static final String[] shapes ={"Line","Oval","Rectangle"};
    private int select;
    private float [] dArray;
    private float dLength; 
    float lineWidth;
    
   
    public Interface()
    {       
        super("Java 2D Drawings");
        select = 0;
        undo = new JButton("Undo");
        setLayout(new BorderLayout());
        clear = new JButton("Clear");
        l1 = new JLabel("Shape:");
        shapeList= new JComboBox<>(shapes);
        shapeList.setMaximumRowCount(3);
        fill = new JCheckBox("Filled");
        gradient = new JCheckBox("Use Gradient");
        c1=new JButton("1st Color");
        c2 = new JButton("2nd Color");
        l2 = new JLabel("Line Width:");
        w = new JTextField(2);
        l3 = new JLabel("Dash Length:");
        l = new JTextField(2);
        dash = new JCheckBox("Dashed");
        JLabel mLocation = new JLabel("(0,0)");
        mLocation.setLayout(new BorderLayout());
        this.add(mLocation, BorderLayout.SOUTH);
        
        JPanel main = new JPanel();
        main.setLayout(new GridLayout(2,1));
        JPanel p1 = new JPanel();
        p1.setLayout(new FlowLayout());
        JPanel p2 = new JPanel();
        p2.setLayout(new FlowLayout());
        DrawPanel dPanel = new DrawPanel(mLocation);
        dPanel.setLayout(new BorderLayout());
        dPanel.setShapeType(select);
        this.add(dPanel, BorderLayout.CENTER);
        
        
        p1.add(undo);
        p1.add(clear);
        p1.add(l1);
        p1.add(shapeList);
        p1.add(fill);
        main.add(p1);
        p2.add(gradient);
        p2.add(c1);
        p2.add(c2);
        p2.add(l2);
        p2.add(w);
        p2.add(l3);
        p2.add(l);
        p2.add(dash);
        main.add(p2);
        this.add(main, BorderLayout.NORTH);
        
        undo.addActionListener((ActionEvent e) -> {
            dPanel.clearLastShape();
        });
        
        clear.addActionListener((ActionEvent e) -> {
            dPanel.clearDrawing();
        });
        
        shapeList.addActionListener((ActionEvent e) -> {
            select = shapeList.getSelectedIndex();
            dPanel.setShapeType(select);
        });
        
        fill.addItemListener((ItemEvent e) -> {
            if(e.getStateChange() == ItemEvent.SELECTED)
                dPanel.Filler(true);
            else
                dPanel.Filler(false);
        });
        
        gradient.addItemListener((ItemEvent e) -> {
            if(e.getStateChange() == ItemEvent.SELECTED)
                dPanel.Gradient(true);
            else
                dPanel.Gradient(false);
        });
        
        dash.addItemListener((ItemEvent e) -> {
        if(e.getStateChange() == ItemEvent.SELECTED)
            dPanel.setDash(true);
        else
            dPanel.setDash(false);
        });
        
        l.addActionListener((ActionEvent e) ->
            {
               if(l.getText() == null)
                   dPanel.setdLength(null);
               else
               {
                   dLength = Float.valueOf(l.getText());
                   dArray = new float [1];
                   dArray[0] = dLength;
                   dPanel.setdLength(dArray);
               }
            });
        
        c1.addActionListener((ActionEvent e) -> {
            Color main1 = JColorChooser.showDialog(dPanel, "Color 1", 
                    Color.BLACK);
            dPanel.setC1(main1);
        });
        
         c2.addActionListener((ActionEvent e) -> {
            Color secondary = JColorChooser.showDialog(dPanel, "Color 2", null);
            dPanel.setC2(secondary);
        });
         
          w.addActionListener((ActionEvent e) ->
            {
               if(w.getText() == null)
                   dPanel.setlWidth(1.0f);
               else
               {
                   Float lineWidth =Float.valueOf(w.getText());
                   dPanel.setlWidth(lineWidth);
               }
            });
    }
}



