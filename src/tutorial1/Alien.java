/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorial1;

import java.awt.Graphics;

/**
 *
 * @author HOME
 */
public class Alien extends Item {

    private int direction;
    private int width;
    private int height;
    private Game game;
    private int speed;
    private Animation pink;
    private Animation blue;
    private Animation green;
    private Animation orange;

    public Alien(int x, int y, int direction, int width, int height, Game game) {
        super(x, y);
        this.direction = direction;
        this.width = width;
        this.height = height;
        this.game = game;
        this.speed = 3;
        this.pink = new Animation (Assets.pink, 500);
        this.blue = new Animation (Assets.blue, 500);
        this.green = new Animation (Assets.green, 500);
        this.orange = new Animation (Assets.orange, 500);
    }

    public int getDirection() {
        return direction;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public void tick() {
        //HAY QUE PONERLE CONDICIONES PARA QUE HAGA EL TICK DE ANIMATION
//        this.pink.tick();
//        if (game.getKeyManager().up){
//            this.blue.tick();
//        }
//        if (game.getKeyManager().down){
//            this.orange.tick();
//        }
//        if (game.getKeyManager().left){
//            this.green.tick();
//        }
    }

    @Override
    public void render(Graphics g) {
        //HAY QUE PONERLE CONDICIONES PARA QUE SE VEA DEPENDIENDO EL TIP
//        if (game.getKeyManager().up)
//            g.drawImage(blue.getCurretFrame(), getX(), getY(), getWidth(), getHeight(), null);
//        else if (game.getKeyManager().left)
//            g.drawImage(green.getCurretFrame(), getX(), getY(), getWidth(), getHeight(), null);
//        else if (game.getKeyManager().down)
//            g.drawImage(orange.getCurretFrame(), getX(), getY(), getWidth(), getHeight(), null);
//        else
//            g.drawImage(pink.getCurretFrame(), getX(), getY(), getWidth(), getHeight(), null);
    }

}
