/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorial1;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author HOME
 */
public class KeyManager implements KeyListener{
    
    public boolean up;
    public boolean down;
    public boolean left;
    public boolean right;
    public boolean space;
    public boolean load;
    public boolean save;
    public boolean pause;
    
    private boolean keys[];
    
    public KeyManager(){
        keys = new boolean[256];
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //if the key press is different of space
        if (e.getKeyCode() != KeyEvent.VK_SPACE && e.getKeyCode() != KeyEvent.VK_P){
            // set true to every key pressed
            keys[e.getKeyCode()] = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //If space is realised
        if (e.getKeyCode() == KeyEvent.VK_SPACE){
            //set true space key
            keys[e.getKeyCode()] = true;
        }
        //If p is realised
        else if(e.getKeyCode() == KeyEvent.VK_P){
            //set true p key
            keys[e.getKeyCode()] = true;
        }
        // set false to every key released
        else{
            keys[e.getKeyCode()] = false;
        }
    }
    /**
     * this function set false to the space and p key
     */
    public void kStop(){
        //Function that set in false the p and r key
        keys [KeyEvent.VK_SPACE] = false;
        keys [KeyEvent.VK_P] = false;
    }
    /**
     *  to enable or disable moves on every tick
     */
    public void tick(){
        up = keys[KeyEvent.VK_UP];
        down = keys[KeyEvent.VK_DOWN];
        left = keys[KeyEvent.VK_LEFT];
        right = keys[KeyEvent.VK_RIGHT];
        space = keys[KeyEvent.VK_SPACE];
        load = keys[KeyEvent.VK_L];
        save = keys[KeyEvent.VK_S];
        pause = keys[KeyEvent.VK_P];
    }
}
