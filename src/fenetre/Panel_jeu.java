package fenetre ; 
import modele.*;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel ; 
import java.awt.Color ; 
import java.awt.* ; 

public class Panel_jeu extends JPanel implements EcouteurModele {
    public Boutton_grille boutton_cliqued ; // contient le boutton sur lequel on cliquera
    public boolean cliqued ; // true si on a cliqued sur un boutton false sinon 
    public Grille grille ; 
    public Panel_jeu( Grille grille){
        super() ; 
        this.grille = grille ; 
        this.boutton_cliqued = null ; 
        this.cliqued = false ; 
        this.setPreferredSize(new Dimension(500 , 500)) ; 
        this.setBackground(Color.gray) ;
        this.setLayout(new GridLayout(grille.nbRow, grille.nbCol , 15 , 15)); 
        
        paint();

    }
    public void modeleMisAJour(){
        Panel_jeu.this.setVisible(false);
        Panel_jeu.this.removeAll();
        paint();
        Panel_jeu.this.setVisible(true);

    }
    public void paint(){

        for (int i = 0; i < grille.getNbRow(); i++) {
            for (int j = 0; j < grille.getNbCol(); j++) {
                Boutton_grille b = new Boutton_grille(grille.puzzle[i][j], i, j, Panel_jeu.this) ; 
                Panel_jeu.this.add(b) ; 
            }
            
        }
    }

    private void end_dialogue(){
        if ( this.grille.isOver()){
            JOptionPane.showMessageDialog(Panel_jeu.this, "Felicitation , vous avez terminé le jeu ",
                 "FINI", JOptionPane.INFORMATION_MESSAGE);
        }

    }

}