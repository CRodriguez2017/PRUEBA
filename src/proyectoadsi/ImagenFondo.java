/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoadsi;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.imageio.ImageIO;
import static javax.swing.Spring.height;
import static javax.swing.Spring.width;
import javax.swing.border.Border;

/**
 *
 * @author Usuario
 */

public class ImagenFondo implements Border{
        
    
    public BufferedImage back;
    
    public ImagenFondo() throws MalformedURLException, IOException{
        try{
            URL imagePath = new URL(getClass().getResource("../Imagenes/fondo2.jpg").toString());
            back = ImageIO.read(imagePath);
            
        }catch(Exception ex){
            
        }
    }
     @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        
        g.drawImage(back, (x + (width - back.getWidth())/2), (y + (height - back.getHeight())/2), null);
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(0, 0, 0, 0);
    }

    @Override
    public boolean isBorderOpaque() {
        return false;
    }
    
}
