package view;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import model.Pedina;

public class pedinaBianca extends Casella {

Pedina pedina;
	
	public pedinaBianca(Pedina pedina){
		  this.pedina = pedina;
		  final Icon bianca= new ImageIcon("bianca.jpg");
		  
		  super.setIcon(bianca);
          
	}

	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
