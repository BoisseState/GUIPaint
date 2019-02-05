/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment5;

import javax.swing.JFrame;

/**
 *
 * @author JoeBoisse
 */
public class runner 
{
    public static void main(String args[])
    {
        Interface frm = new Interface();
        
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setSize(750,500);
        frm.setVisible(true);
    }
}
