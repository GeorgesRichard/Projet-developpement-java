package fenetre;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolBar; 
import javax.swing.JFrame; 
import modele.Grille;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.awt.* ; 

/**
 * Classe de contole du jeu , elle permet de d'effectuer des taches courantes parmi lesquelles 
 * on a : charger un partie deja jouée , sauvegarder une partie
 * et bien d'autre outils. Elle herite de {@link JToolBar }
 * @author Georges Khaly Richard 
 */


public class Panel_controle extends JToolBar  {
    private Panel_jeu game ;
    private JFrame fenetre ; 
    private Grille grille ; 
    /**
     * Le constructeur va créer un creer une {@link JToolBar} contenant tous les outils de nagivation
     * @param Game Afin d'effectuer certaine modification sur les composantes de la vue , on a besoin 
     * d'un access vers ces composantes.
     * @param fenetre Utile pour quitter le jeu 
     * @param grille Permet de modifier la Grille en effectuant des operations de chargement 
     * , sauvegarde , retour ...
     */
    public Panel_controle(Panel_jeu Game , JFrame fenetre , Grille grille) {
        super() ; 
        this.setPreferredSize ( new Dimension(50 , 50)); 
        this.game = Game ;  
        this.fenetre = fenetre ; 
        this.grille = grille ; 

        JButton play = new Button_play("play.png") ; 
        play.addActionListener((event) -> charger_dialogue());

        JButton refresh = new Button_play("rafraichir.png") ;
        refresh.addActionListener((event) -> rafraichir());

        JButton save = new Button_play("save.png") ;
        save.addActionListener((event) -> save()) ; 

        JButton exit = new Button_play("exit.png") ; 
        exit.addActionListener((event) -> exit()) ; 

        this.add(play);
        this.addSeparator() ; 
        this.add(refresh); 
        this.addSeparator() ;
        this.add(save); 
        this.addSeparator() ;
        this.add(exit); 
        
    }
    /**
     * Methode qui permet de quitter une partie. Elle ne prend aucun parametre
     * Elle fait appel a la methode {@link exit_dialogue }
     * @see exit_dialogue
     */
    public void exit () {
        exit_dialogue() ; 
    }
    /**
     * Elle permet d'ouvrir une boite de dialogue en et demande confirmation à l'utilisateur 
     * Elle fait appel a la methode {@link rafraichissement}
     * @see rafraichissement
     */
    public void rafraichir() {
        String message = "Etes vous sur de vouloir refraichir la partie la partie ? " ; 
        int exit = JOptionPane.showConfirmDialog(this.game,message ," Tout reprendre ", JOptionPane.YES_NO_OPTION) ; 
        if (exit == JOptionPane.YES_OPTION){
            rafraichissement();
            this.grille.fireChangement();//on previent tout le monde qu'il ya eu un changement
        }
    }
    /**
     * Elle permet d'ouvrir une boite de dialogue qui apres confirmation , chargera la dernier partie 
     * joue par l'utilisateur.
     * Elle fait appel a la methode {@link charger_modele }.
     * @see charger_modele
     */
    public void charger_dialogue() {
        String message = "Voulez vous charger la derniere partie" ; 
        int exit = JOptionPane.showConfirmDialog(this.game,message ,"CHARGER", JOptionPane.YES_NO_OPTION) ; 
        if (exit == JOptionPane.YES_OPTION){
            Grille g = charger_modele() ; 
            this.grille.puzzle = g.puzzle ; 
            this.grille.fireChangement();
        }
    }
    /**
     * Creer une boite de dialogue qui quitte le jeu apres confirmation et effectue une 
     * sauvegarde automatique
     */
    public void exit_dialogue (){
        String message = "Etes vous sur de vouloir quitter la partie ? " ; 
        int exit = JOptionPane.showConfirmDialog(this.fenetre,message ,"EXIT MESSAGE", JOptionPane.YES_NO_OPTION) ; 
        if (exit == JOptionPane.YES_OPTION){
            this.fenetre.dispose() ; 
            save();
        }
    }
    /**
     * La methode rafraichissement() permet de demarrer une nouvelle partie de jeu 
     * Elle fait appel à la methode {@link creation} et {@link melanger} de la grille.
     * @see creation dans la class Grille 
     * @see melanger dans la class Grille 
     */
    public void rafraichissement(){
        this.grille.creation();
        this.grille.playAlea(100);
    }
    /**
     * Methode qui sauvegarde la partie courrante dans un fichier binaire 
     * Le fichier de sauvegarde est placé dans le repertoire ./saveFolder/
     * @exception Exception le traitement des fichiers peut lever des exceptions 
     * qui sont tous traitées dans la cette methode 
     */
    public void save(){
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
            out.writeObject(this.grille);
            out.close();
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Methode qui charge la dernier partie sauvegarder  
     * Le fichier de sauvegarde est placé dans le repertoire ./saveFolder/
     * @return le Grille qui a ete charger  ou null
     * @exception Exception le traitement des fichiers peut lever des exceptions 
     * qui sont tous traitées dans la cette methode 
     */
    public Grille charger_modele () {
        File file = new File("./saveFolder/save.bin"); 
        if(file.exists()){
           try {
                ObjectInputStream in = new ObjectInputStream( new FileInputStream(file) ) ;
                Grille g = (Grille)in.readObject() ;   
                g.show(); 
                in.close(); 
                return g ; 
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } 
            catch (IOException e) {
                e.printStackTrace();
            }
            catch (ClassNotFoundException e){
                e.printStackTrace();
            }          
        }
        else {
            System.out.println("Aucune sauvegarde ");
        }
        return null ; 

    }
    
    

}