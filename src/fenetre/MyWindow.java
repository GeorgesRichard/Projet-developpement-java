package fenetre; 
import javax.swing.* ; 
import java.awt.* ; 

public class MyWindow  extends JFrame  {

    public MyWindow () { // Constructeur de la class 
        super("Genie logicielle"); 
        this.setSize(1000 , 1000); 
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE) ; 
        this.setVisible(true);
        this.setLocationRelativeTo(null) ; 
        JPanel content= (JPanel) this.getContentPane();  
        content.setLayout(new FlowLayout()) ; 
        content.add(new Panel_jeu()) ; 
        content.add(new Panel_controle()) ; 

    }  
    public static void main ( String args[]){
        MyWindow window = new MyWindow() ; 




    }  












}