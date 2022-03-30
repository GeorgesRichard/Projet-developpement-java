package modele;

import java.util.*;

import java.io.Serializable;

public class Grille extends AbstractModeleEcoutable implements Serializable

{

  public int nbCol, nbRow ;
  public int[][] puzzle ;

  //constructeur
  public Grille(int nbRow, int nbCol, int[][] puzzle){
    super();
    this.nbCol = nbCol;
    this.nbRow = nbRow;
    this.puzzle = puzzle;
  }

  public Grille(int nbRow, int nbCol){
    super();
    this.nbCol = nbCol;
    this.nbRow = nbRow;
    this.puzzle = creation();
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
  public int[][] creation(){
    int x = 1;
    int[][] puzzle = new int [this.nbRow][this.nbCol];
    for(int i = 0; i < this.nbRow; i++){
      for(int j = 0; j < this.nbCol; j++){
        puzzle[i][j] = x;
        x++;
      }
    }
    puzzle[this.nbRow-1][this.nbCol-1] = 0;
    return puzzle;
  }

  public boolean isEmpty(int x, int y){
    if(this.puzzle[x][y]==0)
      return true;
    return false;
  }

  public boolean isOver(){
    int[][] result = creation();
    for(int i=0; i<this.nbRow; i++){
      for(int j=0; j<this.nbCol; j++){
        if(result[i][j] != this.puzzle[i][j])
          return false;
      }
    }
    return true;
  }

  public ArrayList<Direction> possibleMoves(int[][] puzzle){
    //System.out.println("Les mouvements possibles : ");

    ArrayList<Direction> l = new ArrayList<Direction>();

    for(int i = 0; i < this.nbRow; i++){
      for(int j = 0; j < this.nbCol; j++){
        if(puzzle[i][j] == 0){
          if(i > 0){
            l.add(Direction.UP);
            System.out.print("UP ");
          }
          if(j > 0){
            l.add(Direction.LEFT);
            System.out.print("LEFT ");
          }
          if(i < this.nbRow -1){
            l.add(Direction.DOWN);
            System.out.print("DOWN ");
          }
          if(j < this.nbCol - 1){
            l.add(Direction.RIGHT);
            System.out.print("RIGHT ");
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

  public Direction move(Direction direction){
    for(int i = 0; i < this.nbRow; i++){
      for(int j = 0; j < this.nbCol; j++){
        if(this.puzzle[i][j] == 0){
          if(direction==Direction.UP && i > 0){
            swap(i, j, i-1, j);
            System.out.println("(" + i + "," + j + ") --> " + "(" + (i-1) + "," + j + ")" );
            fireChangement();
            return Direction.UP;
          }
          else if(direction==Direction.DOWN && i < this.nbRow-1){
            swap(i, j, i+1, j);
            System.out.println("(" + i + "," + j + ") --> " + "(" + (i+1) + "," + j + ")" );
            fireChangement();
            return Direction.DOWN;
          }
          else if(direction==Direction.LEFT && j > 0){
            swap(i, j, i, j-1);
            System.out.println("(" + i + "," + j + ") --> " + "(" + i + "," + (j-1) +")" );
            fireChangement();
            return Direction.LEFT;
          }
          else if(direction==Direction.RIGHT && j < this.nbRow-1){
            swap(i, j, i, j+1);
            System.out.println("(" + i + "," + j + ") --> " + "(" + i + "," + (j+1) + ")" );
            fireChangement();
            return Direction.RIGHT;
          }
        }
      }
    }
    return Direction.NONE;
  }

  public ArrayList<Direction> playAlea(int alea){

    System.out.println("On mélange le puzzle en " + alea + " permutations.");

    ArrayList<Direction> historique = new ArrayList<Direction>();
    Random random = new Random();
    int nb;

    while(alea>0){
      System.out.println("");
      ArrayList<Direction> a = possibleMoves(this.puzzle);
      nb = random.nextInt(a.size());
      historique.add(a.get(nb));
      move(a.get(nb));
      //grille.show();
      System.out.println("Le mouvement réalisé : " + a.get(nb));
      alea--;
    }

    return historique;
  }

  public void play(String choice){
    ArrayList<Direction> a = possibleMoves(this.puzzle);
    Direction d = Direction.NONE;
    if(choice.equals("Up"))
      d = Direction.UP;
    else if(choice.equals("Down"))
      d = Direction.DOWN;
    else if(choice.equals("Right"))
      d = Direction.RIGHT;
    else if(choice.equals("Left"))
      d = Direction.LEFT;
    int c = 0;
    for(int i=0; i<a.size(); i++){
      if(a.get(i)==d){
        move(d);
        show();
      }
      else
        c++;
    }
    if(c==a.size())
      System.out.println("Mouvement impossible. Essayez un autre !!");

  }

  public void show(){
    String result = "";
    for(int i = 0; i < this.nbRow; i++){
      for(int j = 0; j < this.nbCol; j++){
        if(this.puzzle[i][j] == 0)
          System.out.print("  ");
        else
          System.out.print(this.puzzle[i][j] + " ");
      }
      System.out.println("");
    }
  }


}
