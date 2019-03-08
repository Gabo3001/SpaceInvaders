/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorial1;

import java.awt.image.BufferedImage;

/**
 *
 * @author HOME
 */
public class Assets {
    public static BufferedImage background;
    public static BufferedImage player;     //Sprite for the ship
    public static BufferedImage playerL;    //Sprite for the ship turning left
    public static BufferedImage playerR;    //Sprite for the ship turning right
    public static BufferedImage Bullet1;
    public static BufferedImage Bullet2;
    
    public static void init(){
        background = ImageLoader.loadImage("/tutorial1/images/Background.png");
        player = ImageLoader.loadImage("/tutorial1/images/shipC.png");
        playerL = ImageLoader.loadImage("/tutorial1/images/shipL.png");
        playerR = ImageLoader.loadImage("/tutorial1/images/shipR.png");
        Bullet1 = ImageLoader.loadImage("/tutorial1/images/projectile1.png");
        Bullet2 = ImageLoader.loadImage("/tutorial1/images/projectile2.png");
    }
    
    
    
}
