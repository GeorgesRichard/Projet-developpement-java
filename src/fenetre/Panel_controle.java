package fenetre ;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel ;
import javax.swing.border.Border;

import org.w3c.dom.events.Event;

import java.awt.Color ;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.awt.* ; 

public class Panel_controle extends JPanel {
    private JPanel game ; 
    public Panel_controle(JPanel Game) {
        super() ; 

        this.game = Game ; 
        this.setPreferredSize(new Dimension(300 , 600)) ; 
        this.setLayout(new BorderLayout());
        
        
        JPanel control = new JPanel() ; 
        control.setPreferredSize(new Dimension(200 ,200));
        control.setLayout(new GridLayout(2,2 , 10 , 10));
        this.add(control , BorderLayout.NORTH) ; 
        
        JButton b4 = new Button_play("rafraichir.png") ;
        b4.addActionListener((event) -> rafraichir());
        JButton b2 = new Button_play("retour.png") ;
        JButton b3 = new Button_play("save.png") ;
        JButton b1 = new Button_play("play.png") ; 
        b1.addActionListener((event) -> charger_dialogue());
        b3.addActionListener((event) -> save());

        control.add(b1)  ; 
        control.add(b2); 
        control.add(b3); 
        control.add(b4); 
        
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
    /*@Override 
    public void paintComponent( Graphics g)
    }*/
    private void save(){
        File file = new File("./saveFolder/save.bin"); 
        if(file.exists()){
            file.delete(); 
            try {
                file.createNewFile() ;
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } 
            System.out.println("le fichier existe deja ");
        }
        else {
            try {
                file.createNewFile() ;
            } catch (IOException e) {
                e.printStackTrace();
            } 
        }
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file) ) ;
            //out.writeObject();
            //charger la ligne 
            //ensuite la colonne 
            // les données 
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    /* CLASS DE CHARGEMENT DU MODELE 
    public Modele charger_modele () {
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
    

}