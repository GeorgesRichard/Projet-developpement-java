package view;

import java.awt.*;
import java.event.KeyEvent;
import java.event.KeyAdapter;


public class GrilleVue extends JPanel implements EcouteurModele {

  private static final long serialVersionUID = 1L;

  protected int dim = 200;
  protected Grille grille;

  public GrilleVue(Grille grille){

    super();
    this.grille = grille;
    setPreferredSize(new Dimension(dim * grille.getNbRow(), dim * grille.getNbCol()));
    setBackground(Color.Gray);
    grille.ajoutEcouteur(this);

    this.addKeyListener (new KeyAdapter(){
      public void keyPressed(KeyEvent e) {

        int keyCode = e.getKeyCode();

        if (!grille.isOver()){
          if (keyCode == KeyEvent.VK_UP){
            grille.play(new Move(Direction.Up));
          } else if (keyCode == KeyEvent.VK_DOWN){
            grille.play(new Move(Direction.Down));
          } else if (KeyCode == KeyEvent.VK_RIGHT){
            grille.play(new Move(Direction.Right));
          } else if (KeyCode == KeyEvent.VK_LEFT){
            grille.play(new Move(Direction.Left));
          }
        }
        repaint();
      }
    });
  }

  @Override
  public void modeleMisAJour(Object source) {
    this.repaint();
  }


}
