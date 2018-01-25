/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biometricsystem;

/**
 *
 * @author Anuradha
 */
public class Character {
    private char character;
    private long pressedtime;
    private long releasedtime;
    
    public Character(char character){
        this.character=character;
    }
    public void setCharacter(char character){
        this.character=character;
    }
    public char getCharacter(){
        return character;
    }
    public void setPressedTime(long pressedtime){
        this.pressedtime=pressedtime;
    }
    public void setReleasedTime(long releasedtime){
        this.releasedtime=releasedtime;
    }
    public long getPressedTime(){
        return pressedtime;
    }
    public long getReleasedTime(){
        return releasedtime;
    }
    
}
