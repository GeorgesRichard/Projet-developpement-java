package fenetre;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import modele.Direction;

/**
 * Class de gestion des differents controleur de la vue et de gestion des deplacements 
*/
public class Boutton_grille extends JButton {
    public int posX ; 
    public int posY ; 
    public Panel_jeu panel ;
    /**
     * 
     * @param numero Le numero de la case correspondante 
     * @param posX le numero de ligne de la case 
     * @param posY le numero de colonne de la case 
     * @param panel une reference sur la vue , dans la mesure ou chaque case aura besoin de 
     * de savoir a tout moment si un boutton a été cliqué , si une case est selectionnée ... 
     * @see Panel_jeu
     */
    public Boutton_grille (int numero , int posX , int posY , Panel_jeu panel ){
        super("" + numero);
        this.posX = posX ; 
        this.posY = posY ; 
        this.panel = panel ;

        if ( numero == 0){
            this.setText("");
            this.setBackground(Color.GRAY);
        }  
    
    }      








    
}
