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
public class Bullet extends Item {

    private int direction;
    private int width;
    private int height;
    private Game game;
    private int speed;
    private boolean visible; //controls when the bullet should move

    public Bullet(int x, int y, int direction, int width, int height, Game game) {
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
        if (isVisible()) {
            // moving player depending on flags
            setY(getY() - getSpeed());
        }

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.Bullet1, getX(), getY(), getWidth(), getHeight(), null);
    }

}
