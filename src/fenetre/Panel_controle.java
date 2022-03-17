package fenetre ; 
import javax.swing.JButton;
import javax.swing.JPanel ;
import javax.swing.border.Border;

import java.awt.Color ; 
import java.awt.* ; 

public class Panel_controle extends JPanel {

    public Panel_controle() {
        super() ; 
        this.setPreferredSize(new Dimension(300 , 600)) ; 
        this.setLayout(new BorderLayout());
        
        
        JPanel control = new JPanel() ; 
        control.setPreferredSize(new Dimension(200 ,200));
        control.setLayout(new GridLayout(3,1 , 10 , 10));
        this.add(control , BorderLayout.NORTH) ; 
        
        JButton b1 = new Button_play() ;
        JButton b2 = new Button_play() ;
        
        control.add(b1) ; 
        control.add(b2) ;
        
    }
    /*@Override 
    public void paintComponent( Graphics g){

    }*/

}