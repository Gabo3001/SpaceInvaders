/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorial1;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author HOME
 */
public class BulletA extends Item {

    private int direction;
    private int width;
    private int height;
    private Game game;
    private int speed;
    private boolean visible; //controls when the bullet should move

    public BulletA(int x, int y, int direction, int width, int height, Game game) {
        super(x, y);
        this.direction = direction;
        this.width = width;
        this.height = height;
        this.game = game;
        this.speed = 3;
        visible = false;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public boolean isVisible() {
        return visible;
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
        //if the game is not in pause
        if (!game.isPause()) {
            if (isVisible()) {
                // moving player depending on flags
                setY(getY() + getSpeed());
            }
            if (getY() > 500) {
                setVisible(false);
            }
        }
    }

    /**
     * Creates a rectangle around the bullet
     *
     * @return a rectangle with the dimensions of the bullet
     */
    public Rectangle getPerimetro() {
        return new Rectangle(getX(), getY(), getWidth(), getHeight());
    }

    /**
     * This function tells us when the bullet intersects another object
     *
     * @param obj gets the object that intersects with the bullet
     * @return a boolean when the bullet intersects another object
     */
    public boolean intersecta(Object obj) {
        return obj instanceof Player && getPerimetro().intersects(((Player) obj).getPerimetro());
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.Bullet2, getX(), getY(), getWidth(), getHeight(), null);
    }

}
