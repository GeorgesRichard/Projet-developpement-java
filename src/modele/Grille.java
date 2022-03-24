package modele;

import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;


public class Grille extends AbstractModeleEcoutable implements Serializable

{

  public int nbCol, nbRow ;
  public int[][] puzzle ;

  //constructeur
  public Grille(int nbCol, int nbRow, int[][] puzzle){
    super();
    this.nbCol = nbCol;
    this.nbRow = nbRow;
    this.puzzle = puzzle;
  }

  public Grille(int nbCol, int nbRow){
    super();
    this.nbCol = nbCol;
    this.nbRow = nbRow;
    this.puzzle = new int[nbRow][nbCol];
  }

  //getters & setters
  public int[][] getPuzzle(){
    return this.puzzle;
  }
  public int getNbCol(){
    return this.nbCol;
  }
  public int getNbRow(){
    return this.nbRow;
  }

  //methodes ...
  public void creation(){
    int x = 1;
    for(int i = 0; i < this.nbRow; i++){
      for(int j = 0; j < this.nbCol; j++){
        this.puzzle[i][j] = x;
        x++;
      }
    }
    this.puzzle[this.nbRow-1][this.nbCol-1] = 0;
  }

  public boolean isOver(){
    int[][] result = new int [this.nbRow][this.nbCol];
    int x = 1;
    for(int i=0; i<this.nbRow; i++){
      for(int j=0; j<this.nbCol; j++){
        result[i][j] = x;
        x++;
      }
    }
    return result==this.puzzle;
  }

  public ArrayList<Direction> possibleMoves(int[][] puzzle){
    //System.out.println("Les mouvements possibles : ");

    ArrayList<Direction> l = new ArrayList<Direction>();

    for(int i = 0; i < this.nbRow; i++){
      for(int j = 0; j < this.nbCol; j++){
        if(puzzle[i][j] == 0){
          if(i > 0){
            l.add(Direction.UP);
            //System.out.print("UP ");
          }
          if(j > 0){
            l.add(Direction.LEFT);
          //  System.out.print("LEFT ");
          }
          if(i < this.nbRow -1){
            l.add(Direction.DOWN);
          //  System.out.print("DOWN ");
          }
          if(j < this.nbCol - 1){
            l.add(Direction.RIGHT);
          //  System.out.print("RIGHT ");
          }
        }
      }
    }
    //System.out.println("");
    return l;
  }


  public void swap(int x1, int y1, int x2, int y2){
    int tmp = this.puzzle[x1][y1];
    this.puzzle[x1][y1] = this.puzzle[x2][y2];;
    this.puzzle[x2][y2] = tmp;
  }

  public Direction play(Direction direction){
    for(int i = 0; i < this.nbRow; i++){
      for(int j = 0; j < this.nbCol; j++){
        if(this.puzzle[i][j] == 0){
          if(direction==Direction.UP && i > 0){
            swap(i, j, i-1, j);
            System.out.println("(" + i + "," + j + ") --> " + "(" + (i-1) + "," + j + ")" );fireChangement();
            return Direction.UP;
          }
          else if(direction==Direction.DOWN && i < this.nbRow-1){
            swap(i, j, i+1, j);
            System.out.println("(" + i + "," + j + ") --> " + "(" + (i+1) + "," + j + ")" );fireChangement();
            return Direction.DOWN;
          }
          else if(direction==Direction.LEFT && j > 0){
            swap(i, j, i, j-1);
            System.out.println("(" + i + "," + j + ") --> " + "(" + i + "," + (j-1) +")" );fireChangement();
            return Direction.LEFT;
          }
          else if(direction==Direction.RIGHT && j < this.nbRow-1){
            swap(i, j, i, j+1);
            System.out.println("(" + i + "," + j + ") --> " + "(" + i + "," + (j+1) + ")" );fireChangement();
            return Direction.RIGHT;
          }
        }
      }
    }
    return NONE;
  }

  public void show(){
    String result = "";
    for(int i = 0; i < this.nbRow; i++){
      for(int j = 0; j < this.nbCol; j++){
        if(this.puzzle[i][j] == 0)
          System.out.print(" trou ");
        else
          System.out.print("(" + i + "," + j + ")" +this.puzzle[i][j]+ " ");
      }
      System.out.println("");
    }
  }

}
