/*
 Klasa obsługująca odczyt i zapis stanu planszy do plików.
 */

package com.gol.gameoflife.model;
import java.io.*;

public class FileHandler {

    private String fileDirectory;

    public FileHandler(){
        fileDirectory = "files/";
    }

    // Zwraca tablicę nazw plików dostępnych w katalogu fileDirectory
    public String [] listFiles(){
        File dir = new File(fileDirectory);
        String fileList [] = dir.list();
        return fileList;
    }

    // Zapisuje stan planszy w postaci tablicy bajtów
    public void saveFile(String name, Board board){
        try {
            byte byteWrite [] = new byte[board.getWidth() * board.getWidth()];

            for(int i = 0; i < board.getWidth() * board.getWidth(); i++){
                if(board.getCell( i / board.getWidth() ,i % board.getWidth() ).isAlive()) byteWrite[i] = 1;
                else byteWrite[i] = 0;
            }

            OutputStream outFile = new FileOutputStream(fileDirectory + name);
            for(int x = 0; x < byteWrite.length ; x++) {
                outFile.write( byteWrite[x] );
            }
            outFile.close();

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    // Zwraca tablicę typu Boolean stanów komórek odczytanych z pliku o nazwie podanej w argumencie
    public Boolean[] readFile(String name, Board board){
        try {
            InputStream inFile = new FileInputStream(fileDirectory + name);
            int size = inFile.available();
            Boolean[] cellStates = new Boolean[size];
            for(int i = 0; i < size; i++){
                if((int)inFile.read() == 1) cellStates[i] = true;
                else cellStates[i] = false;
            }

            return cellStates;
        } catch (IOException e) {
              System.out.println("An error occurred.");
              e.printStackTrace();
        }
        return new Boolean[1];
    }



}
