package fenetre ; 
import javax.swing.JPanel ; 
import java.awt.Color ; 
import java.awt.* ; 

public class Panel_jeu extends JPanel {

    public Panel_jeu() {
        super() ; 
        this.setPreferredSize(new Dimension(500 , 500)) ; 
        this.setBackground(Color.green) ; 
    }
    /*@Override 
    public void paintComponent( Graphics g){

    }*/

}