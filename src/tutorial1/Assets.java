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
    public static BufferedImage Bullet1;    //Sprite for the ship bullets
    public static BufferedImage Bullet2;    //Sprite for the aliens bullets
    public static BufferedImage pink[];     //Sprite for the pink alien
    public static BufferedImage orange[];   //Sprite for the orange alien
    public static BufferedImage blue[];     //Sprite for the blue alien
    public static BufferedImage green[];    //Sprite for the green alien
    public static BufferedImage Spink;     //Sprite for the pink alien
    public static BufferedImage Sorange;   //Sprite for the orange alien
    public static BufferedImage Sblue;     //Sprite for the blue alien
    public static BufferedImage Sgreen;    //Sprite for the green alien
    
    public static void init(){
        background = ImageLoader.loadImage("/tutorial1/images/Background.png");
        player = ImageLoader.loadImage("/tutorial1/images/shipC.png");
        playerL = ImageLoader.loadImage("/tutorial1/images/shipL.png");
        playerR = ImageLoader.loadImage("/tutorial1/images/shipR.png");
        Bullet1 = ImageLoader.loadImage("/tutorial1/images/projectile1.png");
        Bullet2 = ImageLoader.loadImage("/tutorial1/images/projectile2.png");
        Spink = ImageLoader.loadImage("/tutorial1/images/pink.png");
        Sorange = ImageLoader.loadImage("/tutorial1/images/orange.png");
        Sblue = ImageLoader.loadImage("/tutorial1/images/blue.png");
        Sgreen = ImageLoader.loadImage("/tutorial1/images/green.png");
        SpriteSheet spritesheetp = new SpriteSheet(Spink);
        SpriteSheet spritesheeto = new SpriteSheet(Sorange);
        SpriteSheet spritesheetb = new SpriteSheet(Sblue);
        SpriteSheet spritesheetg = new SpriteSheet(Sgreen);
        pink = new BufferedImage[2];
        orange = new BufferedImage[2];
        blue = new BufferedImage[2];
        green = new BufferedImage[2];
        //croping the pictures from the sheet int the array
        for (int i = 0; i < 2; i++){
            pink[i] = spritesheetp.crop((i * 120)+10, 0, 98, 98);
            orange[i] = spritesheeto.crop((i * 148)+25, 0, 100, 100);
            blue[i] = spritesheetb.crop((i * 120)+10, 0, 98, 98);
            green[i] = spritesheetg.crop((i * 157)+11, 0, 112, 112);
        }
    }
    
    
    
}
