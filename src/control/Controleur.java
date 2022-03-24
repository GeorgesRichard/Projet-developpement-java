package control;

import javax.swing.*;

import view.GrilleVue;
import java.awt.event.*;

/*************************Implémentation du contoleur ****************************/
//implements /*ActionListener,*/ MouseListener extends MouseAdapter
public class Controleur {
	
	/**Gestion des action de la souris */
	
	//propriétés 
	
	GrilleVue vue;
	
	public Controleur(){
		
		vue = new GrilleVue();
		vue.setVisible(true); 
		
		}
		
	public static void main(String[] args) {
		
		new Controle();
		
		}
	
	public void mousePressed(MouseEvent e){
		
		
		System.out.println("Vous avez cliquez sur la souris");
		
		}
	//public static Vue vue = New Vue;
	
	/**Recupérer l'action effectuer pour renvoyer le changement **/
	
	
	/**********Controleur graphique (differentes touches sous formes de jbutton ) et contoleur clavier(un keyEventListenner)**********/
	
	Button b = new Button("boutton");
	
	b.addActionListener(this);
	
	public String state= "gauche" ;
	
	/**Gestion action des touches**/
	void public actionPerformed(actionEvent evt) {
	Object source = evt.getSource();

	if (source == b) // action a effectuer
		}
	public Controleur(){
		
		
		
		}
	
	if (state == 'gauche'){
		
		System.out.println("gauche");
		
		}
		
	if (state  == 'droite'){
		
		System.out.println("droite");
		
		
		}
	if (state  == 'bas'){
		
		System.out.println("bas");
		
		
		}
	else {
		
		System.out.println("haut");
		
		
		}
	public bougerGauche(){
		
		
		}
	
	
	}
