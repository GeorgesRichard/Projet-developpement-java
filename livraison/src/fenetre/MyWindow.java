package fenetre;
import modele.*; 
import javax.swing.* ;

import java.awt.*  ;
import java.awt.event.WindowAdapter ;
import java.awt.event.WindowEvent ;
import java.awt.event.KeyAdapter ;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener ; 
/**
     * MyWindow est la class container principal qui va regrouper toutes les composantes 
     * graghique du jeu taquin. Elle herite de {@link JFrame} 
	 * @author Georges khaly 
     * 
	 * 
*/
public class MyWindow  extends JFrame  {
	
    /**
     * Elle initialise les differentes composante de la fenetre.
     * Les elements  initialisés sont : {@link Panel_jeu} qui represente une vue du modele et
     * {@link Panel_controle}  qui permet de realiser different modification du modele
     * @param ligne permet de saisir le nombre de ligne du taquin 
     * @param colonne permet de saisir le nombre de colonne du taquin 
     */
    public MyWindow (int ligne , int colonne) { 
        super("Genie logicielle"); 
        this.setSize(1000 , 1000); 
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE) ; 
        this.setLocationRelativeTo(null) ; 

        JPanel content= (JPanel) this.getContentPane();  
        Grille game = new Grille ( ligne , colonne) ; 
        game.creation();
        game.playAlea(20); 
        
        Panel_jeu Game_vue =  new Panel_jeu(game)  ;
        game.ajoutEcouteur(Game_vue);

        JToolBar Image_controle = new Panel_controle(Game_vue , MyWindow.this , game) ;
        
        this.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing( WindowEvent e ){
                    exit_dialogue();
                }
            }
        );
        
        content.setLayout(new BorderLayout()); 
        content.add(Image_controle  , BorderLayout.NORTH) ; 
        content.add(Game_vue , BorderLayout.CENTER) ; 
    }
    /**
     * Dialogue de fermetture 
     */
    public void exit_dialogue (){
        String message = "Etes vous sur de vouloir quitter la partie ? " ; 
        int exit = JOptionPane.showConfirmDialog(this,message ,"EXIT MESSAGE", JOptionPane.YES_NO_OPTION) ; 
        if (exit == JOptionPane.YES_OPTION){
            this.dispose();
        }
    }
    /**
     * Lancement du jeu
     * @param args
     */
    public static void main ( String args[]){
        MyWindow window = new MyWindow(3 , 3) ; 
        window.setVisible(true);


    }
    

}
