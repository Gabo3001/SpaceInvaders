/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorial1;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author HOME
 */
public class Display {
    private JFrame jframe;
    private Canvas canvas;
    private String title;
    private int width;
    private int height;
    
    public Display(String title, int width, int height){
    this.title = title;
    this.width = width;
    this.height = height;
    createDisplay();
}

public void createDisplay(){
    jframe = new JFrame(title);
    
    jframe.setSize(width, height);
    
    jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jframe.setResizable(false);
    jframe.setLocationRelativeTo(null);
    jframe.setVisible(true);
    
    canvas = new Canvas();
    canvas.setPreferredSize(new Dimension(width, height));
    canvas.setMaximumSize(new Dimension(width, height));
    canvas.setFocusable(false);
    
    jframe.add(canvas);
    jframe.pack();
}

public JFrame getJframe(){
    return jframe;
}

public Canvas getCanvas(){
    return canvas;
}
}