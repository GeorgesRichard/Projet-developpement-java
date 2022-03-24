package control;
import java.awt.*;

import javax.swing.*;

//import view.GrilleVue;
import java.awt.event.*;

public class Controller implements MouseListener,KeyListener{
	
	//Constructeur
	public Controller(){
		
		//instancier une vue;
		
		}
		
	public void mouseEntered(MouseEvent e) {
		//setBackground(Color.GREEN);
	}
	
	/**MouseLISTENNER */
	@Override
	public void mousePressed(MouseEvent e){
		
		
		System.out.println("Vous avez cliquez sur la souris");
		
		}
	
	 @Override
	 public void mouseExited(MouseEvent e) {
 
		}
 
	 @Override
	 public void mouseReleased(MouseEvent e) {}
 
	 @Override
	 public void mouseClicked(MouseEvent e) {}
 
 
	
		
	/**KEYLISTENNER **/
	
	@Override
	public void keyTyped(KeyEvent e)
	{
		System.out.println("The key Typed was: " + e.getKeyChar());
	}
	@Override
	public void keyPressed(KeyEvent e)
	{
	}
	@Override
	public void keyReleased(KeyEvent e)
	{
	}
	/***********Creation d'une jframe pour tester les actions gérées par le controleur***********************/
	
	
	public static void main(String[] args){

    JFrame fenetre = new JFrame();
    
    fenetre.setTitle("Essai Controleur");
    
    fenetre.setSize(1000, 1000);

    fenetre.setLocationRelativeTo(null);
    
    fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    fenetre.setVisible(true);
    
    JPanel panel1 = new JPanel();
    
    JPanel panel2 = new JPanel();
    
    panel1.setSize(20,20);
    panel1.setBackground(Color.blue);
    //panel1.setVisible();
    
    panel2.setSize(20,20);
    panel2.setBackground(Color.blue);
    //panel2.setVisible();
    
    fenetre.add(panel2);
    
    Controller k = new Controller();
	fenetre.addMouseListener(k);
	fenetre.addKeyListener(k);
  }       

	
	
	
	
	}
