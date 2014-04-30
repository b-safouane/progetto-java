package view;
import javax.swing.JButton;


public abstract class Casella extends JButton{
	
	protected Casella() {}
	
	protected Casella (String label){
		super(label);
	}

	public abstract String toString();

}
