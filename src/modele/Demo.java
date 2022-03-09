package modele;

import java.util.ArrayList;

public class Demo {

  public static void main(String [] args){

    System.out.println("**************************\nJEU DE PUZZLE\n**************************\n\n");

    Grille grille = new Grille(3,3);
    grille.creation();
    grille.show();

    ArrayList<Grille> possibles = grille.possibleMoves(grille.getPuzzle());

    System.out.println("\nDEMO :");

    int x=1;

    /*for(Grille m : possibles){
      System.out.println("Possibilité " + x);
      m.show();
      x++;
    }*/

    for(int i=0; i<2; i++){
      System.out.println("Possibilité " + x);
      possibles.get(i).show();
      x++;
    }

    System.out.println("\n*****************************\nEND\n******************************\n");

  }

}
