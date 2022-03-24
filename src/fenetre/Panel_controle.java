package fenetre ;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel ;
import javax.swing.border.Border;
import javax.swing.JToolBar ; 
import javax.swing.JFrame ; 

import org.w3c.dom.events.Event;

import java.awt.Color ;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.awt.* ; 

public class Panel_controle extends JToolBar  {
    private JPanel game ;
    private JFrame fenetre ; 
    public Panel_controle(JPanel Game , JFrame fenetre) {
        super() ; 
        this.setPreferredSize ( new Dimension(50 , 50)); 
        this.game = Game ;  
        this.fenetre = fenetre ; 

        JButton play = new Button_play("play.png") ; 
        play.addActionListener((event) -> charger_dialogue());

        JButton left = new Button_play("left.png") ;

        JButton right = new Button_play("right.png") ;


        JButton refresh = new Button_play("rafraichir.png") ;
        refresh.addActionListener((event) -> rafraichir());



        JButton save = new Button_play("save.png") ;
        save.addActionListener((event) -> save());

        

        JButton exit = new Button_play("exit.png") ; 
        exit.addActionListener((event) -> exit()) ; 

        this.add(play);

        this.addSeparator() ; 

        this.add(left); 

        this.addSeparator() ;

        this.add(right); 

        this.addSeparator() ;

        this.add(refresh); 
        this.addSeparator() ;

        this.add(save); 
        this.addSeparator() ;

        this.add(exit); 
        
    }
    private void exit () {
        exit_dialogue() ; 
    }
    private void rafraichir() {
        String message = "Etes vous sur de vouloir refraichir la partie la partie ? " ; 
        int exit = JOptionPane.showConfirmDialog(this.game,message ," Tout reprendre ", JOptionPane.YES_NO_OPTION) ; 
        if (exit == JOptionPane.YES_OPTION){
            // initialisation du jeu et rafraichissement de la page 
        }
    }
    private void charger_dialogue() {
        String message = "Voulez vous charger la derniere partie" ; 
        int exit = JOptionPane.showConfirmDialog(this.game,message ,"CHARGER", JOptionPane.YES_NO_OPTION) ; 
        if (exit == JOptionPane.YES_OPTION){
            // chargement de la partie 
        }
    }
    private void retour() {
        //retour sur le coup recemment jouer et rafraichissement de la page 
    }
    private void save(){
        File file = new File("./saveFolder/save.bin"); 
        if(file.exists()){
            file.delete(); 
            try {
                file.createNewFile() ;
            } catch (IOException e) {
                e.printStackTrace();
            } 
        }
        else {
            try {
                file.createNewFile() ;
            } catch (IOException e) {
                e.printStackTrace();
            } 
        }
        // ecriture dans un fichier binaire 
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file) ) ;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /*public void charger_modele () {
        Modele m = null ; 
        File file = new File("./saveFolder/save.bin"); 
        if(file.exists()){
           try {
            ObjectInputStream in = new ObjectInputStream(new FileOutputStream(file) ) ;
            //m = (Modele) in.readObject();
            //charger la ligne 
            //ensuite la colonne 
            // les données 
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } 
            catch (IOException e) {
                e.printStackTrace();
            } 
        }
        else {
            m = 
            
        }
        return m ; 


    }*/

    private void exit_dialogue (){
        String message = "Etes vous sur de vouloir quitter la partie ? " ; 
        int exit = JOptionPane.showConfirmDialog(this.fenetre,message ,"EXIT MESSAGE", JOptionPane.YES_NO_OPTION) ; 
        if (exit == JOptionPane.YES_OPTION){
            this.fenetre.dispose() ; 
        }

    }
    

}