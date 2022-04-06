package modele;

import java.util.*;

/**
 * Classe exécutable qui permet de jouer dans le terminal
 */
public class Demo {

  public static void main(String [] args){

    System.out.println("**************************\nJEU DE PUZZLE\n**************************\n\n");
    System.out.println();
    Grille grille = new Grille(3,3);

    grille.playAlea(10);

    grille.show();

    Scanner sc = new Scanner(System.in);
    ArrayList<Direction> states = new ArrayList<Direction>();

    do{

      System.out.println("Up, Down, Right, Left\nWhat do you choose?\n");
      String choice = sc.nextLine();

      grille.play(choice);

      System.out.println(!grille.isOver());

    }while(!grille.isOver());

    System.out.println("Congratulations !! You Win...");
  }

}
