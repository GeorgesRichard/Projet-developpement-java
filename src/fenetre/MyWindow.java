package fenetre;
import modele.*; 
import javax.swing.* ;

import java.awt.*  ;
import java.awt.event.WindowAdapter ;
import java.awt.event.WindowEvent ;


public class MyWindow  extends JFrame  {

    public MyWindow () { // Constructeur de la class 
        super("Genie logicielle"); 
        this.setSize(1000 , 1000); 
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE) ; 
        this.setLocationRelativeTo(null) ; 

        JPanel content= (JPanel) this.getContentPane();  
        Grille game = new Grille ( 5 , 5 ) ; 
        game.creation();
        game.show();

        Panel_jeu Game_vue =  new Panel_jeu(game)  ;
        game.ajoutEcouteur(Game_vue);

        JToolBar Image_controle = new Panel_controle(Game_vue , MyWindow.this) ;
        
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
    
    private void exit_dialogue (){
        String message = "Etes vous sur de vouloir quitter la partie ? " ; 
        int exit = JOptionPane.showConfirmDialog(this,message ,"EXIT MESSAGE", JOptionPane.YES_NO_OPTION) ; 
        if (exit == JOptionPane.YES_OPTION){
            this.dispose();
        }

    }
    public static void main ( String args[]){
        MyWindow window = new MyWindow() ; 
        window.setVisible(true);




    }  












}