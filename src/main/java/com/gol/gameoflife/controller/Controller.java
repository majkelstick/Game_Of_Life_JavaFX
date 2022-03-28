/*
    Klasa kontrolera symulacji. Służy do wprowadzania wszelkich zmian w stanie symulacji.
 */

package com.gol.gameoflife.controller;

import com.gol.gameoflife.model.FileHandler;
import com.gol.gameoflife.model.Simulation;

public class Controller {
    private Simulation sim;
    private FileHandler fileHandler;

    public Controller(int width, int height){
        sim = new Simulation(width, height);
        fileHandler = new FileHandler();
    }

    public Controller(){
        sim = new Simulation();
        fileHandler = new FileHandler();
    }

    public void resizeSimulation(int width, int height){
        sim = new Simulation(width,height);
    }

    public Simulation getSimulation(){
        return sim;
    }

    public void resetSimulation(){
        sim = new Simulation(sim.getBoard().getWidth(), sim.getBoard().getWidth());
    }


    public void nextStep(){
        sim.nextStep();
    }

    public void saveConfig(String name){
        fileHandler.saveFile(name, sim.getBoard());
    }


    // Korzystając z FileHandlera aktualizuje stan symulacji do stanu odczytanego z pliku
    public void readConfig(String name){

        Boolean[] cellStates = fileHandler.readFile(name, sim.getBoard());
        int size = (int)Math.sqrt(cellStates.length);
        this.resizeSimulation(size, size );
        for(int i = 0; i < size * size ; i++){
            if(cellStates[i]) sim.getBoard().setCellState(i / size , i % size , true);
            else sim.getBoard().setCellState(i / size , i % size , false);
          }

    }

    public FileHandler getFileHandler(){
        return fileHandler;
    }


}
