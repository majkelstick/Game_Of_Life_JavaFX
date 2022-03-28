/*
    Klasa planszy gry. Składa się z pojedynczych komórek.
 */

package com.gol.gameoflife.model;

public class Board {
    public Cell[][] cells;
    private int width;
    private int height;

    public Board() {
        this.width = 10;
        this.height = 10;
        this.cells = new Cell[width][height];

        for (int w = 0; w < width; w++) {
            for (int h = 0; h < height; h++) {
                cells[w][h] = new Cell();
            }
        }
    }

    public Board(int width, int height){
        this.width = width;
        this.height = height;
        this.cells = new Cell[width][height];

        for(int w = 0; w < width; w ++){
            for(int h = 0; h < height; h++){
                cells[w][h] = new Cell();
            }
        }
    }

    public int getWidth(){
        return this.width;
    }

    public int getHeight(){
        return this.height;
    }

    public Cell getCell(int row, int col){
        return cells[row][col];
    }

    public void setCellState(int row, int col, boolean state){
        this.getCell(row,col).changeState(state);
    }


    // Umożliwia wypisanie stanu planszy w konsoli
    public void printBoard(){
        for(int w = 0; w < width; w ++){
            for(int h = 0; h < height; h++){
                if(getCell(w,h).isAlive()) System.out.print("1 ");
                else System.out.print("0 ");
            }
            System.out.println();
        }
        System.out.println();
    }


}
