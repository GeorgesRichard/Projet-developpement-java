package view;

import modele.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Jframe extends JFrame implements ActionListener {


	private static final long serialVersionUID = 1L;
	private Grille puzzle;
	private Dimension dim = new Dimension(600,600);
	private PuzzleView puzzlevue;

	/**
	 * constructeur de la classe, contenant le puzzle
	 * @param puzzle instantiation du  modele
	 */
	public Jframe(Grille puzzle) {

		super("Taquin Puzzle");

		this.puzzle = puzzle;

		puzzlevue = new PuzzleView(this.puzzle);

        

		ImageIcon img = new ImageIcon("src/resources/puzzle.jpg"); 
		this.setIconImage(img.getImage());

		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		puzzlevue.setSize(dim);

		super.setSize(this.dim);
		super.setMinimumSize(this.dim);
		super.setResizable(true);


		pack();
		setVisible(true);

	}

	/**
	 * getter de la vu
	 * @return Jpanel
	 */
	public PuzzleView getPuzzleView() {
		return puzzlevue;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
	
	
	
}