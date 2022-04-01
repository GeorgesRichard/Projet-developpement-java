package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import modele.*;


public class PuzzleView extends JPanel implements EcouteurModele, KeyListener, MouseListener {

  private static final long serialVersionUID = 1L;
  //int xstart = 6, ystart = 6;
  //int gwidth = 55, gheight = 40;
  int[][] grid = this.puzzle.getPuzzle();
  int nbRow = this.puzzle.getNbRow();
  int nbCol = this.puzzle.getNbCol();
  protected int dim = 150;
  protected Grille puzzle;
  JPanel firstPane;

  /**
	 * constructeur de la classe JPanel
	 * @param puzzle (objet de la classe (Grille)
	 */
  public PuzzleView(Grille puzzle){
    this.puzzle = puzzle;
    this.puzzle.ajoutEcouteur(this);
    this.addMouseListener(this);
    this.addKeyListener(this);
  }

  /**
  * La méthode capture les touches enfoncées sur le clavier. L'action se produit
  * lorsqu'une des quatre flèches est appuyée ET que l'action est possible.
  * @param e KeyEvent type event
  */
  @Override
  public void keyPressed(KeyEvent e) {
    int keyCode = e.getKeyCode();

    switch (keyCode){
      case KeyEvent.VK_UP :
        this.puzzle.move(Direction.UP);
        break;
      case KeyEvent.VK_DOWN :
        this.puzzle.move(Direction.DOWN);
        break;
      case KeyEvent.VK_RIGHT :
        this.puzzle.move(Direction.RIGHT);
        break;
      case KeyEvent.VK_LEFT :
        this.puzzle.move(Direction.LEFT);
        break;
    }
    repaint();
  }

  /**
  * La méthode capture les clics de souris. L'action se produit lorsque le clic 
  * de la souris se trouve sur l'une des pièces
  * @param e MouseEvent type event
  */
  @Override
  public void mouseClicked(MouseEvent e){

    /*int x = e.getX();
    x -= xstart;
    int y = e.getY();
    y -= ystart;
    if (x > 0 && x < gwidth * (nbCol) && y > 0 && y < gheight * (nbRow)) {
        int col = x / gwidth;
        int row = y / gheight;
        this.puzzle.swap(col, row, col + 1, row);
        this.puzzle.swap(col, row, col - 1, row);
        this.puzzle.swap(col, row, col, row + 1);
        this.puzzle.swap(col, row, col, row - 1);
        repaint();
    }*/
    e.getComponent().setVisible(false); // stops the button from being displayed on screen 
		e.getComponent().setFocusable(false); // defocuses from the button
    firstPane.setVisible(false); // disables from view the panel

  }

  /**
	 * redifinition de ModelMisAjour
	 */
  @Override
  public void modeleMisAJour(Object source) {
    this.repaint();
  }

  /**
	 * ce code permet de dessiner toute la grille du jeu
	 * @param  g objet  de la classe Graphics
	 */
  @Override
	public void paintComponent(Graphics g) {
    
    super.paintComponent(g);
		this.setBackground(Color.black);

    for (int i = 0; i < nbCol; i++) {
      for (int j = 0; j < nbRow; j++) {
        int x = i * dim;
        int y = j * dim;
				if (grid[i][j] != 0) {
        
        g.setColor(Color.gray);
				g.drawRect(x + 2, y + 2, dim -  4, dim - 4);
				g.fillRect(x + 2, y + 2, dim -  4, dim - 4);
				g.setColor(Color.black);
				g.drawString("" + grid[i][j], x + 20, y + (3*dim)/4);
				this.addMouseListener(this);
        this.addKeyListener(this);
        }
      }
    }
  }

  @Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

  @Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}
}
