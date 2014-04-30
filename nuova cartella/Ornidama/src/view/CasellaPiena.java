package view;
import java.awt.Color;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import model.Pedina;

public class CasellaPiena extends Casella{
	
	Pedina pedina;

    public CasellaPiena(Pedina pedina) {
//            super(String.valueOf(pedina.giocatore));

            this.pedina = pedina;
            

    		final Icon bianca= new ImageIcon("bianca.jpg");
    		final Icon nera= new ImageIcon("nera.jpg");
    		
    		
    		if (pedina.colore==1)
    			setIcon(bianca);
    		else 
    			setIcon(nera);
    }

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}


    

}
