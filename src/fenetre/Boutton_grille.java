package fenetre;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Boutton_grille extends JButton {
    private int posX ; 
    private int posY ; 
    public Boutton_grille (int numero , int posX , int posY , Panel_jeu panel ){
        super("boutton " + numero);
        this.posX = posX ; 
        this.posY = posY ; 
        this.addActionListener((event) -> clique(panel));

    } 

    public void clique ( Panel_jeu panel){
        if ( !( panel.cliqued)){
            panel.cliqued = true ; 
            panel.boutton_cliqued= Boutton_grille.this ;  
            this.setBorder(new LineBorder (Color.BLACK , 15));
        }
        else {
            panel.boutton_cliqued.setBorderPainted(false);
            panel.boutton_cliqued= Boutton_grille.this ;  
            this.setBorder(new LineBorder (Color.BLACK , 15));
            panel.boutton_cliqued.setBorderPainted(true);
        }
            
    }








    
}
