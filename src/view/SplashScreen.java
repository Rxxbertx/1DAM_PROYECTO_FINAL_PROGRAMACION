package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.geom.RoundRectangle2D;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JWindow;

public class SplashScreen extends JWindow {
    
    public SplashScreen( ) {
    	
    	Icon gif = new ImageIcon("src/images/logo.gif");
    	
        JLabel label = new JLabel(gif);
        getContentPane().add(label, BorderLayout.CENTER);
        pack();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(screenSize.width/2 - getSize().width/2, screenSize.height/2 - getSize().height/2);
        int width = getWidth();
        int height = getHeight();
        Shape shape = new RoundRectangle2D.Double(0, 0, width, height, 20, 20);
        setShape(shape);
    }
    
    
    public void showSplash() {
        setVisible(true);
        try {
            Thread.sleep(4000); // Tiempo en milisegundos que se mostrará el Splash Screen
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        setVisible(false);
    }
}
