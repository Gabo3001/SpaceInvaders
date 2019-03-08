/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorial1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.LinkedList;

/**
 *
 * @author HOME
 */
public class Game implements Runnable {

    private BufferStrategy bs;
    private Graphics g;
    private Display display;
    String title;
    private int width;
    private int height;
    private Thread thread;
    private boolean running;
    private Player player;
    private LinkedList<Bullet> bullets;
    private KeyManager keyManager;
    private int contBullet;      //counter for all the bullets

    public Game(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
        running = false;
        keyManager = new KeyManager();
        bullets = new LinkedList<Bullet>();
        contBullet = 0;
    }

    public void setContBullet(int contBullet) {
        this.contBullet = contBullet;
    }

    public int getContBullet() {
        return contBullet;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    private void init() {
        display = new Display(title, getWidth(), getHeight());
        Assets.init();
        player = new Player(380, getHeight() - 120, 1, 50, 50, this);
        for (int i = 1; i <= 100; i++) {
            bullets.add(new Bullet(getWidth() + 10, -10, 1, 10, 20, this));
        }
        display.getJframe().addKeyListener(keyManager);
    }

    @Override
    public void run() {
        init();
        //frames per seconds
        int fps = 60;
        //time for each tick in nano seconds
        double timeTick = 1000000000 / fps;
        // inizialing delta
        double delta = 0;
        // define now to use inside the loop
        long now;
        // initializing last time to the computer time in nanosecs
        long lastTime = System.nanoTime();
        while (running) {
            // setting the time now to the actual time
            now = System.nanoTime();
            // acumulating to delta the difference between times in timeTick units
            delta += (now - lastTime) / timeTick;
            //updating the last time
            lastTime = now;

            // if delta is positive we tick the game
            if (delta >= 1) {
                tick();
                render();
                delta--;
            }
        }
        stop();
    }

    public KeyManager getKeyManager() {
        return keyManager;
    }

    private void tick() {
        keyManager.tick();
        // avanceing player with colision
        player.tick();
        for (int i = 0; i < bullets.size(); i++){
            Bullet bullet = bullets.get(i);
            bullet.tick();
            //if the bullet leave the screen
            if(bullet.getY() < -20){
                bullet.setVisible(false);
            }
        }
        //When the space key is press
        if (getKeyManager().space) {
            //A bullet is set infront of the ship
            Bullet bullet = bullets.get(getContBullet());
            bullet.setVisible(true);
            bullet.setX(player.getX() + 20);
            bullet.setY(player.getY() - 5);
            setContBullet(getContBullet()+1);
            //kStop is called to put space in false
            getKeyManager().kStop();
        }
        //If the counter of the bullets reach 99 or higher
        if (getContBullet() >= 99){
            //the conuter is set on 0
            setContBullet(0);
        }
    }

    private void render() {
        bs = display.getCanvas().getBufferStrategy();

        if (bs == null) {
            display.getCanvas().createBufferStrategy(3);
        } else {
            g = bs.getDrawGraphics();
            g.drawImage(Assets.background, 0, 0, width, height, null);
            player.render(g);
            for (int i = 0; i < bullets.size(); i++) {
                Bullet bullet = bullets.get(i);
                bullet.render(g);
            }
            bs.show();
            g.dispose();
        }
    }

    public synchronized void start() {
        if (!running) {
            running = true;
            thread = new Thread(this);
            thread.start();
        }
    }

    public synchronized void stop() {
        if (running) {
            running = false;
            try {
                thread.join();
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }
}
