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
public class Digraph {
    private char leftkey;
    private char rightkey;
    private long delay;
    public Digraph(char leftkey,char rightkey){
        this.leftkey=leftkey;
        this.rightkey=rightkey;
    }
    public Digraph(char leftkey,char rightkey,long delay){
        this.leftkey=leftkey;
        this.rightkey=rightkey;
        this.delay=delay;
    }
    public void setLeftKey(char leftkey){
        this.leftkey=leftkey;
    }
    public void setRightKey(char rightkey){
        this.rightkey=rightkey;
    }
    public void setDelay(long delay){
        this.delay=delay;
    }
    public char getLeftKey(){
        return leftkey;
    }
    public char getRightKey(){
        return rightkey;
    }
    public long getDelay(){
        return delay;
    }
}
