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
  public void swap(int x1, int y1, int x2, int y2){
    int tmp = this.puzzle[x1][y1];
    this.puzzle[x1][y1] = this.puzzle[x2][y2];;
    this.puzzle[x2][y2] = tmp;
  }
  /** 
   * fonction qui determine si la case (posX , posY) peut bouger dans la direction "direction"
   * @param posX represente le numero de ligne de la case 
   * @param posY represente le numero de colonne de la case 
   * @param direction represente la direction dans la quelle on souhaite bouger notre la case 
   * @return un boolean qui dit si on peut bouger ou pas 
  */
      
  public boolean canMove (int posX , int posY , Direction direction){
        if ( direction == Direction.LEFT){
            if (posY - 1 < 0 ){
              return false ; 
            }
        }
        else if ( direction == Direction.RIGHT){
            if ( posY + 1 >= this.nbCol){
              return false ; 
            }
        }
        else if ( direction == Direction.UP){
            if ( posX - 1 < 0 ){
              return false ; 
            }
        }
        else {
            if ( posX + 1 >= this.nbRow){
              return false ; 
            }
        }
        return true ; 
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

  public void playAlea(int alea){

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
  /**
   * Methode de gestion des deplacements dans une interfaces graphiques. 
   * Elle permet de bouger la case (posX , posY) dans la direction 'direction'.
   * Elle ne retourne pas d'objet , elle se contente de modifier la grille 
   * @param posX represente le numero de ligne de la case 
   * @param posY represente le numero de colonne de la case 
   * @param direction represente la direction dans la quelle on souhaite bouger notre la case
   */
  public void play (int posX , int posY , Direction direction){
    if (canMove(posX, posY, direction)){
        if (direction == Direction.LEFT){
            swap(posX, posY, posX, posY - 1);
        }
        else if ( direction == Direction.RIGHT ){
            swap(posX, posY, posX, posY + 1);
        }
        else if ( direction == Direction.UP){
            swap(posX, posY, posX -1 , posY );
        }
        else {
            swap(posX, posY, posX + 1 , posY );
        }
    }
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
