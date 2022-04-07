package fenetre;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import modele.Direction;

/**
 * Class de gestion des differents controleur de la vue et de gestion des deplacements 
*/
public class Boutton_grille extends JButton {
    public int posX ; 
    public int posY ; 
    public Panel_jeu panel ;
    public int numero;
    /**
     * 
     * @param numero Le numero de la case correspondante 
     * @param posX le numero de ligne de la case 
     * @param posY le numero de colonne de la case 
     * @param panel une reference sur la vue , dans la mesure ou chaque case aura besoin de 
     * de savoir a tout moment si un boutton a été cliqué , si une case est selectionnée ... 
     * @see Panel_jeu
     */
    public Boutton_grille (int numero , int posX , int posY , Panel_jeu panel ){
        super("" + numero);
        this.posX = posX ; 
        this.posY = posY ; 
        this.panel = panel ;
		this.numero= numero;
        if ( numero == 0){
            this.setText("");
            this.setBackground(Color.GRAY);
        }  
        this.addActionListener((event) -> cliqued()) ;
        this.addKeyListener ( new KeyAdapter(){
			@Override 
			public void keyPressed(KeyEvent e){
				if(panel.cliqued){
					
					if(e.getKeyCode()==KeyEvent.VK_RIGHT){
						panel.grille.play(panel.boutton_cliqued.posX,panel.boutton_cliqued.posY,Direction.RIGHT);
						}
						
					else if(e.getKeyCode()==KeyEvent.VK_LEFT){
						panel.grille.play(panel.boutton_cliqued.posX,panel.boutton_cliqued.posY,Direction.LEFT);
						}
						
					else if(e.getKeyCode()==KeyEvent.VK_UP){
						panel.grille.play(panel.boutton_cliqued.posX,panel.boutton_cliqued.posY,Direction.UP);
						}
					else if(e.getKeyCode()==KeyEvent.VK_DOWN){
						panel.grille.play(panel.boutton_cliqued.posX,panel.boutton_cliqued.posY,Direction.DOWN);
						
						}
					panel.grille.fireChangement();
					panel.end_dialogue() ; // teste si le jeu est terminé .
					
					}
				
				}
			
			
			});
    
    }  
    public void cliqued(){
		if(this.numero!=0)
		{
			if(panel.cliqued){
				panel.boutton_cliqued.setBorderPainted(false);
				this.setBorder(new LineBorder(Color.BLACK, 5));
				panel.boutton_cliqued = this;
				panel.boutton_cliqued.setBorderPainted(true);
			
		}
		else {
			this.setBorder(new LineBorder(Color.BLACK, 5));
			panel.boutton_cliqued = this;
			panel.cliqued = true;
			
			}
		
		}  
		
	} 








    
}
