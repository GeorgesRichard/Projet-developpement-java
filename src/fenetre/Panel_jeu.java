package fenetre ; 
import modele.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel ; 
import java.awt.Color ; 
import java.awt.* ; 
import java.awt.event.KeyAdapter ;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
/**
 * La class Panel_jeu represente la vue du modele , et grace  à ses controleurs , elle permettra
 * d'effectuer des modifications sur le controleur. 
 * La class utilisera une {@link GridLayout} pour effectuer les affichages. 
 */

public class Panel_jeu extends JPanel implements EcouteurModele {
    public Boutton_grille boutton_cliqued ; // contiendra le boutton sur lequel on cliquera
    public boolean cliqued ; // true si on a cliqued sur un boutton false sinon 
    public Grille grille ; 
    /**
     * @param grille une reference vers la grille qu'on souhaite voir 
     */ 
    public Panel_jeu( Grille grille ){
        super() ; 
        this.grille = grille ;
        this.boutton_cliqued = null ; // lors de la creation , il est initialiser a null , en attendant de capter un clique
        this.cliqued = false ; 
        this.setPreferredSize(new Dimension(500 , 500)) ; 
        this.setBackground(Color.gray) ;
        // Politique de positionnement 
        this.setLayout(new GridLayout(grille.nbRow, grille.nbCol , 15 , 15));
        paint(); // Affichage des elements de la grille  
    }
    /**
     * Methode provenant de l'interface EcouteurModele
     * @see EcouteurModele
     */
    public void modeleMisAJour(){
        Panel_jeu.this.setVisible(false);
        Panel_jeu.this.removeAll();
        paint();
        Panel_jeu.this.setVisible(true);
    }
    /**
     * Methode de remplissage de la fenetre par des composantes graphiques 
     * La politique de positionnement etant une GridLayout, le composant ajouter seront 
     * des objet de type {@link Boutton_grille} qui representera une case de la grille. 
     * @see Boutton_grille   
     */
    public void paint(){
        for (int i = 0; i < grille.getNbRow(); i++) {
            for (int j = 0; j < grille.getNbCol(); j++) {
                Boutton_grille b = new Boutton_grille(grille.puzzle[i][j], i, j, Panel_jeu.this) ; 
                Panel_jeu.this.add(b) ; 
            }
            
        }
    }
    /**
     * Message de fermeture de jeu
     */
    public void end_dialogue(){
        if ( this.grille.isOver()){
            JOptionPane.showMessageDialog(Panel_jeu.this, "Felicitation , vous avez terminé le jeu ",
                 "FINI", JOptionPane.INFORMATION_MESSAGE);
            this.grille.creation() ; 
            this.grille.playAlea(100) ; 
        }

    }

}
