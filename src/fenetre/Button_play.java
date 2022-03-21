package fenetre;
import javax.swing.* ;
import javax.swing.border.LineBorder;
import java.awt.* ; 

public class Button_play  extends JButton  {
    public Button_play (String name){
        super() ; 
        this.setBackground(Color.WHITE);
        this.setIcon(new ImageIcon("./icons/"+name));
        this.setPreferredSize(new Dimension(20 , 20));
        this.setMaximumSize(new Dimension (40,40));
        this.setBorder(new LineBorder(Color.white));

        //this.addActionListener();

        
    }
    
}
