package modele;

import java.util.*;

public class Demo {

  public static void main(String [] args){

    System.out.println("**************************\nJEU DE PUZZLE\n**************************\n\n");
    System.out.println();
    Grille grille = new Grille(3,3);
    grille.creation();
    grille.show();

    int alea = 10;
    System.out.println("On mélange le puzzle en " + alea + " permutations");

    ArrayList<Direction> historique = new ArrayList<Direction>();
    Random random = new Random();
    int nb;

    while(alea>0){
      System.out.println("");
      ArrayList<Direction> a = grille.possibleMoves(grille.getPuzzle());
      nb = random.nextInt(a.size());
      historique.add(a.get(nb));
      grille.play(a.get(nb));
      grille.show();
      System.out.println("Le mouvement réalisé : " + a.get(nb));
      alea--;
    }


  }

}
