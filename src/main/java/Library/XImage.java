/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Library;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class XImage {
    public static Image resize(Image originalImage, int width, int height){
        Image resultingImage=originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return resultingImage;
    }
    
    public static byte [] toByteArray(Image img, String type) throws IOException{
        BufferedImage bImage=new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_BGR);
        Graphics2D g=bImage.createGraphics();
        g.drawImage(img, 0,0, null);
        g.dispose();
        
        ByteArrayOutputStream baos=new ByteArrayOutputStream();
        ImageIO.write(bImage, type, baos);
        byte[] imgInByte=baos.toByteArray();
        
        return imgInByte;
    }
    
    public static Image createImgFromByteArray(byte[] data, String type) throws IOException{
        ByteArrayInputStream bis=new ByteArrayInputStream(data);
        BufferedImage bImg2=ImageIO.read(bis);
            
        Image img=bImg2.getScaledInstance(bImg2.getWidth(), bImg2.getHeight(), BufferedImage.SCALE_SMOOTH);
        return img;
    }
    
    public static void icon(String path){
        ImageIcon img=new ImageIcon(path);
        
    }
}
