package view;

import java.awt.Color;

public class CasellaVuota extends Casella {
	public int x;
	public int y;
	
    public CasellaVuota(int x, int y) {
    	
    	this.x=x;
    	this.y=y;
    	
    	if ((x+y)%2==0)
			setBackground(Color.white);
		else 
			setBackground(Color.black);
    	
    }

    public String toString() {
            return "empty";
    }

}

	

