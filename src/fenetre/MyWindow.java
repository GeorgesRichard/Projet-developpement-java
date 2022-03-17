package fenetre; 
import javax.swing.* ;
import javax.swing.border.Border;

import java.awt.* ; 

public class MyWindow  extends JFrame  {

    public MyWindow () { // Constructeur de la class 
        super("Genie logicielle"); 
        this.setSize(1000 , 1000); 
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE) ; 
        this.setVisible(true);
        this.setLocationRelativeTo(null) ; 
        JPanel content= (JPanel) this.getContentPane();  
        JPanel Image_controle = new Panel_controle() ;
        JPanel Game_vue =  new Panel_jeu()  ;
        content.setLayout(new BorderLayout()); 
        content.add(Image_controle  , BorderLayout.WEST) ; 
        content.add(Game_vue , BorderLayout.CENTER) ; 


        
    }  
    public static void main ( String args[]){
        MyWindow window = new MyWindow() ;


    }  












}