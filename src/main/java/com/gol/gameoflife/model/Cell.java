/*
    Klasa pojedynczej komórki gry
 */

package com.gol.gameoflife.model;

public class Cell {

    private boolean state;

    public Cell(){
        this.state = false;
    }

    public boolean isAlive(){
        return state;
    }

    // Zmiana stanu na podany w argumencie

    public void changeState(boolean newState){
        this.state = newState;
    }

    // Zmiana stanu na przeciwny

    public void changeState(){
        if(this.state) this.state = false;
        else this.state = true;
    }
}
