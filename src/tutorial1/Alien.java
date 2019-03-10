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
public class Alien extends Item {

    private int direction;
    private int width;
    private int height;
    private Game game;
    private int speed;
    private int type;       //Variable that control de type of the alien
    private int cont;       //Variable that control the movement of the aliens
    private boolean visible;
    private Animation pink;
    private Animation blue;
    private Animation green;
    private Animation orange;

    public Alien(int x, int y, int direction, int width, int height, Game game, int type) {
        super(x, y);
        this.direction = direction;
        this.width = width;
        this.height = height;
        this.game = game;
        this.type = type;
        this.speed = 15;
        this.cont = 0;
        this.visible = true;
        this.pink = new Animation(Assets.pink, 700);
        this.blue = new Animation(Assets.blue, 700);
        this.green = new Animation(Assets.green, 700);
        this.orange = new Animation(Assets.orange, 700);
    }

    public void setVisible(boolean Visible) {
        this.visible = Visible;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setCont(int cont) {
        this.cont = cont;
    }

    public int getCont() {
        return cont;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
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
                //Depending on the direction and only if the counter is 0 the aliens move
                //To the right
                if (getDirection() == 1 && getCont() == 0) {
                    setX(getX() + getSpeed());
                    Assets.move.play();
                }
                //To the left
                if (getDirection() == 2 && getCont() == 0) {
                    setX(getX() - getSpeed());
                    Assets.move.play();
                }
                //down
                if (getDirection() == 3 && getCont() == 0) {
                    setY(getY() + getSpeed());
                    Assets.move.play();
                    if (getX() >= 280) {
                        setDirection(2);
                    } else if (getX() < 280) {
                        setDirection(1);
                    }
                }
                //Depending of the type of alien the tick for its animation is called
                //0 for the blue alien

                // the counter that control the move increase by 1 every tick
                setCont(getCont() + 1);
                //when the counter reach 43 it is reset to 0
                if (getCont() == 43) {
                    setCont(0);
                }
            }
            if (getType() == 0) {
                this.blue.tick();
            }
            //1 for the green alien
            if (getType() == 1) {
                this.green.tick();
            }
            //2 for the orange
            if (getType() == 2) {
                this.orange.tick();
            }
            //3 for the pink
            if (getType() == 3) {
                this.pink.tick();
            }
        }
    }

    /**
     * Creates a rectangle around the ball
     *
     * @return a rectangle with the dimensions of the alien
     */
    public Rectangle getPerimetro() {
        return new Rectangle(getX(), getY(), getWidth(), getHeight());
    }

    @Override
    public void render(Graphics g) {
        if (getType() == 0) {
            g.drawImage(blue.getCurretFrame(), getX(), getY(), getWidth(), getHeight(), null);
        }
        if (getType() == 1) {
            g.drawImage(green.getCurretFrame(), getX(), getY(), getWidth(), getHeight(), null);
        }
        if (getType() == 2) {
            g.drawImage(orange.getCurretFrame(), getX(), getY(), getWidth(), getHeight(), null);
        }
        if (getType() == 3) {
            g.drawImage(pink.getCurretFrame(), getX(), getY(), getWidth(), getHeight(), null);
        }
    }

}
