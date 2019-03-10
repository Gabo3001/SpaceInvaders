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
public class Player extends Item {

    private int direction;
    private int width;
    private int height;
    private Game game;
    private int speed;

    public Player(int x, int y, int direction, int width, int height, Game game) {
        super(x, y);
        this.direction = direction;
        this.width = width;
        this.height = height;
        this.game = game;
        this.speed = 3;
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
            // moving player depending on flags
            if (game.getKeyManager().left) {
                setX(getX() - getSpeed());
            }
            if (game.getKeyManager().right) {
                setX(getX() + getSpeed());
            }
            // reset x position and y position if colision
            if (getX() + 50 >= game.getWidth()) {
                setX(game.getWidth() - 50);
            } else if (getX() <= 0) {
                setX(0);
            }
        }

    }

    /**
     * Creates a rectangle around the ball
     *
     * @return a rectangle with the dimensions of the bullet
     */
    public Rectangle getPerimetro() {
        return new Rectangle(getX(), getY(), getWidth(), getHeight());
    }

    @Override
    public void render(Graphics g) {
        if (game.getKeyManager().left && !game.isPause()) {
            g.drawImage(Assets.playerL, getX(), getY(), getWidth(), getHeight(), null);
        } else if (game.getKeyManager().right && !game.isPause()) {
            g.drawImage(Assets.playerR, getX(), getY(), getWidth(), getHeight(), null);
        } else {
            g.drawImage(Assets.player, getX(), getY(), getWidth(), getHeight(), null);
        }
    }

}
