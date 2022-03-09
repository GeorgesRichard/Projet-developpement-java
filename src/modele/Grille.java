package modele;

import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;

public class Grille extends AbstractModeleEcoutable //implements Serializable
{

  protected int nbCol, nbRow ;
  protected int[][] puzzle ;

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

  public ArrayList<Grille> possibleMoves(int[][] puzzle){
    System.out.println("On peut deplacer les cases : ");

    ArrayList<Grille> l = new ArrayList<Grille>();

    int[][] puzzle1 = puzzle.clone();
    int[][] puzzle2 = puzzle.clone();
    int[][] puzzle3 = puzzle.clone();
    int[][] puzzle4 = puzzle.clone();

    for(int i = 0; i < this.nbRow; i++){
      for(int j = 0; j < this.nbCol; j++){
        if(puzzle[i][j] == 0){
          if(i > 0){
            //int[][] puzzle1 = puzzle;
            //System.out.print(puzzle1[i-1][j] + " ");
            System.out.println("Ancien :");
            new Grille(this.nbRow, this.nbCol, puzzle).show();
            puzzle1[i][j] = puzzle1[i-1][j];
            puzzle1[i-1][j] = 0;
            Grille m1 = new Grille(this.nbRow, this.nbCol, puzzle1);
            l.add(m1);
            System.out.println("New :");
            m1.show();
          }
          if(j > 0){
            //int[][] puzzle2 = puzzle;
            //System.out.print(puzzle2[i][j-1] + " ");
            System.out.println("Ancien :");
            new Grille(this.nbRow, this.nbCol, puzzle).show();
            puzzle2[i][j] = puzzle2[i][j-1];
            puzzle2[i][j-1] = 0;
            Grille m2 = new Grille(this.nbRow, this.nbCol, puzzle2);
            l.add(m2);
            System.out.println("New : ");
            m2.show();
          }
          if(i < this.nbRow -1){
            //int[][] puzzle3 = puzzle;
            //System.out.print(puzzle3[i+1][j] + " ");
            System.out.println("Ancien :");
            new Grille(this.nbRow, this.nbCol, puzzle).show();
            puzzle3[i][j] = puzzle3[i+1][j];
            puzzle3[i+1][j] = 0;
            Grille m3 = new Grille(this.nbRow, this.nbCol, puzzle3);
            l.add(m3);
            System.out.println("New : ");
            m3.show();
          }
          if(j < this.nbCol-1){
            //int[][] puzzle4 = puzzle;
            //System.out.print(puzzle4[i][j+1] + " ");
            System.out.println("Ancien :");
            new Grille(this.nbRow, this.nbCol, puzzle).show();
            puzzle4[i][j] = puzzle4[i][j+1];
            puzzle4[i][j+1] = 0;
            Grille m4 = new Grille(this.nbRow, this.nbCol, puzzle4);
            l.add(m4);
            System.out.println("New :");
            m4.show();
          }
        }
      }
    }
    System.out.println(" ");
    return l;
  }



  public void show(){
    String result = "";
    for(int i = 0; i < this.nbRow; i++){
      for(int j = 0; j < this.nbCol; j++){
        if(this.puzzle[i][j] == 0)
          System.out.print("  ");
        else
          System.out.print(this.puzzle[i][j]+ " ");
      }
      System.out.println("");
    }
  }

}
